package com.shixue.app.sqilte;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.util.StateSet;

import com.shixue.app.ui.bean.VideoMessageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘荣芳 on 2017/11/17.
 * 对本地数据库进行增删改查功能
 */

public class MySqlite {

    private static List<VideoMessageBean> mList = new ArrayList<>();

    /**
     * 往直播聊天列表中插入数据
     */
    public static void insertIntoMessage(SQLiteDatabase sql, String userId, String name, String chatText, String richText, String messageID, String query) {
        Log.e("insertIntoMessage", chatText + "     " + messageID);
        Log.e("void", "insertIntoMessage");
        sql.execSQL("insert into message(userId,name,chatText,richText,messageID,query) values (?,?,?,?,?,?)", new String[]{userId, name, chatText, richText, messageID, query});
    }

    /**
     * 根据查询所有聊天数据
     */

    public static List<VideoMessageBean> getAllMessageVideo(SQLiteDatabase sql, String query) {
        if (mList != null) {
            mList.clear();
        }
        Cursor cursor = sql.rawQuery("select * from message where query=?", new String[]{query});
        while (cursor.moveToNext()) {
            //        String OnLineChat = "create table message(id Integer primary key autoincrement,userId,name,chatText,richText,messageID) ";
            VideoMessageBean videoMessageBean = new VideoMessageBean();
            videoMessageBean.setId(Long.parseLong(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1)))));
            videoMessageBean.setName(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2))));
            videoMessageBean.setChatText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(3))));
            videoMessageBean.setRichText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(4))));
            int MessageId = Integer.parseInt(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(5))));
            videoMessageBean.setMessageID(MessageId);
            mList.add(videoMessageBean);
        }
        return mList;

    }

    //删除数据
    public static void deleteMessage(SQLiteDatabase sql, String userId) {
        try {
            Log.e("void", "deleteMessage");
            sql.execSQL("delete from message where userId = ?", new String[]{userId});
            Log.e("deleteMessage", "删除成功" + userId);
        } catch (Exception x) {
            Log.e("deleteMessage", "删除失败");

        }
    }


}


