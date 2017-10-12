package com.shixue.app.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.shixue.app.R;


/**
 * Created by MZ安卓 on 2016/11/25.
 */

public class MyDialog extends Dialog {
    Context mContext;
    View view;
    ImageView cancel;//关闭
    TextView title;
    TextView message;
    TextView check;
    RecyclerView rvList;
    boolean hasCancel = true;
  static   boolean isShow = false;//是否显示

    public MyDialog(Context context) {
        super(context, R.style.Dialog_notBG);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        view = View.inflate(context, R.layout.dialog_view, null);
        cancel = (ImageView) view.findViewById(R.id.img_dialog_cancel);
        title = (TextView) view.findViewById(R.id.tv_dialog_title);
        message = (TextView) view.findViewById(R.id.tv_dialog_msg);
        check = (TextView) view.findViewById(R.id.tv_dialog_check);
        rvList = (RecyclerView) view.findViewById(R.id.rv_dialog_list);
        cancel.setOnClickListener(v -> MyDialog.this.cancel());
        check.setOnClickListener(v -> {
            if (mCheckListener != null) {
                mCheckListener.OnCheck(MyDialog.this);
            }
            MyDialog.this.cancel();
        });
        view.findViewById(R.id.ll_dialog_bg).setOnClickListener(v -> {
            if (hasCancel) {
                MyDialog.this.cancel();
            }
        });
        view.findViewById(R.id.ll).setOnClickListener(v -> {
        });
        this.setOnCancelListener(dialog -> isShow = false);
    }

    public interface AddRvData {
        void addRvData(RecyclerView rv);
    }
    public zTypeLIST setTypeLIST() {
        return new zTypeLIST();
    }

    public class zTypeLIST {
        public zTypeLIST setTitleTxt(String titleTxt) {
            title.setText(titleTxt);
            title.setVisibility(View.VISIBLE);
            return this;
        }

        public zTypeLIST setRvListData(AddRvData rvListData) {
            if (rvListData != null) {
                rvListData.addRvData(rvList);
                rvList.setVisibility(View.VISIBLE);
            }
            return this;
        }

        public zTypeLIST setCheckTxt(String checkTxt, OnCheckListener checkListener) {
            check.setText(checkTxt);
            check.setVisibility(View.VISIBLE);
            mCheckListener = checkListener;
            return this;
        }

        public zTypeLIST setCancelable(boolean cancelable) {
            MyDialog.this.setCancelable(cancelable);
            hasCancel = cancelable;
            return this;
        }

        public void show() {
            if (mContext != null && !isShow) {
                MyDialog.this.setContentView(view);
                MyDialog.this.show();
                isShow = true;
            }
            WindowManager windowManager = ((Activity) mContext).getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            WindowManager.LayoutParams lp = MyDialog.this.getWindow().getAttributes();
            lp.width = (int) (display.getWidth());
            MyDialog.this.getWindow().setAttributes(lp);
        }
    }


    public zTypeNOMAL setTypeNOMAL() {
        return new zTypeNOMAL();
    }

    public class zTypeNOMAL {
        public zTypeNOMAL setTitleTxt(String titleTxt) {
            title.setText(titleTxt);
            title.setVisibility(View.VISIBLE);
            return this;
        }

        public zTypeNOMAL setMessageTxt(String messageTxt) {
            message.setText(messageTxt);
            message.setVisibility(View.VISIBLE);
            return this;
        }

        public zTypeNOMAL setMessageTxt(CharSequence messageTxt) {
            message.setText(messageTxt);
            message.setVisibility(View.VISIBLE);
            return this;
        }

        public zTypeNOMAL setCheckTxt(String checkTxt, OnCheckListener checkListener) {
            Log.e("MyDialog___","---1111");
            check.setText(checkTxt);
            check.setVisibility(View.VISIBLE);
            mCheckListener = checkListener;
            return this;
        }

        public zTypeNOMAL setCancelable(boolean cancelable) {
            MyDialog.this.setCancelable(cancelable);
            hasCancel = cancelable;
            return this;
        }

        public void show() {
            Log.e("MyDialog___","---222");

            if (mContext != null && !isShow) {
                MyDialog.this.setContentView(view);
                MyDialog.this.show();
                isShow = true;
            }
            WindowManager windowManager = ((Activity) mContext).getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            WindowManager.LayoutParams lp = MyDialog.this.getWindow().getAttributes();
            lp.width = (int) (display.getWidth());
            MyDialog.this.getWindow().setAttributes(lp);
        }


    }

    OnCheckListener mCheckListener;

    public interface OnCheckListener {
        void OnCheck(MyDialog myDialog);
    }


}
