package tw.edu.yzu.www.streetartist;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class ContactsProvider extends ContentProvider{

    private static final String AUTHORITY = "tw.edu.yzu.www.streetartist";
    private static final String BASE_PATH = "streetartist";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );

    private static final int CONTACTS = 1;
    private static final int CONTACT_ID = 2;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(AUTHORITY,BASE_PATH, CONTACTS);
        uriMatcher.addURI(AUTHORITY,BASE_PATH + "/#",CONTACT_ID);
    }

    private SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        MySQLiteManager context = new MySQLiteManager(getContext());
        db = context.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, //Uri
                        String[] strings, // "projection" ->which columns to return or null for all columns.
                        String s, // "selection" ->WHERE clause or null for no filter
                        String[] strings1, // "selectionArgs" ->WHERE clause value substitution
                        String s1 // "sortOrder" ->Sort order or null
                        ) {
        Cursor cursor;
        switch (uriMatcher.match(uri)) {
            case CONTACTS:
                cursor =  db.query(MySQLiteManager.TABLE,MySQLiteManager.ALL_COLUMNS,
                        s,null,null,null,MySQLiteManager.NAME +" ASC");
                //Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
                break;
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(),uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {

        switch (uriMatcher.match(uri)) {
            case CONTACTS:
                return "vnd.android.cursor.dir/contacts";
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        long id = db.insert(MySQLiteManager.TABLE,null,contentValues);

        if (id > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, id);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("Insertion Failed for URI :" + uri);

    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        int delCount = 0;
        switch (uriMatcher.match(uri)) {
            case CONTACTS:
                delCount =  db.delete(MySQLiteManager.TABLE,s,strings);
                break;
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return delCount;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        int updCount = 0;
        switch (uriMatcher.match(uri)) {
            case CONTACTS:
                updCount =  db.update(MySQLiteManager.TABLE,contentValues,s,strings);
                break;
            default:
                throw new IllegalArgumentException("This is an Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return updCount;
    }
}
