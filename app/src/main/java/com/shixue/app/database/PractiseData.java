package com.shixue.app.database;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * 本页：试题状态数据表
 * Created by jjs on 2016-12-16.
 */
@Table(name = "Practise")
public class PractiseData {
    @Column(name = "id", isId = true)
    private int id;
    @Column(name = "tag")
    String tag;
    @Column(name = "isShowAnswer")
    boolean isShowAnswer;
    @Column(name = "checkABCD")
    String checkABCD;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isShowAnswer() {
        return isShowAnswer;
    }

    public void setShowAnswer(boolean showAnswer) {
        isShowAnswer = showAnswer;
    }

    public String getCheckABCD() {
        return checkABCD;
    }

    public void setCheckABCD(String checkABCD) {
        this.checkABCD = checkABCD;
    }
}
