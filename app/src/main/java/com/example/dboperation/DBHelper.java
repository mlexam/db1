package com.example.dboperation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) { super(context, "MyDB", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE userdetails (rollno INTEGER PRIMARY KEY, name TEXT, email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS userdetails");
    }

    public boolean insertToDB(int rollno, String name, String email){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("rollno",rollno);
        values.put("name",name);
        values.put("email",email);
        long result= db.insert("userdetails",null,values);
        if(result>=0){
            return true;
        }
        else {
            return false;
        }
    }

    public Cursor selectFromDB() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from userdetails", null);
        return cursor;
    }




}
