package tw.edu.yzu.www.streetartist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class Fragment_SA_write extends Fragment {
    public MySQLiteManager db;
    public EditText date,time;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.activity_street_artist, container, false);
        db=new MySQLiteManager(getActivity());


        return v;
    }
}
