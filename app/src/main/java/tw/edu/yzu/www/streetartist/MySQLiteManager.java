package tw.edu.yzu.www.streetartist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class MySQLiteManager extends SQLiteOpenHelper {

    private final static int DB_VERSION = 1; // 資料庫版本

    private final static String DB_NAME = "StreetArtist.db"; //資料庫名稱，附檔名為db

    public final static String TABLE = "StreetArtist";
    public final static String ID = "_Id"; //primary key
    public final static String NAME = "name";
    public final static String DATETIME = "datetime";
    public final static String PLACE = "place";
    public final static String CONTEXT = "context";
    public final static String INTRODUCTION = "introduction";
    public final static String[] ALL_COLUMNS = { ID, NAME, DATETIME, PLACE, CONTEXT, INTRODUCTION};

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
                + NAME + " TEXT UNIQUE NOT NULL, "
                + DATETIME + " DATETIME, "
                + PLACE + " TEXT, "
                + CONTEXT + " TEXT, "
                + INTRODUCTION + " TEXT);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}
