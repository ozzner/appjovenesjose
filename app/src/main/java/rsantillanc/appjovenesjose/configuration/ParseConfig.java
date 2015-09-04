package rsantillanc.appjovenesjose.configuration;

import rsantillanc.appjovenesjose.util.Const;

/**
 * Created by RenzoD on 17/05/2015.
 */
public class ParseConfig {

    /*URL Parse-Api*/
    public static final String DOMAIN = "https://api.parse.com";
    public static final String V1 = "/1";
    public static final String LOGIN = "/login?";

    /*Parse application keys and tags*/
    public static final String APP_ID = "PoeO4yraIz8K0nwjkKQD4TScNGn8VeSxAxBJHfMN";
    public static final String REST_API_KEY = "Wcqetrq1rl8VKqGqgkWdY4uPvlODfolPboE2QwDD";
    public static final String REVO_SESSION = "1";
    public static final String CLIENT_KEY = "yfhThloJwxNmK5wBL6zFzIPbRWykleCKCGzGXaO1";
    public static final String TAG_APP_ID = "X-Parse-Application-Id";
    public static final String TAG_API_KEY = "X-Parse-REST-API-Key";
    public static final String TAG_REVO_SESSION = "X-Parse-Revocable-Session";

    @Override
    public String toString(){
        String sURL = Const.TAG_EMPTY;
        sURL = DOMAIN + V1 + LOGIN;
        return sURL;
    }

}
