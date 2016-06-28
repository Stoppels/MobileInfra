package com.apps.oonick.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by N. Shayan on 10-6-2016.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    // Database information.
    private static final String DATABASE_NAME = "readings.db";
    private static final int DATABASE_VERSION = 1;

    // Variable initializations and assignments (table name and columns).
    public static final String TABLE_TASK = "reading";
    public static final String READING_ID = "reading_id";
    public static final String READING_DATE = "reading_date";
    public static final String READING_DEVICE = "reading_device";
    public static final String READING_LOCATION = "reading_location";
    public static final String READING_TEMPERATURE = "reading_temperature";

    // Mandatory constructor which passes the context, database name and database version to the parent.
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        // Execute the query to create the table assignments.
        database.execSQL(DATABASE_CREATE_ASSIGNMENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*
         * When the database gets upgraded you should handle the update to make sure there is no data loss.
     	* This is the default code you put in the upgrade method, to delete the table and call the oncreate again.
     	*/
        Log.w(MySQLiteHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        onCreate(db);
    }

    // Create the table.
    private static final String DATABASE_CREATE_ASSIGNMENTS =
            "CREATE TABLE " + TABLE_TASK +
                    "(" +
                    READING_ID + " integer primary key autoincrement, " +
                    READING_DATE + " text not null, " +
                    READING_DEVICE + " text not null" +
                    READING_LOCATION + " text not null" +
                    READING_TEMPERATURE + " float not null" +
                    ");";

}
