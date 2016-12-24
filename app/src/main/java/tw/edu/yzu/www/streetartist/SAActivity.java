package tw.edu.yzu.www.streetartist;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class SAActivity extends Activity{

    public Fragment_SA_write SAW;
    public Fragment_SA_findsite SAF;
    static Button update,findsite;
    public static FragmentManager mgr ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_artist);
        SAW = new Fragment_SA_write();
        SAF=new Fragment_SA_findsite();
        mgr = getFragmentManager();
        update = (Button)findViewById(R.id.update);
        findsite = (Button)findViewById(R.id.findsite);
        update.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                update.setVisibility(View.INVISIBLE);
                findsite.setVisibility(View.INVISIBLE);
                mgr.beginTransaction()
                        .replace(R.id.street_artist, SAW, "TAG-mFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        findsite.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                update.setVisibility(View.INVISIBLE);
                findsite.setVisibility(View.INVISIBLE);
                mgr.beginTransaction()
                        .replace(R.id.street_artist, SAF, "TAG-mFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}
