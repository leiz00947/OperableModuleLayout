package com.kzax1l.oml;

import android.app.Application;

import com.kzax1l.oml.dao.ModuleItem;
import com.kzax1l.oml.dao.ModuleManager;
import com.kzax1l.oml.db.OMLSqlHelper;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class OMLApplication extends Application implements OMLManager, OMLDataProvider {
    private OMLSqlHelper mSqlHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        OMLInitializer.initialize(this);
    }

    /**
     * 获取数据库Helper
     */
    @Override
    public OMLSqlHelper getSQLHelper() {
        if (mSqlHelper == null)
            mSqlHelper = new OMLSqlHelper(this);
        return mSqlHelper;
    }

    @Override
    public void onTerminate(OMLSqlHelper sqlHelper) {
        super.onTerminate();
        if (sqlHelper != null) {
            sqlHelper.close();
        }
        //整体摧毁的时候调用这个方法
    }

    @Override
    public ModuleManager getModuleManager() {
        return ModuleManager.getManager(getSQLHelper(), this);
    }

    @Override
    public List<ModuleItem> available() {
        List<ModuleItem> defaultModules = new ArrayList<>();
        defaultModules.add(new ModuleItem("推荐", "tj", 1, 1));
        defaultModules.add(new ModuleItem("热点", "rd", 2, 1));
        defaultModules.add(new ModuleItem("杭州", "hz", 3, 1));
        defaultModules.add(new ModuleItem("时尚", "ss", 4, 1));
        defaultModules.add(new ModuleItem("科技", "kj", 5, 1));
        defaultModules.add(new ModuleItem("体育", "ty", 6, 1));
        defaultModules.add(new ModuleItem("军事", "js", 7, 1));
        defaultModules.add(new ModuleItem("娱乐", "yl", 12, 0));
        return defaultModules;
    }

    @Override
    public List<ModuleItem> unavailable() {
        List<ModuleItem> defaultModules = new ArrayList<>();
        defaultModules.add(new ModuleItem("财经", "cj", 1, 0));
        defaultModules.add(new ModuleItem("汽车", "qc", 2, 0));
        defaultModules.add(new ModuleItem("房产", "fc", 3, 0));
        defaultModules.add(new ModuleItem("社会", "sh", 4, 0));
        defaultModules.add(new ModuleItem("情感", "qg", 5, 0));
        defaultModules.add(new ModuleItem("女人", "nr", 6, 0));
        defaultModules.add(new ModuleItem("旅游", "ly", 7, 0));
        defaultModules.add(new ModuleItem("健康", "jk", 8, 0));
        defaultModules.add(new ModuleItem("美女", "mn", 9, 0));
        defaultModules.add(new ModuleItem("游戏", "yx", 10, 0));
        defaultModules.add(new ModuleItem("数码", "sm", 11, 0));
        return defaultModules;
    }
}
