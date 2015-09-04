package rsantillanc.appjovenesjose.view.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import rsantillanc.appjovenesjose.R;
import rsantillanc.appjovenesjose.controller.UserController;
import rsantillanc.appjovenesjose.moldel.UserModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = LoginFragment.class.getSimpleName();
    private ImageView ivLogo;
    private EditText etUser;
    private EditText etPass;
    private ActionBar actionBar;
    private Button btLogin;
    private ProgressDialog proDia;


    private Context _context;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        initViews(v);

        /*loadSVGImage();*/
        return v;
    }

    public void loadSVGImage(){
        SVG mSVG = SVGParser.getSVGFromResource(getResources(), R.raw.android);
        Drawable drawable = mSVG.createPictureDrawable();
        ivLogo.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        ivLogo.setImageDrawable(drawable);

    }

    public void initViews(View v){

        ivLogo = (ImageView)v.findViewById(R.id.iv_logo);
        btLogin = (Button)v.findViewById(R.id.bt_login);
        etUser = (EditText)v.findViewById(R.id.et_user);
        etPass = (EditText)v.findViewById(R.id.et_password);


        /* Config */
        btLogin.setOnClickListener(this);
        _context = getActivity();
        // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width


        initComponets();
    }

    private void initComponets() {
        actionBar = ((ActionBarActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle(getString(R.string.login_title));
        actionBar.setSubtitle("");
    }



    public void showProgressBar(){
        proDia = new ProgressDialog(_context);
        proDia.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        proDia.setMessage(getString(R.string.login_loading));
        proDia.setIndeterminate(true);
        proDia.show();
    }

    public void hideProgressBar(){
        if (proDia.isShowing())
            proDia.dismiss();
    }

    @Override
    public void onClick(View v) {
        login();
    }

    protected void login() {
        final String password = etPass.getText().toString().trim();
        final String username = etUser.getText().toString().trim();

        if (username.length() <= 0) {
            Crouton.showText((Activity) _context, getString(R.string.login_req_user), Style.ALERT);
            etUser.requestFocus();
            return;
        }

        if (password.length() <= 0) {
            Crouton.showText((Activity) _context, getString(R.string.login_req_pass), Style.CONFIRM);
            etPass.requestFocus();
            return;
        }

        showProgressBar();
        UserController reqUser = new UserController(new UserController.mOnLoginResultListener() {

            @Override
            public void onSuccess(UserModel user) {
                hideProgressBar();

                /*go to HomeActivity page!*/
                Bundle bundle = new Bundle();
                bundle.putParcelable(UserModel.TAG_USER_MODEL, user);

                Fragment fragment = IntranetFragment.newInstance(bundle);
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container_body, fragment);
                transaction.commit();
            }

            @Override
            public void onError(VolleyError error) {
                hideProgressBar();
                Log.e(TAG,error.toString());
            }

        },getActivity());

        reqUser.loginRequest(username, password);
    }

    }



