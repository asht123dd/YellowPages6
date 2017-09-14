package com.sdl.dart.yellowpages2;

import android.provider.BaseColumns;

/**
 * Created by ashutosh on 13/9/17.
 */

public final class FeedReaderContract {
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "info";
       /* public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";*/
       public static final int DATABASE_VERSION = 1;

        // Database Name
        public static final String DATABASE_NAME = "db";

        // Contacts table name
        //private static final String TABLE_USER_DETAIL = "info";

        // Contacts Table Columns names
        // private static final String KEY_ID = "id";
        //private static final String KEY_ENROLL_NO = "enroll_no";
        public static final String U_NAME = "u_name";
        public static final String PASSWORD = "email";
    }

    }
