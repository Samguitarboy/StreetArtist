package tw.edu.yzu.www.streetartist;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button streetartist,listener,donate;
    View title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        streetartist=(Button)findViewById(R.id.streetartist);
        listener=(Button)findViewById(R.id.listener);
        donate=(Button)findViewById(R.id.donate);
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
