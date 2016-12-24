package tw.edu.yzu.www.streetartist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class DNActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
       // startActivity(new Intent(DNActivity.this,Pop.class));
    }
}
