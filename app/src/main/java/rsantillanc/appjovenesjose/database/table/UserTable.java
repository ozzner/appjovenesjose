package rsantillanc.appjovenesjose.database.table;

import android.provider.BaseColumns;

/**
 * Created by RenzoD on 20/05/2015.
 */
public class UserTable implements BaseColumns {

    /*-----------------User----------------*/
//    public static final String TABLE_NAME = UserTable.class.getSimpleName().toUpperCase();
    public static final String TABLE_NAME = "_User_";
    public static final String OBJECT_ID = "objectId";
    public static final String USERNAME = "username";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String EMAIL_VERIFIED = "emailVerified";
    public static final String CREATED_AT = "createdAt";
    public static final String UPDATED_AT = "updatedAt";
    public static final String AGE = "age";
    public static final String BIRTHDAY = "birthday";
    public static final String SOCIAL_LOGIN = "socialLogin";
    public static final String STATUS = "status";
    public static final String TYPE = "type";
    public static final String SESSION_TOKEN = "sessionToken";

    /*create table*/
    private static final String CREATE = "CREATE TABLE " + TABLE_NAME
                                        + "("
                                        + _ID + " INTEGER PRIMARY KEY, "
                                        + OBJECT_ID + " TEXT , "
                                        + _COUNT + " INTEGER AUTO_INCREMENT, "
                                        + USERNAME + " TEXT, "
                                        + NAME + " TEXT, "
                                        + EMAIL + " TEXT, "
                                        + EMAIL_VERIFIED + " TEXT, "
                                        + CREATED_AT + " TEXT, "
                                        + UPDATED_AT + " TEXT, "
                                        + AGE + " INTEGER, "
                                        + BIRTHDAY + " TEXT, "
                                        + SOCIAL_LOGIN + " TEXT, "
                                        + STATUS + " INTEGER, "
                                        + TYPE + " TEXT, "
                                        + SESSION_TOKEN + " TEXT"
                                        +");";

    /*query tables*/
    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String SELECT_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE objectId = ?";

    @Override
    public String toString(){
       return "\n" + CREATE;
    }

    public static String createTable(){
        return CREATE;
    }


    /**
     * @return SELECT * FROM UserTable
     */
    public static String selectAll(){
        return SELECT_ALL;
    }
    /**
     * @return SELECT * FROM UserTable where = objectId
     */
    public static String getUser(){
        return SELECT_BY_ID;
    }
}
