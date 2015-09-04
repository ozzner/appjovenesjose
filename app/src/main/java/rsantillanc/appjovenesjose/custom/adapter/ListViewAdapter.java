package rsantillanc.appjovenesjose.custom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import rsantillanc.appjovenesjose.R;
import rsantillanc.appjovenesjose.moldel.UserModel;
import rsantillanc.appjovenesjose.util.Const;

/**
 * Created by RenzoD on 25/05/2015.
 */
public class ListViewAdapter extends BaseAdapter {

    private UserModel oUser;
    private ArrayList<UserModel> usersList;
    private Context _context;
    private LayoutInflater layIn;

    public ListViewAdapter(ArrayList<UserModel> usersList, Context _context) {
        this.usersList = usersList;
        this._context = _context;
        this.layIn = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return usersList.size();
    }

    @Override
    public Object getItem(int position) {
        oUser = usersList.get(position);
        return oUser;
    }

    @Override
    public long getItemId(int position) {
        return Const.NUMBER_DEFAULT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        UserHolder holder;
        oUser = (UserModel)getItem(position);

        if (vi == null){
            holder = new UserHolder();

            vi =  layIn.inflate(R.layout.item_chat_group,parent,false);
            holder.tv_anything = (TextView)vi.findViewById(R.id.tv_anything);

            vi.setTag(holder);
        }else{
            holder = (UserHolder)vi.getTag();
        }

        holder.tv_anything.setText(oUser.toString());
        holder.tv_anything.setAllCaps(true);

        return vi;
    }

    static class UserHolder{
        TextView tv_anything;
    }
}
