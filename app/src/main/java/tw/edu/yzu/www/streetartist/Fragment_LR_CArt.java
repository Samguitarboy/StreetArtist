package tw.edu.yzu.www.streetartist;

/**
 * Created by user on 2016/12/20.
 */

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomMenuButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import static tw.edu.yzu.www.streetartist.JsonParser.json;


/**
 * Created by user on 2016/12/20.
 */

public class Fragment_LR_CArt extends Fragment {
    public class ArtString {
        private String name ;
        private String city ;
        private String theme ;
    }
    static ArtString[] artString;
    boolean first = true;
    static int count=0;
    Button refresh;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.cretive_art, container, false);
        refresh = (Button)v.findViewById(R.id.refbutton);
        if (first){
            artString =new ArtString[3500];
            for(int i=0;i<3500;i++) {
                artString[i] = new ArtString();
            }
            new AsyncTaskParseJson().execute();
            first=false;
        }

        final ListView listView = (ListView) v.findViewById(R.id.list_view);
        assert listView != null;
        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        BoomMenuButton bmb = (BoomMenuButton)view.findViewById(R.id.bmb2);
                        bmb.boom();
                    }
                });
        refresh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                listView.setAdapter(new MyAdapter());
                listView.setOnItemClickListener(
                        new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                BoomMenuButton bmb = (BoomMenuButton) view.findViewById(R.id.bmb2);
                                bmb.boom();

                            }
                        });
            }
        });
        v.setFocusable(true);
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
                    Fragment_LR.performart.setVisibility(View.VISIBLE);
                    Fragment_LR.viewart.setVisibility(View.VISIBLE);
                    Fragment_LR.creativeart.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });

        return v;
    }
    static class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, final ViewGroup parent) {

            final ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);

                viewHolder = new ViewHolder();
                viewHolder.text = (TextView) convertView.findViewById(R.id.text);
                viewHolder.bmb2 = (BoomMenuButton) convertView.findViewById(R.id.bmb2);


                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }


            viewHolder.text.setText(artString[position].name+"("+artString[position].theme+")");


            viewHolder.bmb2.clearBuilders();
            for (int i = 0; i < viewHolder.bmb2.getPiecePlaceEnum().pieceNumber(); i++) {
                if (i == 0)
                    viewHolder.bmb2.addBuilder(new HamButton.Builder().normalText("表演者姓名："+artString[position].name));
                if (i == 1)
                    viewHolder.bmb2.addBuilder(new HamButton.Builder().normalText("表演主題："+artString[position].theme));
                if (i == 2)
                    viewHolder.bmb2.addBuilder(new HamButton.Builder().normalText("所在縣市： "+artString[position].city));
            }


            return convertView;
        }

        class ViewHolder {
            TextView text;
            BoomMenuButton bmb2;
        }

    }

    public class AsyncTaskParseJson extends AsyncTask<String, String, String> {

        final String TAG = "AsyncTaskParseJson.java";

        // set your json string url here
        String JsonUrl = "http://cloud.culture.tw/frontsite/trans/SearchBuskerAction.do?method=doFindBuskerTypeJ";

        // contacts JSONArray
        JSONArray dataJsonArr = null;

        @Override
        protected void onPreExecute() {}

        @Override
        protected String doInBackground(String... arg0) {

            try {

                // instantiate our json parser
                JsonParser jParser = new JsonParser();

                // get json string from url
                jParser.getJSONFromUrl(JsonUrl);
                dataJsonArr = new JSONArray(json);
                int len=dataJsonArr.length();
                for(int i=0;i<len;i++){
                    JSONObject c = dataJsonArr.getJSONObject(i);
                    // Storing each json item in variable
                    if (!c.isNull("performTheme") && !c.isNull("performerName")) {//return true or false)
                        if(Objects.equals(c.getString("performerActType"), "創意工藝")) {

                            artString[count].name = c.getString("performerName");
                            artString[count].city = c.getString("cityName");
                            artString[count].theme = c.getString("performTheme");

                            Log.e(TAG, "Name:" + artString[count].name + ",  City:" + artString[count].city + ",  Theme:" + artString[count].theme);
                            count++;
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String strFromDoInBg) {}
    }
}






