package com.ellen.eqabase;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.ellen.baselibrary.eqa.base.BaseActivity;
import com.ellen.baselibrary.eqa.save.file.AndroidFilePath;
import com.ellen.baselibrary.eqa.uitil.PermissionUtils;
import com.ellen.dhcsqlitelibrary.table.reflection.ZxyReflectionTable;
import com.ellen.eqabase.bean.Person;
import com.ellen.eqabase.save.MyLibrary;
import com.ellen.eqabase.save.PersonTable;
import com.ellen.sqlitecreate.createsql.create.createtable.SQLField;

import java.io.File;
import java.util.List;

public class MainActivity extends BaseActivity {

    private PermissionUtils permissionUtils;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setStatus() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        permissionUtils = new PermissionUtils(this);
        permissionUtils.startCheckFileReadWritePermission(0, new PermissionUtils.PermissionCallback() {
            @Override
            public void success() {
                //创建数据库
                File file = new File(AndroidFilePath.getExternalPath(),"a1");
                Log.e("Ellen2018","目录:"+file.getAbsolutePath());
                file.mkdir();
                MyLibrary myLibrary = new MyLibrary(MainActivity.this, file.getAbsolutePath(),"person",1);

                PersonTable personTable = new PersonTable(myLibrary.getWriteDataBase(), Person.class);
                personTable.onCreateTableIfNotExits(new ZxyReflectionTable.OnCreateSQLiteCallback() {
                    @Override
                    public void onCreateTableBefore(String tableName, List<SQLField> sqlFieldList, String createSQL) {

                    }

                    @Override
                    public void onCreateTableFailure(String errMessage, String tableName, List<SQLField> sqlFieldList, String createSQL) {

                    }

                    @Override
                    public void onCreateTableSuccess(String tableName, List<SQLField> sqlFieldList, String createSQL) {
                       Log.e("Ellen2018","表创建成功!");
                    }
                });
            }

            @Override
            public void failure() {

            }
        });
    }

    @Override
    protected boolean back() {
        Toast.makeText(this,"点击了返回键",Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionUtils.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }
}
