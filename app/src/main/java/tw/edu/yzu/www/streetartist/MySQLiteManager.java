package tw.edu.yzu.www.streetartist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class MySQLiteManager extends SQLiteOpenHelper {

    public final static int DB_VERSION = 1; // 資料庫版本

    public final static String DB_NAME = "StreetArtist.db"; //資料庫名稱，附檔名為db

    public final static String TABLE = "StreetArtist";
    public final static String ID = "_Id"; //primary key
    public final static String NAME = "name";
    public final static String DATE = "date";
    public final static String TIME = "time";
    public final static String PLACE = "place";
    public final static String CONTEXT = "context";
    public final static String INTRODUCTION = "introduction";
    public final static String[] ALL_COLUMNS = { ID, NAME, DATE, TIME , PLACE, CONTEXT, INTRODUCTION};

    public MySQLiteManager (Context context) {
    /*
        *   SQLiteOpenHelper
        * (Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
        * 通常我們只會傳回context, DB_NAME, DB_VERSION;
        * factory 我也不大了解作用是什麼。
        */
        super(context, DB_NAME, null, DB_VERSION);
    }

    // 每次使用將會檢查是否有無資料表，若無，則會建立資料表

    @Override
    public void onCreate(SQLiteDatabase db) {

        //SQLite 所支援屬性帳面上的不多，但事實上也是能夠讀取一些其它屬性

        String createTable = "CREATE TABLE " + TABLE+ " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "  //這個屬性可以讓每次新增一筆資料，自動累加
                + "name TEXT UNIQUE NOT NULL, "
                + "date  DATE, "
                + "time  TIME, "
                + "place TEXT, "
                + "context TEXT, "
                + "introduction TEXT);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
    public void resetData(){
        getWritableDatabase().execSQL("DROP TABLE " + TABLE);
        getWritableDatabase().execSQL("CREATE  TABLE IF NOT EXISTS " + TABLE +
                " (_Id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE NOT NULL, date  DATE, time  TIME, place TEXT, context TEXT, introduction TEXT);");
    }
    public void addData(String name, String date, String time, String place, String context, String introduction){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(DATE, date);
        values.put(TIME, time);
        values.put(PLACE, place);
        values.put(CONTEXT, context);
        values.put(INTRODUCTION, introduction);
        // 第一個參數是表格名稱
        // 第二個參數是沒有指定欄位值的預設值
        // 第三個參數是包裝新增資料的ContentValues物件
        db.insert(TABLE, null, values);
        db.close();
    }

    public void delete(long id ){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE,ID+"=?",new String[] {Long.toString(id)});
        Log.i("last","delete");
        db.close();
    }
    public Cursor getAll() {
        Cursor alltable = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE + " ORDER BY "+DATE+" ASC, "+TIME+" ASC, "+ID+" ASC;",null);
        return alltable;
    }
    

    public int count(){
        Cursor all = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE + " ORDER BY "+DATE+" ASC, "+TIME+" ASC, "+ID+" ASC;",null);
        Log.i("count",Integer.toString(all.getCount()));
        return all.getCount();
    }
    public void clear(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE+";");
        db.close();
    }
}
