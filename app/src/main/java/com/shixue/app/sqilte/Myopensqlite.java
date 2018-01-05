package com.shixue.app.sqilte;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MZ安卓 on 2017/11/17.
 * 本地存储
 */

public class Myopensqlite extends SQLiteOpenHelper {
    /**
     * 先创建一张表 包含表名 以及字段名
     */

    String OnLineChat = "create table message(id Integer primary key autoincrement,userId,name,chatText,richText,messageID,query) ";

    public Myopensqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(OnLineChat);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
