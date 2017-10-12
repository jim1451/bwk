package com.shixue.app.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jjs.Jbase.BaseActivity;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.shixue.app.R;
import com.shixue.app.ui.bean.PractiseDetailsResult;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;



/**
 * Created by MZ安卓 on 2016/12/7.
 */

public class Activity_Examdirectory extends BaseActivity {

    @Bind(R.id.exam_directory)
    RecyclerView mExamDirectory;
    List<PractiseDetailsResult.TestBean.ExerciseTypeBean.EcListBean> ecList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examdirectory);
        ButterKnife.bind(this);
        ecList = (List<PractiseDetailsResult.TestBean.ExerciseTypeBean.EcListBean>) getIntent().getSerializableExtra("ecList");
        init();
    }


    @Override
    protected void init() {
        setTitle("考题目录");
        mExamDirectory.setLayoutManager(new GridLayoutManager(Activity_Examdirectory.this, 5));
        SingleReAdpt singleReAdpt = new SingleReAdpt<PractiseDetailsResult.TestBean.ExerciseTypeBean.EcListBean>(Activity_Examdirectory.this, R.layout.recycler_item_examdirectory, ecList) {
            @Override
            protected void BindData(BaseReHolder holder, int position, PractiseDetailsResult.TestBean.ExerciseTypeBean.EcListBean data) {
                holder.getTV(R.id.tv_item_directy).setText(position + 1 + "");
                if (!data.getCheckABCD().equals("")|| data.isShowAnswer()) {
                    holder.getTV(R.id.tv_item_directy).setBackgroundRes(R.drawable.roundbackground).setTextColor(Color.WHITE);
                } else {
                    holder.getTV(R.id.tv_item_directy).setBackgroundRes(R.drawable.roundbackground_whilt).setTextColor(Color.BLACK);
                }

            }
        };
        mExamDirectory.setAdapter(singleReAdpt);
        singleReAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("showNum", position);
                setResult(ResultOK, intent);
                finish();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @Override
    protected void onResult(int request, Intent data) {

    }
}
