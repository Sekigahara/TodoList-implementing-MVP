package com.example.remaketodolist.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    private static final String SQL_DELETE_TASK =
            "DROP TABLE IF EXISTS " + DatabaseContract.FeedTask.TABLE_NAME;

    private static final String SQL_CREATE_TASK =
            "CREATE TABLE " + DatabaseContract.FeedTask.TABLE_NAME + " (" +
                    DatabaseContract.FeedTask._ID + " INTEGER PRIMARY KEY," +
                    DatabaseContract.FeedTask.COLUMN_TITLE + " TEXT," +
                    DatabaseContract.FeedTask.COLUMN_DESCRIPTION + " TEXT," +
                    DatabaseContract.FeedTask.COLUMN_DATE + " TEXT," +
                    DatabaseContract.FeedTask.COLUMN_COMPLETE + " INTEGER DEFAULT 0)"
                    ;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TASK);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_TASK);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TASK);
        onUpgrade(db, oldVersion, newVersion);
    }
}
