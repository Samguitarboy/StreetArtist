package tw.edu.yzu.www.streetartist;

/**
 * Created by user on 2016/12/20.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by user on 2016/12/20.
 */

public class Fragment_PArt extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.per_art, container, false);
        return v;
    }
}
