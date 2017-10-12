package com.shixue.app.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jjs.Jbase.BaseActivity;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.jjs.Jview.JtitleView;
import com.shixue.app.APP;
import com.shixue.app.R;
import com.shixue.app.ui.bean.PractiseDetailsResult;
import com.shixue.app.utils.RoundProgressBar;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by MZ安卓 on 2016/12/8.
 * 得到总题数  错误的题数 以及题目正确与否的标识
 */

public class Activity_practice_report extends BaseActivity {
    @Bind(R.id.true_perfent)
    TextView truePerfent;
    @Bind(R.id.progress_practice)
    RoundProgressBar progressPractice;
    @Bind(R.id.recycler_practice)
    RecyclerView recyclerPractice;
    @Bind(R.id.look_answer)
    TextView lookAnswer;
    @Bind(R.id.angain_exerce)
    TextView angainExerce;
    @Bind(R.id.title)
    JtitleView title;
    @Bind(R.id.tv_total)
    TextView tvTotal;
    private int SuccessNum = 0;//正确的题目数
    private int AllNum = 0;//单选题总数
    List<PractiseDetailsResult.TestBean.ExerciseTypeBean.EcListBean> ecList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_report);
        ButterKnife.bind(this);
        setTitle("练题报告");
        init();
    }

    @Override
    protected void init() {
        ecList = (List<PractiseDetailsResult.TestBean.ExerciseTypeBean.EcListBean>) getIntent().getSerializableExtra("ecList");
        if (ecList == null) {
            APP.mToast("获取题目列表失败");
            return;
        }
        AllNum = ecList.size();
        for (int i = 0; i < ecList.size(); i++) {
            Log.e("answer", ecList.get(i).getRightAnswer() + "     " + ecList.get(i).getCheckABCD());

            if (ecList.get(i).getRightAnswer().equals(ecList.get(i).getCheckABCD())
                    && !ecList.get(i).getRightAnswer().isEmpty() && !ecList.get(i).getCheckABCD().isEmpty()) {
                SuccessNum++;
            }
        }
        progressPractice.setMax(ecList.size());//设置最大进度
        progressPractice.setProgress(SuccessNum);//根据正确的题数社设置进度（为0时不显示百分比，所以上面需要显隐藏一个0%）

        tvTotal.setText(" ( " + SuccessNum + "/" + AllNum + " )");
        recyclerPractice.setLayoutManager(new GridLayoutManager(Activity_practice_report.this, 5));
        SingleReAdpt singleReAdpt = new SingleReAdpt<PractiseDetailsResult.TestBean.ExerciseTypeBean.EcListBean>(Activity_practice_report.this, R.layout.recycler_item_examdirectory, ecList) {
            @Override
            protected void BindData(BaseReHolder holder, int position, PractiseDetailsResult.TestBean.ExerciseTypeBean.EcListBean data) {
                holder.getTV(R.id.tv_item_directy).setText(position + 1 + "");
                if (data.getCheckABCD().equals("") && !data.isShowAnswer()) {
                    holder.getTV(R.id.tv_item_directy).setBackgroundRes(R.drawable.roundbackground_whilt);
                } else if (data.getCheckABCD().equals(data.getRightAnswer())) {
                    holder.getTV(R.id.tv_item_directy).setBackgroundRes(R.drawable.shape_round_blue).setTextColor(Color.WHITE);
                } else {
                    holder.getTV(R.id.tv_item_directy).setBackgroundRes(R.drawable.roundbackground_red).setTextColor(Color.WHITE);
                }
            }
        };
        recyclerPractice.setAdapter(singleReAdpt);
    }

    @Override
    protected void onResult(int request, Intent data) {

    }

    @OnClick({R.id.true_perfent, R.id.look_answer, R.id.angain_exerce})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.true_perfent:
                break;
            case R.id.look_answer://查看答案
                setResult(ResultOK);
                finish();
                break;
            case R.id.angain_exerce://再次练题
                APP.shared.edit().remove(APP.userInfo.getBody().getUser().getUserid() + "-" + ecList.get(0).getTestId()).commit();
                setResult(ResultOK);
                for (int i = 0; i < ecList.size(); i++) {
                    APP.shared.edit().remove(APP.userInfo.getBody().getUser().getUserid() + "-" + ecList.get(i).getExerciseContentId()).commit();
                }
                finish();
                break;
        }
    }
}
