package com.shixue.app.model;

import android.content.Context;
import android.widget.ImageView;

import com.jjs.Jbase.BaseModel;
import com.jjs.Jview.JviewPager;
import com.shixue.app.contract.WelcomeContract;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者：JJS
 * 日期：2016-11-18
 * QQ：994462623
 */

public class WelcomeModel extends BaseModel<WelcomeContract.View> implements WelcomeContract.Model{
    List<ImageView> imgs = new ArrayList<>();
    public WelcomeModel(Context context, WelcomeContract.View view) {
        super(context, view);
    }


    @Override
    public void addPagerImages(JviewPager jvp, int[] imgARR) {
        for (int i = 0; i < imgARR.length; i++) {
            ImageView img = new ImageView(mContext);
            img.setImageResource(imgARR[i]);
            imgs.add(img);
        }
        jvp.setPagerImages(imgs).start();
    }

    @Override
    public void getWindowDisplay() {
       /* WindowManager m = ((Activity)mContext).getWindowManager();
        Display d = m.getDefaultDisplay();
        APP.windowWidth = d.getWidth();
        APP.windowHeight = d.getHeight();*/

       /* DisplayMetrics dm = new DisplayMetrics();
         //获取屏幕信息
               getWindowManager().getDefaultDisplay().getMetrics(dm);
        4
        5         int screenWidth = dm.widthPixels;
        6
        7         int screenHeigh = dm.heightPixels;*/
    }
}
