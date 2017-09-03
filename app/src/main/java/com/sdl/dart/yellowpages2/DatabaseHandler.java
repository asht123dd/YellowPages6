package com.sdl.dart.yellowpages2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ashutosh on 19/8/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "db";

    // Contacts table name
    private static final String TABLE_USER_DETAIL = "info";

    // Contacts Table Columns names
   // private static final String KEY_ID = "id";
    //private static final String KEY_ENROLL_NO = "enroll_no";
    private static final String U_NAME = "u_name";
    private static final String PASSWORD = "email";

    public DatabaseHandler(Context contex) {
        super(contex, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USER_DETAIL_TABLE = "CREATE TABLE " + TABLE_USER_DETAIL +"("
                + U_NAME + " VARCHAR(20),"
                + PASSWORD + " VARCHAR(16)" + ")";

        db.execSQL(CREATE_USER_DETAIL_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_DETAIL);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new User Information
    void addNewUser(user newUser) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

       // values.put(KEY_ENROLL_NO, newStud.get_enroll_no());
        values.put(U_NAME, newUser.getU_name());
        values.put(PASSWORD, newUser.getPass());


        // Inserting Row
        db.insert(TABLE_USER_DETAIL, null, values);
        db.close(); // Closing database connection
    }









    // Getting All Users
    public List<user> getAllUserList() {


        List<user> studentList = new ArrayList<user>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USER_DETAIL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                user use = new user();
                //use.set_id(Integer.parseInt(cursor.getString(0)));
                //stdnt.set_enroll_no(Integer.parseInt(cursor.getString(1)));
                use.setU_name(cursor.getString(2));
                use.setPass(cursor.getString(3));

                // Adding contact to list
                studentList.add(use);

            } while (cursor.moveToNext());
        }
cursor.close();
        // return contact list
        return studentList;
    }

}
