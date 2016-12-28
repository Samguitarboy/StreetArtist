package tw.edu.yzu.www.streetartist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wx.goodview.GoodView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class DNActivity extends Activity {
    private ListView listView;
    private String[] list = {"街頭藝人1","街頭藝人2","街頭藝人3","街頭藝人4","街頭藝人5","街頭藝人6","街頭藝人7","街頭藝人8","街頭藝人9","街頭藝人10"};
    private ArrayAdapter<String> listAdapter;
    private WebView myWebView;
    String web,webshort;
    GoodView goodView;
    private ArrayList<String> data = new ArrayList<String>();
    String[] rank = {"汪進發","張朝霖","曾信義","邱堡卿","鄭采合","曹錫榮","戴文珍","湯青","小JO","林俊杰"};
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_donate);
        goodView = new GoodView(this);


        ListView lv = (ListView) findViewById(R.id.donate);
        generateListContent();
        lv.setAdapter(new MyListAdaper(this, R.layout.item_view, data));


        listView = (ListView) findViewById(R.id.viewDesc);
        listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch(position){
                    case 0: {
                        web="https://www.youtube.com/embed/N_5AcM0gZ7Q";
                        webshort="N_5AcM0gZ7Q";
                        watchvideo(web,webshort);
                        break;
                    }
                    case 1: {
                        web="https://www.youtube.com/embed/cBVnwhFTiRg";
                        webshort="cBVnwhFTiRg";
                        watchvideo(web,webshort);
                        break;
                    }
                    case 2: {
                        web="https://www.youtube.com/embed/aI-pG_xEnmk";
                        webshort="aI-pG_xEnmk";
                        watchvideo(web,webshort);
                        break;
                    }
                    case 3: {
                        web="https://www.youtube.com/embed/FHFWlckPR-E";
                        webshort="FHFWlckPR-E";
                        watchvideo(web,webshort);
                        break;
                    }
                    case 4: {
                        web="https://www.youtube.com/embed/BlblBvpVgjE";
                        webshort="BlblBvpVgjE";
                        watchvideo(web,webshort);
                        break;
                    }
                    case 5: {
                        web="https://www.youtube.com/embed/aqYnMSUTFGU";
                        webshort="aqYnMSUTFGU";
                        watchvideo(web,webshort);
                        break;
                    }
                    case 6: {
                        web="https://www.youtube.com/embed/1xwr7Jw-dqM";
                        webshort="1xwr7Jw-dqM";
                        watchvideo(web,webshort);
                        break;
                    }
                    case 7: {
                        web="https://www.youtube.com/embed/hT_nvWreIhg";
                        webshort="hT_nvWreIhg";
                        watchvideo(web,webshort);
                        break;
                    }
                    case 8: {
                        web="https://www.youtube.com/embed/SXrDUyD-NoQ";
                        webshort="SXrDUyD-NoQ";
                        watchvideo(web,webshort);
                        break;
                    }
                    case 9: {
                        web="https://www.youtube.com/embed/4MOifTemEhU";
                        webshort="4MOifTemEhU";
                        watchvideo(web,webshort);
                        break;
                    }
                }
            }
        });
    }
    public void good(View view) {
        ((ImageView) view).setImageResource(R.drawable.icon1);
        goodView.setText("+1");
        //goodView.setTextInfo("+1",30,30);
        goodView.show(view);
    }
    private void generateListContent() {
        for(int i = 0; i < 10; i++) {
            data.add(rank[i]);
        }
    }
    private class MyListAdaper extends ArrayAdapter<String> {
        private int layout;
        private List<String> mObjects;
        private MyListAdaper(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            mObjects = objects;
            layout = resource;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewholder = null;
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.list_item_thumbnail);
                viewHolder.title = (TextView) convertView.findViewById(R.id.list_item_text);
                viewHolder.button = (ImageView) convertView.findViewById(R.id.list_item_btn);
                viewHolder.number = (TextView) convertView.findViewById(R.id.number);
                convertView.setTag(viewHolder);
            }
             mainViewholder = (ViewHolder) convertView.getTag();
            final ViewHolder finalMainViewholder = mainViewholder;
            mainViewholder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(getContext(), "Button was clicked for list item " + position, Toast.LENGTH_SHORT).show();
                    int num = Integer.parseInt(finalMainViewholder.number.getText().toString());
                    num++;
                    finalMainViewholder.number.setText(String.valueOf(num));
                }
            });
            mainViewholder.title.setText(getItem(position));

            return convertView;
        }
    }
    public class ViewHolder {

        ImageView thumbnail;
        TextView title;
        ImageView button;
        TextView number;
    }

    void watchvideo(String web,String webshort){
        String frameVideo = "<html><body><iframe width=\"336\" height=\"223\"  src=\""+web+"?autoplay=1&loop=1&playlist="+webshort+"\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        myWebView = (WebView) findViewById(R.id.viewHeader);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadData(frameVideo, "text/html", "utf-8");
    }
}

