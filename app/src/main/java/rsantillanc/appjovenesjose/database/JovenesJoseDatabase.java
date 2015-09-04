package rsantillanc.appjovenesjose.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import rsantillanc.appjovenesjose.database.table.UserTable;

/**
 * Created by RenzoD on 20/05/2015.
 */
public class JovenesJoseDatabase extends SQLiteOpenHelper {

    private static final String TAG = JovenesJoseDatabase.class.getSimpleName();
    private static final int    DATABASE_VERSION = 1;
//  private static final String DATABASE_NAME = "JovenesJose.db"; //interna
    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS ";
    private static final String DATABASE_NAME  = Environment.getExternalStorageDirectory().getPath()+"/JovenesJose.db";


    public JovenesJoseDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e(TAG,"New Intance JovenesJoseDB");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e(TAG, "onCreate Database");
        db.execSQL(UserTable.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG, "OnUpdate Database");
        db.execSQL(DATABASE_DROP + UserTable.TABLE_NAME);
    }
}
