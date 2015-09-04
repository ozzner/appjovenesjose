package rsantillanc.appjovenesjose;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

import java.util.Objects;

/**
 * Created by RenzoD on 16/05/2015.
 */
public class JovenesJoseApplication extends Application {

    private static final String TAG = JovenesJoseApplication.class.getSimpleName();
    private static JovenesJoseApplication singleton;//Instance
    private RequestQueue mReqQueue;

    /*Globals variables*/
    private int userID;
    private String userName;
    private String sessionToken;



    public static synchronized JovenesJoseApplication getInstance(){
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    public RequestQueue getReqQueue(){
        if (mReqQueue == null)
            mReqQueue = Volley.newRequestQueue(getApplicationContext());

        return mReqQueue;
    }

    public <T> void addToReqQueue(Request<T> req, String tag){
        req.setTag(TextUtils.isEmpty(tag) ?TAG : tag);
        VolleyLog.d("Adding request to queue: %s", req.getUrl());

        getReqQueue().add(req);
    }

    public <T> void addToReqQueue(Request<T> req){
        req.setTag(TAG);
        getReqQueue().add(req);
    }

    public void cancelToReqQueue(Objects tag){
        if (mReqQueue == null){
            mReqQueue.cancelAll(tag);
        }
    }


    /*Setter and Getter*/
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
