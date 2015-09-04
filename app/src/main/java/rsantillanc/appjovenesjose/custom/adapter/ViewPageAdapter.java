package rsantillanc.appjovenesjose.custom.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import rsantillanc.appjovenesjose.R;
import rsantillanc.appjovenesjose.view.fragment.ChatFragment;
import rsantillanc.appjovenesjose.view.fragment.LoginFragment;
import rsantillanc.appjovenesjose.view.fragment.MembersFragment;
import rsantillanc.appjovenesjose.view.fragment.SharedFragment;

/**
 * Created by RenzoD on 22/05/2015.
 */
public class ViewPageAdapter extends FragmentPagerAdapter {


    private static final String TAG = ViewPageAdapter.class.getSimpleName();
    private CharSequence tabTitles[];
    private int numTabs;
    private Context _context;
    private int[] icons = {R.drawable.ic_chat,R.drawable.ic_members,R.drawable.ic_shared};



    public ViewPageAdapter(FragmentManager fm, CharSequence[] titles, int numbOfTabs,Context ctx) {
        super(fm);
        this.tabTitles = titles;
        this.numTabs = numbOfTabs;
        this._context = ctx;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fm = new LoginFragment();

        switch (position){
            case 0:
                fm = new ChatFragment();
            break;

            case 1:
                fm = new MembersFragment();
            break;

            case 2:
                fm = new SharedFragment();
            break;
        }

        return fm;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        Drawable image = _context.getResources().getDrawable(icons[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image);
        sb.setSpan(imageSpan, 0,sb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }

    @Override
    public int getCount() {
        return numTabs;
    }

    public Drawable getIcons(int i) {
        return _context.getResources().getDrawable(icons[i]);
    }
}
