package rsantillanc.appjovenesjose.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rsantillanc.appjovenesjose.R;
import rsantillanc.appjovenesjose.custom.adapter.ViewPageAdapter;
import rsantillanc.appjovenesjose.moldel.UserModel;
import rsantillanc.appjovenesjose.util.SlidingTabLayout;

public class IntranetFragment extends Fragment {

    private static final String TAG = IntranetFragment.class.getSimpleName();
    private ActionBar actionBar;
    private ViewPager vPager;
//    private TextView tvSpan;

    private CharSequence[] Titles = null;
    private ViewPageAdapter customAdapter;
    private SlidingTabLayout slidingTabLayout;
    private int nums = 0;

    private static IntranetFragment intance = null;


    public static IntranetFragment newInstance(Bundle args) {
        if (intance == null)
            intance = new IntranetFragment();

        intance.setArguments(args);
        return intance;
    }

    public IntranetFragment() {

    }

    /*Fragment Lifecycle*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_intranet, container, false);
        initViews(v);
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /*Custom methods*/
    protected void initViews(View v) {
//        tvSpan = (TextView) v.findViewById(R.id.tv_span);
        vPager = (ViewPager) v.findViewById(R.id.pager);
        slidingTabLayout = (SlidingTabLayout) v.findViewById(R.id.tabs);
        initComponents();
    }

    private void initComponents() {
        /*ActionBar*/
        UserModel user = getArguments().getParcelable(UserModel.TAG_USER_MODEL);
        actionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle(getString(R.string.intranet_title));
        actionBar.setSubtitle(user.getName());

        setTitles(getActivity().getResources().getStringArray(R.array.intranet_array));

        /*Tabs*/
        customAdapter = new ViewPageAdapter(getFragmentManager(), getTitles(), getNums(),getActivity().getApplicationContext());
        vPager.setAdapter(customAdapter);
        slidingTabLayout.setCustomTabView(R.layout.custom_tab,0);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(vPager);
        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.accentColor);
            }
        });

    }


    /*Setter and Getter*/
    public CharSequence[] getTitles() {
        return Titles;
    }

    public void setTitles(CharSequence[] titles) {
        this.Titles = titles;
        nums = titles.length;
    }

    public int getNums() {
        return nums;
    }


}
