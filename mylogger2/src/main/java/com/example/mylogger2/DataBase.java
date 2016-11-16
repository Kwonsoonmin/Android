package com.example.mylogger2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 1k9s9_000 on 2016-11-16.
 */
public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE LIST_MyEvent (_id INTEGER PRIMARY KEY AUTOINCREMENT, latitude TEXT, longitude TEXT, place TEXT, event TEXT);");
    }

    public void onUpgrade(SQLiteDatabase db, int old, int newverision) {
    }

    public void insert(String place, String event, String latitude, String longitude) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO LIST_MyEvent VALUES(null,'" +latitude+"', '"+ longitude+"', '"+place + "', '"+event +"');");
        db.close();
    }
    public void update(String event, String place, String latitude, String longitude) {
    }

    public void delete(String event, String place, String latitude, String longitude) {
    }

    public String getResult() {
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM LIST_MyEvent", null);

        while(cursor.moveToNext()) {
            result += cursor.getString(0) +":"+"\n"+"Latitude: "+cursor.getString(1) +", Longitude: "+ cursor.getString(2)+"\n"+"Place: "+cursor.getString(3)+", Event: " + cursor.getString(4)+"\n\n";
        }
        db.close();
        return result;
    }
}
