package tw.edu.yzu.www.streetartist;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class LRActivity extends Activity {
    public Fragment_LR LR;
    public Fragment_LR_recentshow RS;
    static Button data,rshow;
    public static FragmentManager mgr ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);
        LR = new Fragment_LR();
        RS = new Fragment_LR_recentshow();
        mgr = getFragmentManager();
        data = (Button)findViewById(R.id.showinformation);
        rshow = (Button)findViewById(R.id.recentshow);

        rshow.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setVisibility(View.INVISIBLE);
                rshow.setVisibility(View.INVISIBLE);
                mgr.beginTransaction()
                        .replace(R.id.listener, RS, "rshow")
                        .addToBackStack(null)
                        .commit();
            }
        });
        data.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setVisibility(View.INVISIBLE);
                rshow.setVisibility(View.INVISIBLE);
                mgr.beginTransaction()
                        .replace(R.id.listener, LR, "data")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
