package com.example.jasmin.barradar.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jasmin on 23.02.2016.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    // Database info
    private static final String DATABASE_NAME = "barradar.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_LOCATIONS = "locations";
    public static final String COLUMN_LOCATION_ID = "location_id";
    public static final String COLUMN_LOCATION_NAME = "location";
    public static final String COLUMN_LOCATION_TYPE = "type";
    public static final String COLUMN_LOCATION_ADDRESS = "address";
    public static final String COLUMN_LOCATION_DESCRIPTION = "description";
    public static final String COLUMN_LOCATION_IMAGE = "image";


    private static final String DATABASE_CREATE_ASSIGNMENTS =
            "CREATE TABLE " + TABLE_LOCATIONS +
                    "(" +
                    COLUMN_LOCATION_ID + " integer primary key autoincrement, " +
                    COLUMN_LOCATION_NAME + " text not null, " +
                    COLUMN_LOCATION_TYPE + " text not null, " +
                    COLUMN_LOCATION_ADDRESS + " text not null, " +
                    COLUMN_LOCATION_DESCRIPTION + " text, " +
                    COLUMN_LOCATION_IMAGE + " BLOB " +
                    ");";

    // Mandatory constructor which passes the context, database name and database version and passes it to the parent
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Execute the sql to create the table assignments
        db.execSQL(DATABASE_CREATE_ASSIGNMENTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);
        onCreate(db);
    }
}
