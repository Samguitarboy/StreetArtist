package tw.edu.yzu.www.streetartist;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class Fragment_LR extends Fragment {
    static Button performart,viewart,creativeart;
    public static FragmentManager mgr ;
    public Fragment_LR_VArt Vart;
    public Fragment_LR_CArt Cart;
    public Fragment_LR_PArt Part;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.fragment_lr_showinformation, container, false);
        performart=(Button)v.findViewById(R.id.perf_button);
        viewart=(Button)v.findViewById(R.id.view_button);
        creativeart=(Button)v.findViewById(R.id.cre_button);
        Vart = new Fragment_LR_VArt();
        Cart = new Fragment_LR_CArt();
        Part = new Fragment_LR_PArt();
        mgr = getFragmentManager();


        performart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v){
                performart.setVisibility(View.INVISIBLE);
                viewart.setVisibility(View.INVISIBLE);
                creativeart.setVisibility(View.INVISIBLE);
                mgr.beginTransaction()
                        .replace(R.id.perf_data,Part, "TAG-mFragment01")
                        .addToBackStack(null)
                        .commit();
            }
        });
        viewart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                performart.setVisibility(View.INVISIBLE);
                viewart.setVisibility(View.INVISIBLE);
                creativeart.setVisibility(View.INVISIBLE);
                mgr.beginTransaction()
                        .replace(R.id.perf_data, Vart, "TAG-mFragment02")
                        .addToBackStack(null)
                        .commit();
            }
        });
        creativeart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                performart.setVisibility(View.INVISIBLE);
                viewart.setVisibility(View.INVISIBLE);
                creativeart.setVisibility(View.INVISIBLE);
                mgr.beginTransaction()
                        .replace(R.id.perf_data, Cart, "TAG-mFragment03")
                        .addToBackStack(null)
                        .commit();
            }
        });


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
                    LRActivity.data.setVisibility(View.VISIBLE);
                    LRActivity.rshow.setVisibility(View.VISIBLE);
                }
                return false;
            }
        } );

        return v;
    }




}


