package com.shixue.app.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jjs.Jbase.BaseActivity;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.jjs.Jview.JtitleView;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.ui.bean.PractiseDetailsResult;
import com.shixue.app.utils.L;
import com.shixue.app.utils.SweetDialog;
import com.zhy.autolayout.AutoLinearLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 本页：做题
 * Created by jjs on 2016-12-05.
 */

public class Practise_DetailsAty extends BaseActivity {
    @Bind(R.id.tv_size)
    TextView mTvSize;
    @Bind(R.id.prog_size)
    ProgressBar mProgSize;
    @Bind(R.id.tv_type)
    TextView mTvType;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.rv_oneCheck)
    RecyclerView mRvOneCheck;
    @Bind(R.id.tv_show)
    TextView mTvShow;
    @Bind(R.id.img_answer_type)
    ImageView mImgAnswerType;
    @Bind(R.id.tv_answer_type)
    TextView mTvAnswerType;
    @Bind(R.id.tv_answer_msg)
    TextView mTvAnswerMsg;
    @Bind(R.id.img_answer_pictrue)
    ImageView mImgAnswerPictrue;
    @Bind(R.id.tv_last)
    TextView mTvLast;
    @Bind(R.id.tv_next)
    TextView mTvNext;
    @Bind(R.id.ll_answer)
    AutoLinearLayout mLl_answer;
    @Bind(R.id.line_answer)
    AutoLinearLayout mLine_answer;
    @Bind(R.id.img_titleImg)
    ImageView mImgTitleImg;

    int testId = 0;//试卷id
    PractiseDetailsResult.TestBean mTestBean;//试卷内容
    List<PractiseDetailsResult.TestBean.ExerciseTypeBean.EcListBean> ecList;//所有试卷的内容
    SingleReAdpt singleReAdpt;
    private int exerciseType = 0;//用于判断练题模式
    List<String> daanList = new ArrayList<>();
    SweetDialog progess;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise_info);
        ButterKnife.bind(this);
        testId = getIntent().getIntExtra("testId", 0);
        exerciseType = getIntent().getIntExtra("ExType", 0);
        if (exerciseType == 0) {
            setTitle("练习模式");
        } else if (exerciseType == 1) {
            setTitle("背题模式");
        } else if (exerciseType == 2) {
            setTitle("真题模式");
        }
        progess = new SweetDialog(Practise_DetailsAty.this, SweetDialog.PROGRESS_TYPE).setTitleText("加载中...");
        progess.show();
        Log.e("testId", testId + "");
        APP.apiService.getPractiseDetails(testId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<PractiseDetailsResult>() {
                    @Override
                    protected void _onNext(PractiseDetailsResult practiseDetailsResult) {
                        mTestBean = practiseDetailsResult.getTest();
                        init();
                    }

                    @Override
                    protected void _onError(String msg) {
                        Log.e("testId", msg + "");


                        APP.mToast(msg);
                        progess.cancel();
                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (exerciseType == 0) {
            title.setTitle(titleText).setShow(false, true, true, false).setRightText("交卷").setRightListerner(new JtitleView.OnRightListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(Practise_DetailsAty.this, Activity_practice_report.class);
                    intent1.putExtra("ecList", (Serializable) ecList);
                    startActivityForResult(intent1, 2);
                    for (int i = 0; i < ecList.size(); i++) {
                        if (!ecList.get(i).getCheckABCD().equals("") && !ecList.get(i).isShowAnswer()) {
                            //不为空,强制显示
                            APP.shared.edit().putString(APP.userInfo.getBody().getUser().getUserid() + "-" + ecList.get(i).getExerciseContentId(), ecList.get(i).getCheckABCD() + "-true").commit();
                        }
                    }
                    init();
                }
            }).start();
        }
    }

    private int showNum = 0;

    @Override
    protected void init() {
        ecList = new ArrayList<>();
        //添加所有题目
        for (int i = 0; i < mTestBean.getExerciseType().size(); i++) {
            if (mTestBean.getExerciseType().get(i).getEcList().size() > 0) {
                for (int j = 0; j < mTestBean.getExerciseType().get(i).getEcList().size(); j++) {
                    PractiseDetailsResult.TestBean.ExerciseTypeBean.EcListBean ecListBean = mTestBean.getExerciseType().get(i).getEcList().get(j);
                    ecListBean.setExerciseType(mTestBean.getExerciseType().get(i).getExerciseType());
                    StringBuffer buffer = new StringBuffer(mTestBean.getExerciseType().get(i).getExerciseName());
                    ecListBean.setExerciseName(buffer.delete(0, 2).toString());
                    if (exerciseType == 1) {
                        //背题模式
                        ecListBean.setCheckABCD(ecListBean.getRightAnswer());
                        ecListBean.setShowAnswer(true);
                    } else {
                        //练习模式
                        String oldDATA = APP.shared.getString(APP.userInfo.getBody().getUser().getUserid() + "-" + mTestBean.getExerciseType().get(i).getEcList().get(j).getExerciseContentId(), "-false");
                        String[] oldARR = oldDATA.split("-");
                        ecListBean.setCheckABCD(oldARR[0]);
                        ecListBean.setShowAnswer(Boolean.parseBoolean(oldARR[1]));
                    }
                    ecList.add(ecListBean);
                }
            }
        }
        progess.cancel();
        //设置分式百分比
        mProgSize.setMax(ecList.size());
        mRvOneCheck.setLayoutManager(new LinearLayoutManager(Practise_DetailsAty.this));
        singleReAdpt = new SingleReAdpt<String>(Practise_DetailsAty.this, R.layout.recycler_exercice_item, daanList) {
            @Override
            protected void BindData(BaseReHolder holder, int position, String data) {
                StringBuffer buffer = new StringBuffer(data);
                String questio = buffer.delete(0, 2).toString();
                holder.getTV(R.id.tv_choice).setText(questio.replace("\n", ""));
                holder.getTV(R.id.chocie).setText(INT2ABC(position));
                if (ecList.get(showNum).getCheckABCD().contains(((TextView) holder.getView(R.id.chocie)).getText().toString().trim())) {
                    holder.getTV(R.id.chocie).setBackgroundRes(R.drawable.shape_round_blue).setTextColor(Color.WHITE);
                } else {
                    holder.getTV(R.id.chocie).setBackgroundRes(R.drawable.shape_round_white).setTextColor(Color.BLACK);
                }
            }
        };
        mRvOneCheck.setAdapter(singleReAdpt);
        singleReAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (ecList.get(showNum).isShowAnswer()) return;
                if (exerciseType == 0) {
                    //练习
                    ecList.get(showNum).setCheckABCD(getCheck(position));//保存选中的答案
                    ChangeInfo();
                } else if (exerciseType == 1) {
                    //背题
                } else if (exerciseType == 2 && !ecList.get(showNum).isShowAnswer()) {
                    //真题
                    ecList.get(showNum).setCheckABCD(getCheck(position));//保存选中的答案
                    ChangeInfo();
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        ChangeInfo();
    }

    private String getCheck(int position) {
        if (ecList.get(showNum).getExerciseType() == 0) return INT2ABC(position);
        String newCheck = INT2ABC(position);//新点击的项
        String oldCheck = ecList.get(showNum).getCheckABCD();//原有的项
        String buffCheck = "";//拼接选中项
        for (int i = 0; i < ecList.get(showNum).getOption().size(); i++) {
            if (oldCheck.contains(INT2ABC(i)) && !newCheck.equals(INT2ABC(i)) || !oldCheck.contains(INT2ABC(i)) && newCheck.equals(INT2ABC(i))) {
                //已经存在但未被点击需添加，不存在但是新点击了需添加
                buffCheck += INT2ABC(i);
            }
        }
        return buffCheck;
    }

    private String INT2ABC(int position) {
        String checkABCD = null;
        switch (position) {
            case 0:
                checkABCD = "A";
                break;
            case 1:
                checkABCD = "B";
                break;
            case 2:
                checkABCD = "C";
                break;
            case 3:
                checkABCD = "D";
                break;
            case 4:
                checkABCD = "E";
                break;
            case 5:
                checkABCD = "F";
                break;
            case 6:
                checkABCD = "G";
                break;
            case 7:
                checkABCD = "H";
                break;
            case 8:
                checkABCD = "I";
                break;
            case 9:
                checkABCD = "J";
                break;
            case 10:
                checkABCD = "K";
                break;
        }
        return checkABCD;
    }

    @Override
    protected void onResult(int request, Intent data) {
        if (request == 1) {
            showNum = data.getIntExtra("showNum", 0);
            ChangeInfo();
        }
        if (request == 2) {
            showNum = 0;
            setResult(ResultOK);
            init();
            // ChangeInfo();
        }
    }

    @OnClick({R.id.tv_show, R.id.tv_last, R.id.img_showAll, R.id.tv_next})
    public void onClick(View view) {
        if (ecList == null || ecList.size() < 1) return;

        switch (view.getId()) {
            case R.id.tv_show:
                //查看答案
                ecList.get(showNum).setShowAnswer(true);
                ChangeInfo();
                break;
            case R.id.img_showAll:
                //跳转显示所有题目
                Intent intent = new Intent(Practise_DetailsAty.this, Activity_Examdirectory.class);
                intent.putExtra("ecList", (Serializable) ecList);
                startActivityForResult(intent, 1);
                break;
            case R.id.tv_last:
                //上一题
                showNum--;
                ChangeInfo();
                break;
            case R.id.tv_next:
                /*如果为练习模式最后一题，下一题按钮需要改为交卷，并且背景颜色发生改变*/
                //下一题
                if (mTvNext.getText().toString().trim().equals("下一题")) {
                    showNum++;
                    ChangeInfo();
                } else {

                }
                break;
        }
    }

    //更换适配器和数据的方法
    private void ChangeInfo() {
        //保存数据到本地shared
        //key拼接：用户id+题目id
        //value拼接：选中答案+是否已查看答案
        if (exerciseType == 0) {
            if (ecList.get(showNum).isShowAnswer() || !ecList.get(showNum).getCheckABCD().equals("")) {
                if (APP.shared.getString(APP.userInfo.getBody().getUser().getUserid() + "-" + ecList.get(showNum).getExerciseContentId(), "").equals("")) {
                    int oldInt = APP.shared.getInt(APP.userInfo.getBody().getUser().getUserid() + "-" + ecList.get(showNum).getTestId(), 0) + 1;
                    APP.shared.edit().putInt(APP.userInfo.getBody().getUser().getUserid() + "-" + ecList.get(showNum).getTestId(), oldInt).commit();
                    setResult(ResultOK);
                }
                APP.shared.edit().putString(APP.userInfo.getBody().getUser().getUserid() + "-" + ecList.get(showNum).getExerciseContentId(), ecList.get(showNum).getCheckABCD() + "-" + ecList.get(showNum).isShowAnswer()).commit();
            }
        }
        if (showNum == 0) {
            mTvLast.setVisibility(View.INVISIBLE);
        } else {
            mTvLast.setVisibility(View.VISIBLE);
        }
        if (showNum == ecList.size() - 1) {
            mTvNext.setVisibility(View.INVISIBLE);
        } else {
            if (mTvNext.getVisibility() == View.INVISIBLE)
                mTvNext.setVisibility(View.VISIBLE);
            mTvNext.setText("下一题");
        }
        //控制图片的显示
        if (ecList.get(showNum).getExerciseContentPicture() != null && !ecList.get(showNum).getExerciseContentPicture().equals("")) {
            mImgTitleImg.setVisibility(View.VISIBLE);
            Glide.with(this).load(APP.picUrl + ecList.get(showNum).getExerciseContentPicture()).into(mImgTitleImg);
        } else {
            mImgTitleImg.setVisibility(View.GONE);
        }
        //由showNum 来控制显示的数据,从ecList中取值
        mTvSize.setText(showNum + 1 + "/" + ecList.size());//显示题目数量
        mTvTitle.setText(ecList.get(showNum).getExerciseContent());//显示题目问题
        mTvType.setText(ecList.get(showNum).getExerciseName());//显示题目类型
        mProgSize.setProgress(showNum + 1);//显示进度条进度
        if (ecList.get(showNum).getExerciseType() == 0 || ecList.get(showNum).getExerciseType() == 1) {
            //1单选题（判断）,2多选
            mRvOneCheck.setVisibility(View.VISIBLE);
            mLine_answer.setVisibility(View.VISIBLE);//显示对错标识
            if (ecList.get(showNum).isShowAnswer()) {
                //是否显示答案
                mLl_answer.setVisibility(View.VISIBLE);
                mTvShow.setVisibility(View.GONE);
                //还要判断直接查看答案的时候
                L.e("ABCD---" + ecList.get(showNum).getCheckABCD() + "----" + ecList.get(showNum).getRightAnswer() + "---");
                if (ecList.get(showNum).getCheckABCD().equals(ecList.get(showNum).getRightAnswer())) {
                    if (exerciseType == 1) {
                        mTvAnswerType.setText("正确答案为 " + ecList.get(showNum).getRightAnswer());
                    } else {
                        mTvAnswerType.setText("答对了，正确答案为 " + ecList.get(showNum).getRightAnswer());
                    }

                    mImgAnswerType.setImageResource(R.drawable.icon20);
                } else {
                    mImgAnswerType.setVisibility(View.VISIBLE);
                    if (ecList.get(showNum).getCheckABCD().equals("")) {
                        mTvAnswerType.setText("正确答案为 " + ecList.get(showNum).getRightAnswer());
                    } else {
                        mTvAnswerType.setText("答错了，正确答案为 " + ecList.get(showNum).getRightAnswer());
                    }
                    mImgAnswerType.setImageResource(R.drawable.icon19);

                }
                mTvAnswerMsg.setText(ecList.get(showNum).getAnswerAnalysis());//显示答案解析
                if (ecList.get(showNum).getExerciseAnswerPicture() != null && ecList.get(showNum).getExerciseAnswerPicture().length() > 0) {
                    Glide.with(this).load(APP.picUrl + ecList.get(showNum).getExerciseAnswerPicture()).into(mImgAnswerPictrue);
                    mImgAnswerPictrue.setVisibility(View.VISIBLE);
                } else {
                    mImgAnswerPictrue.setVisibility(View.GONE);
                }


            } else {
                mLl_answer.setVisibility(View.GONE);
                mTvShow.setVisibility(View.VISIBLE);
            }
            if (ecList.get(showNum).getOption() != null && ecList.get(showNum).getOption().size() > 0) {
                daanList = ecList.get(showNum).getOption();
                singleReAdpt.setData(daanList);
            } else {
                daanList = new ArrayList<>();
                String str = ecList.get(showNum).getOptionss();
                if (str.equals(";") || str.equals(";;") || str.equals(";;;") || str.equals(";;;;")) {
                    for (int i = 0; i < str.length() + 1; i++) {
                        daanList.add("");
                    }
                } else {
                    String[] strARR = str.split(";");
                    for (int i = 0; i < strARR.length; i++) {
                        daanList.add(strARR[i] + "");
                    }
                }
                singleReAdpt.setData(daanList);
            }
        } else {
            //其他题目
            mRvOneCheck.setVisibility(View.GONE);
            mLine_answer.setVisibility(View.GONE);//显示对错标识
            if (ecList.get(showNum).isShowAnswer()) {
                mTvShow.setVisibility(View.GONE);
                mLl_answer.setVisibility(View.VISIBLE);
                mTvAnswerMsg.setText(ecList.get(showNum).getAnswerAnalysis());
                if (ecList.get(showNum).getExerciseAnswerPicture() != null && ecList.get(showNum).getExerciseAnswerPicture().length() > 0) {
                    Glide.with(this).load(APP.picUrl + ecList.get(showNum).getExerciseAnswerPicture()).into(mImgAnswerPictrue);
                    mImgAnswerPictrue.setVisibility(View.VISIBLE);
                } else {
                    mImgAnswerPictrue.setVisibility(View.GONE);
                }
            } else {
                mTvShow.setVisibility(View.VISIBLE);
                mLl_answer.setVisibility(View.GONE);
            }
        }
    }
}
