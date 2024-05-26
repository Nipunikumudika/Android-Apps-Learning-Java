package com.nipuni.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context,"Userdata.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("Create Table Userdetails(name TEXT primary key , tp TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertUserData (String name, String tp){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("tp",tp);

        long result = DB.insert("Userdetails",null,contentValues);

        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean updateUserData(String name,String tp){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tp",tp);

        Cursor cursor = DB.rawQuery("Select * from Userdetails where name=?",new String[]{name});

        if (cursor.getCount()>0){
            long result = DB.update("Userdetails",contentValues,"name=?",new String[]{name});
            if (result == -1){
                return false;
            }else{
                return true;
            }

        }else{
            return false;
        }
    }


    public Boolean deleteUserData(String name){
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from Userdetails where name=?",new String[]{name});

        if (cursor.getCount()>0){
            long result = DB.delete("Userdetails","name=?",new String[]{name});
            if (result == -1){
                return false;
            }else{
                return true;
            }

        }else{
            return false;
        }
    }


    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Userdetails",null);
        return cursor;
    }

}
