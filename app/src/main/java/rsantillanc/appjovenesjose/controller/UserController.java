package rsantillanc.appjovenesjose.controller;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import rsantillanc.appjovenesjose.JovenesJoseApplication;
import rsantillanc.appjovenesjose.configuration.ParseConfig;
import rsantillanc.appjovenesjose.configuration.WebConfig;
import rsantillanc.appjovenesjose.database.dao.UserDao;
import rsantillanc.appjovenesjose.moldel.UserModel;
import rsantillanc.appjovenesjose.util.Const;
import rsantillanc.appjovenesjose.view.fragment.LoginFragment;

/**
 * Created by RenzoD on 17/05/2015.
 */
public class UserController {

    private static final String TAG = LoginFragment.class.getSimpleName();
    private static final String KEY_USERNAME = "username=";
    private static final String KEY_PASSWORD = "password=";
    private mOnLoginResultListener mListener;
    private Context _context;




    public UserController(mOnLoginResultListener listener,Context context) {
        this.mListener = listener;
        this._context = context;
    }

    public UserController() {

    }


    public void loginRequest(final String username, final String password) {

        String url = ParseConfig.DOMAIN
                    + ParseConfig.V1
                    + ParseConfig.LOGIN
                    + KEY_USERNAME + username + Const.HTTP_AMP
                    + KEY_PASSWORD + password;

        JsonObjectRequest loginReq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat(Const.DATE_PATTERN_FULL).create();
                UserModel oUser =  gson.fromJson(response.toString(), UserModel.class);

                UserDao dao = new UserDao(_context);
                if (!dao.isUserExist(oUser.getObjectId()));
                dao.insertUser(oUser);

                mListener.onSuccess(oUser);
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                mListener.onError((error));
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("X-Parse-Application-Id", ParseConfig.APP_ID);
                headers.put("X-Parse-REST-API-Key", ParseConfig.REST_API_KEY);
                headers.put("Content-Type", WebConfig.URL_ENCODED);
                return headers;
            }
      };
        JovenesJoseApplication.getInstance().addToReqQueue(loginReq, TAG);
        Log.e(TAG, url);
    }


    public interface mOnLoginResultListener {
         void onSuccess(UserModel user);
         void onError(VolleyError error);
    }
}
