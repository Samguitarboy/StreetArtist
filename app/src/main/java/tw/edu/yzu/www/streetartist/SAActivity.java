package tw.edu.yzu.www.streetartist;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.View;
import android.widget.Button;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class SAActivity extends Activity{

    public Fragment_SA SA;
    Button sadata;
    FragmentManager mgr = getFragmentManager();
    FragmentTransaction fragmentTrans = mgr.beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_artist);
        SA = new Fragment_SA();
        sadata = (Button)findViewById(R.id.button2);
        sadata.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                mgr.beginTransaction()
                        .replace(R.id.street_artist, SA, "TAG-mFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

}
