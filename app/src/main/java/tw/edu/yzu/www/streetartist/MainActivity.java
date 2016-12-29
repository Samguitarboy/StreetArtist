package tw.edu.yzu.www.streetartist;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends Activity {

    Button streetartist,listener,donate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        streetartist=(Button)findViewById(R.id.streetartist);
        listener=(Button)findViewById(R.id.listener);
        donate=(Button)findViewById(R.id.donate);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if(tabId==R.id.tab_listener) {
                    listener.setEnabled(true);
                    listener.setVisibility(View.VISIBLE);
                    streetartist.setEnabled(false);
                    streetartist.setVisibility(View.INVISIBLE);
                    donate.setEnabled(false);
                    donate.setVisibility(View.INVISIBLE);
                }
                if(tabId==R.id.tab_box) {
                    donate.setEnabled(true);
                    donate.setVisibility(View.VISIBLE);
                    streetartist.setEnabled(false);
                    streetartist.setVisibility(View.INVISIBLE);
                    listener.setEnabled(false);
                    listener.setVisibility(View.INVISIBLE);
                }
                if(tabId==R.id.tab_guitar) {
                    streetartist.setEnabled(true);
                    streetartist.setVisibility(View.VISIBLE);
                    listener.setEnabled(false);
                    listener.setVisibility(View.INVISIBLE);
                    donate.setEnabled(false);
                    donate.setVisibility(View.INVISIBLE);
                }
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
            }
        });
    }

    public void ChangeToSA(View v) {
        Intent intent = new Intent(getApplicationContext(), SAActivity.class);
        startActivity(intent);
    }
    public void ChangeToLR(View v) {
        Intent intent = new Intent(getApplicationContext(), LRActivity.class);
        startActivity(intent);
    }
    public void ChangeToDN(View v) {
        Intent intent = new Intent(getApplicationContext(), DNActivity.class);
        startActivity(intent);
    }
}
