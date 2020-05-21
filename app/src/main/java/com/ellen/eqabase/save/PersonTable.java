package com.ellen.eqabase.save;

import android.database.sqlite.SQLiteDatabase;

import com.ellen.dhcsqlitelibrary.table.reflection.ZxyReflectionTable;
import com.ellen.eqabase.bean.Person;
import com.ellen.sqlitecreate.createsql.helper.SQLFieldType;

public class PersonTable extends ZxyReflectionTable<Person> {

    public PersonTable(SQLiteDatabase db, Class<? extends Person> dataClass) {
        super(db, dataClass);
    }

    @Override
    protected SQLFieldType getSQLFieldType(String classFieldName, Class typeClass) {
        return defaultGetSQLFieldType(classFieldName,typeClass);
    }

    @Override
    protected String getSQLFieldName(String classFieldName, Class typeClass) {
        return classFieldName;
    }

    @Override
    protected Object setBooleanValue(String classFieldName, boolean value) {
        return null;
    }

    @Override
    protected boolean isAutoCreateTable() {
        return false;
    }

    @Override
    protected SQLFieldType conversionSQLiteType(String classFieldName, Class typeClass) {
        return null;
    }

    @Override
    protected <E> E setConversionValue(Person person, String classFieldName, Class typeClass) {
        return null;
    }

    @Override
    protected <E> E resumeConversionObject(Object value, String classFieldName, Class typeClass) {
        return null;
    }
}
