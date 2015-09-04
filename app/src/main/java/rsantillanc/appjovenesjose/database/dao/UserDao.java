package rsantillanc.appjovenesjose.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import rsantillanc.appjovenesjose.database.table.UserTable;
import rsantillanc.appjovenesjose.moldel.UserModel;

/**
 * Created by RenzoD on 20/05/2015.
 */
public class UserDao extends DaoBase {

    public static final String TAG = UserDao.class.getSimpleName();
    private ArrayList<UserModel> users;

    public UserDao(Context context) {
        super(context);
        users = new ArrayList<>();

    }

    public ArrayList<UserModel> getAllUsers(){
        Cursor c;

        if (!isOpen())
           openDatabase();

        c = getDatabase().rawQuery(UserTable.selectAll(),null);

        if (c != null && c.moveToFirst()){

            do {
                UserModel user = new UserModel();

                user.setObjectId(c.getString(c.getColumnIndex(UserTable.OBJECT_ID)));
                user.setUsername(c.getString(c.getColumnIndex(UserTable.USERNAME)));
                user.setName(c.getString(c.getColumnIndex(UserTable.NAME)));
                user.setEmail(c.getString(c.getColumnIndex(UserTable.EMAIL)));
                user.setEmailVerified(Boolean.parseBoolean(c.getString(c.getColumnIndex(UserTable.EMAIL_VERIFIED))));
                user.setCreatedAt(c.getString(c.getColumnIndex(UserTable.CREATED_AT)));
                user.setUpdatedAt(c.getString(c.getColumnIndex(UserTable.UPDATED_AT)));
                user.setAge(c.getInt(c.getColumnIndex(UserTable.AGE)));
                user.setBirthday(c.getString(c.getColumnIndex(UserTable.BIRTHDAY)));
                user.setSocialLogin(c.getString(c.getColumnIndex(UserTable.SOCIAL_LOGIN)));
                user.setStatus(c.getInt(c.getColumnIndex(UserTable.STATUS)));
                user.setType(c.getString(c.getColumnIndex(UserTable.TYPE)));
                user.setSessionToken(c.getString(c.getColumnIndex(UserTable.SESSION_TOKEN)));

                users.add(user);
                Log.e(TAG,user.toString());

            }while (c.moveToFirst());

            if (c != null && !c.isClosed()) {
                c.close();
            }
        }

        closeDatabase();
        return users;
    }



    public long insertUser(UserModel user){
        long row = -1;
        UserTable table = new UserTable();
        Log.e(TAG, "Table: " + table.toString());

        if (!isOpen())
            openDatabase();

        ContentValues cv = new ContentValues();
        cv.put(UserTable.OBJECT_ID,user.getObjectId());
        cv.put(UserTable.USERNAME,user.getUsername());
        cv.put(UserTable.NAME,user.getName());
        cv.put(UserTable.EMAIL,user.getEmail());
        cv.put(UserTable.EMAIL_VERIFIED,String.valueOf(user.isEmailVerified()));//Boolean
        cv.put(UserTable.CREATED_AT,user.getCreatedAt());
        cv.put(UserTable.UPDATED_AT,user.getUpdatedAt());
        cv.put(UserTable.AGE,user.getAge());//Integer
        cv.put(UserTable.BIRTHDAY,user.getBirthday());
        cv.put(UserTable.SOCIAL_LOGIN,user.getSocialLogin());
        cv.put(UserTable.STATUS,user.getStatus());
        cv.put(UserTable.TYPE,user.getType());
        cv.put(UserTable.SESSION_TOKEN,user.getSessionToken());

        row = getDatabase().insert(UserTable.TABLE_NAME,null,cv);

        closeDatabase();
        return row;
    }

public boolean isUserExist(String userID){
    Cursor c = null;
    boolean on = false;

    if (!isOpen())
        openDatabase();

    c = getDatabase().rawQuery(UserTable.getUser(), new String[] {userID});
    if ( c != null && c.moveToFirst())
        on = true;

    if (c != null && !c.isClosed()) {
        c.close();
    }

    Log.e(TAG,"User status: " + on);
    closeDatabase();
    return on;
}





}
