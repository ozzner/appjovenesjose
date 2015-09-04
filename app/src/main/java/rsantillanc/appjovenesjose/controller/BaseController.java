package rsantillanc.appjovenesjose.controller;

import android.content.Context;

/**
 * Created by RenzoD on 17/05/2015.
 */
public class BaseController {

    protected  Context context;

    public BaseController(Context context) {
        this.context = context;
    }

    public BaseController() {

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
