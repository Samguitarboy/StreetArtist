package tw.edu.yzu.www.streetartist;

/**
 * Created by user on 2016/12/20.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by user on 2016/12/20.
 */

public class Fragment_LR_CArt extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.cretive_art, container, false);

        v.setFocusable(true);
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( event.getAction()== KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK )
                {
                    Fragment_LR.performart.setVisibility(View.VISIBLE);
                    Fragment_LR.viewart.setVisibility(View.VISIBLE);
                    Fragment_LR.creativeart.setVisibility(View.VISIBLE);

                }
                return false;
            }
        } );
        return v;
    }
}
