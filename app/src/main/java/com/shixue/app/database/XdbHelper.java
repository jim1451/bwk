package com.shixue.app.database;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * 本页：
 * Created by jjs on 2016-12-16.
 */

public class XdbHelper {
    private DbManager.DaoConfig daoConfig;
    private static DbManager db;
    private final String DB_NAME = "practiseDB";
    private final int VERSION = 1;

    private XdbHelper() {
        daoConfig = new DbManager.DaoConfig()
                .setDbName(DB_NAME)
                .setDbVersion(VERSION)
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        db.getDatabase().enableWriteAheadLogging();
                        //开启WAL, 对写入加速提升巨大(作者原话)
                    }
                })
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        //数据库升级操作
                    }
                });
        db = x.getDb(daoConfig);
    }

    public static DbManager getInstance() {
        if (db == null) {
            XdbHelper xdbHelper = new XdbHelper();
        }
        return db;
    }
}
