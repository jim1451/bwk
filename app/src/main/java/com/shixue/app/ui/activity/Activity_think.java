package com.shixue.app.ui.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jjs.Jbase.BaseActivity;
import com.shixue.app.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;


/**
 * Created by MZ安卓 on 2016/11/30.
 */

public class Activity_think extends BaseActivity {
    private ImageButton imageButton;
    private TextView tv_openCrame, tv_Choice_photo, tv_cancel;
    private Dialog mydialog;
    private static final int PHOTO_REQUEST_CAREMA = 111;
    private static final int PHOTO_REQUEST_GALLERY = 222;
    private static final int PHOTO_REQUEST_CUT = 333;
    private static final String PHOTO_FILE_NAME = "photo_bwk.jpg";
    private File tempFile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_think);
        init();
        changeTheme();
        File file = new File(Activity_think.this.getFilesDir(), "bwk.jpg");
        if (file.exists()) {
            imageButton.setImageURI(Uri.fromFile(file));
        }
    }

    @Override
    protected void init() {
        setTitle("意见反馈");
        imageButton = (ImageButton) findViewById(R.id.btn_img);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropdown();
            }
        });
    }

    @Override
    protected void onResult(int request, Intent data) {

    }

    @Override
    protected void onActivityResult(int request, int resultCode, Intent data) {
        super.onActivityResult(request, resultCode, data);
        if(request == PHOTO_REQUEST_GALLERY){
            if(data!=null){
                System.out.println("----------");
                //获得图片路径
                Uri uri = data.getData();
                crop(uri);
            }
        }else if(request == PHOTO_REQUEST_CAREMA){
            if(Environment.getExternalStorageState().equals(
                    Environment.MEDIA_MOUNTED)){
                crop(Uri.fromFile(tempFile));
            }
        }else if(request == PHOTO_REQUEST_CUT){//进行剪切之后的处理
            if(data!=null){
                Bitmap bitmap = data.getParcelableExtra("data");
                imageButton.setImageBitmap(bitmap);
                // 保存图片到internal storage
                FileOutputStream outputStream;
                try {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);//压缩
                    out.flush();
                    outputStream = Activity_think.this.openFileOutput("bwk.jpg", Context.MODE_PRIVATE);
                    out.writeTo(outputStream);
                    out.close();
                    outputStream.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(tempFile!=null&&tempFile.exists()){//判断文件是否存在并及时删除文件
                        tempFile.delete();
                    }
                }catch (Exception ex){

                }
            }
        }


    }

    //底部弹出框
    private void dropdown() {
          mydialog = new Dialog(this, R.style.dialog_OpnePic);
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
        tv_openCrame = (TextView) root.findViewById(R.id.tv_open_camera);
        tv_Choice_photo = (TextView) root.findViewById(R.id.tv_choose_img);
        tv_cancel = (TextView) root.findViewById(R.id.tv_cancel);
        tv_openCrame.setOnClickListener(onClickListene);
        tv_Choice_photo.setOnClickListener(onClickListene);
        tv_cancel.setOnClickListener(onClickListene);
        mydialog.setContentView(root);
        Window dialogwindow = mydialog.getWindow();
        dialogwindow.setGravity(Gravity.BOTTOM);
        dialogwindow.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        dialogwindow.setWindowAnimations(R.style.anim_dialog_pics);
        mydialog.show();
    }

private View.OnClickListener onClickListene = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_open_camera://拍照
                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(Environment.getExternalStorageState().equals(
                        Environment.MEDIA_MOUNTED)){//判断是否存在内存卡
                    tempFile = new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME);
                    Uri uri = Uri.fromFile(tempFile);
                    intent1.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startActivityForResult(intent1,PHOTO_REQUEST_CAREMA);

                }else{

                }
                mydialog.dismiss();
                break;
            case R.id.tv_choose_img://相册选择
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,PHOTO_REQUEST_GALLERY);
                mydialog.dismiss();
                break;
            case R.id.tv_cancel:
                mydialog.dismiss();
                break;
        }
    }
};
    //对图片进行剪切的方法
    private void crop(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }
    private void changeTheme() {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
        if (c.get(Calendar.HOUR_OF_DAY) < 18 && c.get(Calendar.HOUR_OF_DAY) >= 6) {
            imageButton.setImageResource(R.drawable.ic_launcher);
        } else {
            imageButton.setImageResource(R.drawable.ic_launcher);
        }
    }
}
