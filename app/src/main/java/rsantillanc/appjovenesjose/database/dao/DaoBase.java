package rsantillanc.appjovenesjose.database.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import rsantillanc.appjovenesjose.database.JovenesJoseDatabase;
/**
 * Created by RenzoD on 20/05/2015.
 */

public class DaoBase {

    private Context context;
    protected SQLiteDatabase db;
    protected JovenesJoseDatabase mDb;


    public DaoBase(Context context) {
        this.context = context;
        mDb = new JovenesJoseDatabase(context);
        this.db = mDb.getReadableDatabase();
    }

    protected void openDatabase(){
        mDb = new JovenesJoseDatabase(context);
        this.db = mDb.getReadableDatabase();
    }

    protected boolean isOpen(){
        return this.db.isOpen();
    }

    public SQLiteDatabase getDatabase() {
        return db;
    }

    public void setDatabase(SQLiteDatabase db) {
        this.db = db;
    }

    protected void closeDatabase(){
        if (db != null && db.isOpen())
            this.db.close();
    }

}
