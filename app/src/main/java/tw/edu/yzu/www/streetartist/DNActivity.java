package tw.edu.yzu.www.streetartist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class DNActivity extends Activity {
    private ListView listView;
    private String[] list = {"鉛筆","原子筆","鋼筆","毛筆","彩色筆","彩色筆","彩色筆","彩色筆","彩色筆","彩色筆","彩色筆","彩色筆","彩色筆","彩色筆"};
    private ArrayAdapter<String> listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        listView = (ListView)findViewById(R.id.viewDesc);
        listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(listAdapter);
       // startActivity(new Intent(DNActivity.this,Pop.class));
    }
}
