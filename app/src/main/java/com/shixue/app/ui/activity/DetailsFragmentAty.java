package com.shixue.app.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jjs.Jbase.BaseFragment;
import com.jjs.Jbase.BaseFragmentActivity;
import com.jjs.Jutils.SysUtils;
import com.jjs.Jview.JtitleView;
import com.shixue.app.R;
import com.shixue.app.ui.fragment.HtmlFragment;
import com.shixue.app.ui.fragment.Personal_aboutFragment;
import com.shixue.app.ui.fragment.Personal_shapeFragment;
import com.shixue.app.ui.fragment.Personal_vipFragment;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 本页：
 * Created by jjs on 2016-11-28.
 */

public class DetailsFragmentAty extends BaseFragmentActivity {

    @Bind(R.id.title)
    JtitleView mTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        SysUtils.setSTATUScolor(this, Color.parseColor("#059B76"));
        ButterKnife.bind(this);
        init();
    }

    public static void goHtmlAty(Activity activity, String title, String url) {
        Intent intent = new Intent(activity, DetailsFragmentAty.class);
        intent.putExtra("type", "html");
        intent.putExtra("name", title);
        intent.putExtra("url", url);
        activity.startActivity(intent);
    }

    public static void goHtmlAtyForResult(Activity activity, String title, String url, int request) {
        Intent intent = new Intent(activity, DetailsFragmentAty.class);
        intent.putExtra("type", "html");
        intent.putExtra("name", title);
        intent.putExtra("url", url);
        activity.startActivityForResult(intent, request);
    }

    @Override
    protected void init() {
        String type = getIntent().getStringExtra("type");
        String name = getIntent().getStringExtra("name");
        mTitle.setTitle(name).setLeftListerner(v -> finish()).start();
        switch (type) {
            case "html":
                Bundle bundle = new Bundle();
                bundle.putString("url", getIntent().getStringExtra("url"));
                HtmlFragment html = new HtmlFragment();
                html.setArguments(bundle);
                initFragment(html);
                break;
            case "about":
                initFragment(new Personal_aboutFragment());
                break;
            case "shape":
                initFragment(new Personal_shapeFragment());
                break;
            case "vip":
                initFragment(new Personal_vipFragment());
                break;
        }

    }

    private void initFragment(BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fram_details, fragment).commit();
    }

    @Override
    protected void onResult(int request, Intent data) {

    }
}
