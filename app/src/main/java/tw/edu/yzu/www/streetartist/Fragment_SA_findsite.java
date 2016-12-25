package tw.edu.yzu.www.streetartist;

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
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static tw.edu.yzu.www.streetartist.JsonParser.json;

import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.BoomButtons.HamButton;
/**
 * Created by user on 2016/12/20.
 */

public class Fragment_SA_findsite extends Fragment {
    public class ArtPlaceSting {

        private String place ;
        private String address ;
        private String applyunit ;
        private String phone ;
        private String fax ;
        private String email ;
        private String register ;
    }

    static ArtPlaceSting[] PlaceString ;
    boolean first=true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.fragment_sa_findsite, container, false);
        if (first==true){
            PlaceString =new ArtPlaceSting[285];
            for(int i=0;i<285;i++){
                PlaceString[i] = new ArtPlaceSting();
            }
            first=false;
        }
        new AsyncTaskParseJson().execute();

        ListView listView = (ListView) v.findViewById(R.id.list_view);
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

        v.setFocusable(true);
        v.setFocusableInTouchMode(true);
        v.requestFocus();

        v.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( event.getAction()== KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK )
                {
                    SAActivity.findsite.setVisibility(View.VISIBLE);
                    SAActivity.update.setVisibility(View.VISIBLE);
                }
                return false;
            }
        } );

        return v;
    }
    static class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 285;
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
            viewHolder.text.setText(PlaceString[position].place+"("+PlaceString[position].address+")");


            viewHolder.bmb2.clearBuilders();
            for (int i = 0; i < viewHolder.bmb2.getPiecePlaceEnum().pieceNumber(); i++) {
                if (i == 0)
                    viewHolder.bmb2.addBuilder(new HamButton.Builder().normalText("Apply Unit: "+PlaceString[position].applyunit).subNormalText("Phone: "+PlaceString[position].phone));
                if (i == 1)
                    viewHolder.bmb2.addBuilder(new HamButton.Builder().normalText("E-mail: "+PlaceString[position].email).subNormalText("Fax :"+PlaceString[position].fax));
                if (i == 2)
                    viewHolder.bmb2.addBuilder(new HamButton.Builder().normalText("辦理方式:  "+PlaceString[position].register));
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
        String JsonUrl = "http://cloud.culture.tw/frontsite/trans/SearchPerformPlaceAction.do?method=doFindPerformPlaceTypeJ";
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
                int len = dataJsonArr.length();
                Log.i("wwww",Integer.toString(len));
                for(int i=0;i<len;i++){
                    JSONObject c = dataJsonArr.getJSONObject(i);
                    // Storing each json item in variable
                    PlaceString[i].place = c.getString("placeName");
                    PlaceString[i].address = c.getString("address");
                    PlaceString[i].applyunit = c.getString("applyUnit");
                    PlaceString[i].phone = c.getString("officePhone");
                    PlaceString[i].fax = c.getString("fax");
                    PlaceString[i].email= c.getString("email");
                    PlaceString[i].register= c.getString("register");

                    // show the values in our logcat
                    Log.e(TAG,"Place:" + PlaceString[i].place + ",  Adress:" + PlaceString[i].address+ ",  ApplyUnit:" + PlaceString[i].applyunit+ ",  Phone:" + PlaceString[i].phone+ ",  Fax:" + PlaceString[i].fax+ ",  Email:" + PlaceString[i].email+ ",  Register:" + PlaceString[i].register);
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

