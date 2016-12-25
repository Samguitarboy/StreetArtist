package tw.edu.yzu.www.streetartist;

import android.app.Fragment;
import android.graphics.Color;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static tw.edu.yzu.www.streetartist.JsonParser.json;

import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.BoomButtons.HamButton;

import java.util.Objects;

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
    boolean first= true;
    Button newTaipei,miao,taichung,cloud,kao;
    static int num=285;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.fragment_sa_findsite, container, false);

        newTaipei = (Button)v.findViewById(R.id.newtaipei);
        miao= (Button)v.findViewById(R.id.miauli);
        taichung= (Button)v.findViewById(R.id.taichung);
        cloud = (Button)v.findViewById(R.id.cloud);
        kao= (Button)v.findViewById(R.id.kao);

        if (first==true){
            PlaceString =new ArtPlaceSting[285];
            for(int i=0;i<285;i++){
                PlaceString[i] = new ArtPlaceSting();
            }
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

        newTaipei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newTaipei.setBackgroundResource(android.R.drawable.btn_star);
                miao.setBackgroundResource(android.R.drawable.btn_default);
                taichung.setBackgroundResource(android.R.drawable.btn_default);
                cloud.setBackgroundResource(android.R.drawable.btn_default);
                kao.setBackgroundResource(android.R.drawable.btn_default);

                num=79;
                new AsyncTaskParseJson().execute();
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
        miao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miao.setBackgroundResource(android.R.drawable.btn_star);
                newTaipei.setBackgroundResource(android.R.drawable.btn_default);
                taichung.setBackgroundResource(android.R.drawable.btn_default);
                cloud.setBackgroundResource(android.R.drawable.btn_default);
                kao.setBackgroundResource(android.R.drawable.btn_default);
                num=30;
                new AsyncTaskParseJson().execute();
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
        taichung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taichung.setBackgroundResource(android.R.drawable.btn_star);
                newTaipei.setBackgroundResource(android.R.drawable.btn_default);
                miao.setBackgroundResource(android.R.drawable.btn_default);
                cloud.setBackgroundResource(android.R.drawable.btn_default);
                kao.setBackgroundResource(android.R.drawable.btn_default);
                num=46;
                new AsyncTaskParseJson().execute();
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
        cloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cloud.setBackgroundResource(android.R.drawable.btn_star);
                newTaipei.setBackgroundResource(android.R.drawable.btn_default);
                taichung.setBackgroundResource(android.R.drawable.btn_default);
                miao.setBackgroundResource(android.R.drawable.btn_default);
                kao.setBackgroundResource(android.R.drawable.btn_default);
                num=34;
                new AsyncTaskParseJson().execute();
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

        kao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kao.setBackgroundResource(android.R.drawable.btn_star);
                newTaipei.setBackgroundResource(android.R.drawable.btn_default);
                miao.setBackgroundResource(android.R.drawable.btn_default);
                taichung.setBackgroundResource(android.R.drawable.btn_default);
                cloud.setBackgroundResource(android.R.drawable.btn_default);
                num=40;
                new AsyncTaskParseJson().execute();
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
            return num;
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

            if (Objects.equals(PlaceString[position].address, ""))
                viewHolder.text.setText(PlaceString[position].place);
            else
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
                int len = num;
                Log.i("wwww",Integer.toString(len));
                if(len==79) {
                    for (int i = 0; i < len; i++) {
                        JSONObject c = dataJsonArr.getJSONObject(i + 119);
                        // Storing each json item in variable
                        PlaceString[i].place = c.getString("placeName");
                        PlaceString[i].address = c.getString("address");
                        PlaceString[i].applyunit = c.getString("applyUnit");
                        PlaceString[i].phone = c.getString("officePhone");
                        PlaceString[i].fax = c.getString("fax");
                        PlaceString[i].email = c.getString("email");
                        PlaceString[i].register = c.getString("register");

                        if (Objects.equals(PlaceString[i].applyunit, ""))
                            PlaceString[i].applyunit = "無紀錄";
                        if (Objects.equals(PlaceString[i].phone, ""))
                            PlaceString[i].phone = "無紀錄";
                        if (Objects.equals(PlaceString[i].fax, ""))
                            PlaceString[i].fax = "無紀錄";
                        if (Objects.equals(PlaceString[i].email, ""))
                            PlaceString[i].email = "無紀錄";
                        if (Objects.equals(PlaceString[i].register, ""))
                            PlaceString[i].register = "無紀錄";
                        // show the values in our logcat
                        Log.e(TAG, "Place:" + PlaceString[i].place + ",  Adress:" + PlaceString[i].address + ",  ApplyUnit:" + PlaceString[i].applyunit + ",  Phone:" + PlaceString[i].phone + ",  Fax:" + PlaceString[i].fax + ",  Email:" + PlaceString[i].email + ",  Register:" + PlaceString[i].register);
                    }
                }
                if(len==30){
                        for(int i=0;i<len;i++) {
                            JSONObject c = dataJsonArr.getJSONObject(i+88);
                            // Storing each json item in variable
                            PlaceString[i].place = c.getString("placeName");
                            PlaceString[i].address = c.getString("address");
                            PlaceString[i].applyunit = c.getString("applyUnit");
                            PlaceString[i].phone = c.getString("officePhone");
                            PlaceString[i].fax = c.getString("fax");
                            PlaceString[i].email = c.getString("email");
                            PlaceString[i].register = c.getString("register");

                            if (Objects.equals(PlaceString[i].applyunit, ""))
                                PlaceString[i].applyunit = "無紀錄";
                            if (Objects.equals(PlaceString[i].phone, ""))
                                PlaceString[i].phone = "無紀錄";
                            if (Objects.equals(PlaceString[i].fax, ""))
                                PlaceString[i].fax = "無紀錄";
                            if (Objects.equals(PlaceString[i].email, ""))
                                PlaceString[i].email = "無紀錄";
                            if (Objects.equals(PlaceString[i].register, ""))
                                PlaceString[i].register = "無紀錄";
                            // show the values in our logcat
                            Log.e(TAG, "Place:" + PlaceString[i].place + ",  Adress:" + PlaceString[i].address + ",  ApplyUnit:" + PlaceString[i].applyunit + ",  Phone:" + PlaceString[i].phone + ",  Fax:" + PlaceString[i].fax + ",  Email:" + PlaceString[i].email + ",  Register:" + PlaceString[i].register);
                        }
                }
                if(len==40) {
                    for (int i = 0; i < len; i++) {
                        JSONObject c = dataJsonArr.getJSONObject(i);
                        // Storing each json item in variable
                        PlaceString[i].place = c.getString("placeName");
                        PlaceString[i].address = c.getString("address");
                        PlaceString[i].applyunit = c.getString("applyUnit");
                        PlaceString[i].phone = c.getString("officePhone");
                        PlaceString[i].fax = c.getString("fax");
                        PlaceString[i].email = c.getString("email");
                        PlaceString[i].register = c.getString("register");

                        if (Objects.equals(PlaceString[i].applyunit, ""))
                            PlaceString[i].applyunit = "無紀錄";
                        if (Objects.equals(PlaceString[i].phone, ""))
                            PlaceString[i].phone = "無紀錄";
                        if (Objects.equals(PlaceString[i].fax, ""))
                            PlaceString[i].fax = "無紀錄";
                        if (Objects.equals(PlaceString[i].email, ""))
                            PlaceString[i].email = "無紀錄";
                        if (Objects.equals(PlaceString[i].register, ""))
                            PlaceString[i].register = "無紀錄";
                        // show the values in our logcat
                        Log.e(TAG, "Place:" + PlaceString[i].place + ",  Adress:" + PlaceString[i].address + ",  ApplyUnit:" + PlaceString[i].applyunit + ",  Phone:" + PlaceString[i].phone + ",  Fax:" + PlaceString[i].fax + ",  Email:" + PlaceString[i].email + ",  Register:" + PlaceString[i].register);
                    }
                }
                if(len==34) {
                    for (int i = 0; i < len; i++) {
                        JSONObject c = dataJsonArr.getJSONObject(i + 250);
                        // Storing each json item in variable
                        PlaceString[i].place = c.getString("placeName");
                        PlaceString[i].address = c.getString("address");
                        PlaceString[i].applyunit = c.getString("applyUnit");
                        PlaceString[i].phone = c.getString("officePhone");
                        PlaceString[i].fax = c.getString("fax");
                        PlaceString[i].email = c.getString("email");
                        PlaceString[i].register = c.getString("register");

                        if (Objects.equals(PlaceString[i].applyunit, ""))
                            PlaceString[i].applyunit = "無紀錄";
                        if (Objects.equals(PlaceString[i].phone, ""))
                            PlaceString[i].phone = "無紀錄";
                        if (Objects.equals(PlaceString[i].fax, ""))
                            PlaceString[i].fax = "無紀錄";
                        if (Objects.equals(PlaceString[i].email, ""))
                            PlaceString[i].email = "無紀錄";
                        if (Objects.equals(PlaceString[i].register, ""))
                            PlaceString[i].register = "無紀錄";
                        // show the values in our logcat
                        Log.e(TAG, "Place:" + PlaceString[i].place + ",  Adress:" + PlaceString[i].address + ",  ApplyUnit:" + PlaceString[i].applyunit + ",  Phone:" + PlaceString[i].phone + ",  Fax:" + PlaceString[i].fax + ",  Email:" + PlaceString[i].email + ",  Register:" + PlaceString[i].register);
                    }
                }
                if(len==46) {
                    for (int i = 0; i < len; i++) {
                        JSONObject c = dataJsonArr.getJSONObject(i + 41);
                        // Storing each json item in variable
                        PlaceString[i].place = c.getString("placeName");
                        PlaceString[i].address = c.getString("address");
                        PlaceString[i].applyunit = c.getString("applyUnit");
                        PlaceString[i].phone = c.getString("officePhone");
                        PlaceString[i].fax = c.getString("fax");
                        PlaceString[i].email = c.getString("email");
                        PlaceString[i].register = c.getString("register");

                        if (Objects.equals(PlaceString[i].applyunit, ""))
                            PlaceString[i].applyunit = "無紀錄";
                        if (Objects.equals(PlaceString[i].phone, ""))
                            PlaceString[i].phone = "無紀錄";
                        if (Objects.equals(PlaceString[i].fax, ""))
                            PlaceString[i].fax = "無紀錄";
                        if (Objects.equals(PlaceString[i].email, ""))
                            PlaceString[i].email = "無紀錄";
                        if (Objects.equals(PlaceString[i].register, ""))
                            PlaceString[i].register = "無紀錄";
                        // show the values in our logcat
                        Log.e(TAG, "Place:" + PlaceString[i].place + ",  Adress:" + PlaceString[i].address + ",  ApplyUnit:" + PlaceString[i].applyunit + ",  Phone:" + PlaceString[i].phone + ",  Fax:" + PlaceString[i].fax + ",  Email:" + PlaceString[i].email + ",  Register:" + PlaceString[i].register);
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

