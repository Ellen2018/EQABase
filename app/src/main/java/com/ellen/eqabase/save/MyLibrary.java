package com.ellen.eqabase.save;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ellen.dhcsqlitelibrary.table.reflection.ZxyLibrary;

public class MyLibrary extends ZxyLibrary {

    public MyLibrary(Context context, String name, int version) {
        super(context, name, version);
    }

    public MyLibrary(Context context, String libraryPath, String name, int version) {
        super(context, libraryPath, name, version);
    }

    @Override
    public void onZxySQLiteCreate(SQLiteDatabase db) {
        Log.e("Ellen2018","创建否？");
    }

    @Override
    public void onZxySQLiteUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
