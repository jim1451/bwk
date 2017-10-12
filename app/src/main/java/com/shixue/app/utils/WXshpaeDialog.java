package com.shixue.app.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.shixue.app.APP;
import com.shixue.app.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 本页：
 * Created by jjs on 2016-12-08.
 */

public class WXshpaeDialog extends Dialog {
    public WXshpaeDialog(Context context) {
        super(context, R.style.Dialog_notBG);
        init(context);
    }

    View mView;
    Context mContext;

    private void init(Context context) {
        mContext = context;
        mView = View.inflate(context, R.layout.dialog_wxshape, null);
        mView.findViewById(R.id.img_dialog_cancel).setOnClickListener(v -> WXshpaeDialog.this.cancel());
        this.setCancelable(true);
    }


    public void show(String title, String msg, String wxNumber) {
        ((TextView) mView.findViewById(R.id.tv_dialog_title)).setText(title);

        SpannableString s = new SpannableString(msg);
        Pattern p = Pattern.compile(wxNumber);
        Matcher m = p.matcher(s);
        while (m.find()) {
            int start = m.start();
            int end = m.end();
            s.setSpan(new ForegroundColorSpan(Color.parseColor("#059B76")), start, end,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        ((TextView) mView.findViewById(R.id.tv_dialog_msg)).setText(s);

        mView.findViewById(R.id.tv_dialog_left).setOnClickListener(v -> {
            ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setPrimaryClip(ClipData.newPlainText("data", wxNumber));
            APP.mToast("复制微信号成功");
            WXshpaeDialog.this.cancel();
        });
//        mView.findViewById(R.id.tv_dialog_right).setOnClickListener(v -> {
//            DetailsFragmentAty.goHtmlAty((Activity) mContext, "活动详情", wxBean.getOperateUrl());
//
//        });

        WXshpaeDialog.this.setContentView(mView);
        WXshpaeDialog.this.show();
        WindowManager windowManager = ((Activity) mContext).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = WXshpaeDialog.this.getWindow().getAttributes();
        lp.width = (int) (display.getWidth());
        WXshpaeDialog.this.getWindow().setAttributes(lp);
    }

}
