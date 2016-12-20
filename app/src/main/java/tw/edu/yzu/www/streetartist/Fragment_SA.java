package tw.edu.yzu.www.streetartist;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class Fragment_SA extends Fragment {
    Button performart,viewart,creativeart;
    public FragmentManager mgr ;
    public Fragment_VArt Vart;
    public Fragment_CArt Cart;
    public Fragment_PArt Part;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.performence_data, container, false);
        performart=(Button)v.findViewById(R.id.perf_button);
        viewart=(Button)v.findViewById(R.id.view_button);
        creativeart=(Button)v.findViewById(R.id.cre_button);
        Vart = new Fragment_VArt();
        Cart = new Fragment_CArt();
        Part = new Fragment_PArt();
        mgr = getFragmentManager();


        performart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v){
                mgr.beginTransaction()
                        .replace(R.id.perf_data,Part, "TAG-mFragment01")
                        .addToBackStack(null)
                        .commit();
            }
        });
        viewart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                mgr.beginTransaction()
                        .replace(R.id.perf_data, Vart, "TAG-mFragment02")
                        .addToBackStack(null)
                        .commit();
            }
        });
        creativeart.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                mgr.beginTransaction()
                        .replace(R.id.perf_data, Cart, "TAG-mFragment03")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }




}


