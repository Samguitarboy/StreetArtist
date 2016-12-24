package tw.edu.yzu.www.streetartist;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static tw.edu.yzu.www.streetartist.JsonParser.json;

/**
 * Created by user on 2016/12/20.
 */

public class Fragment_SA_findsite extends Fragment {
    TextView test;
    ArtPlaceSting[] PlaceString;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.fragment_sa_findsite, container, false);
        PlaceString =new ArtPlaceSting[1000];
        for(int i=0;i<1000;i++){
            PlaceString[i] = new ArtPlaceSting();
        }
        new AsyncTaskParseJson().execute();
        test=(TextView) v.findViewById(R.id.testtext);
        v.setFocusable(true);
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        test.setText(PlaceString[0].place);
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
                JSONObject jsonobj = jParser.getJSONFromUrl(JsonUrl);

// get the array of users
                //dataJsonArr = json.getJSONArray();

// loop through all users
                dataJsonArr = new JSONArray(json);
                int len=dataJsonArr.length();
                for(int i=0;i<len;i++){
                    //for (int i = 0; i < dataJsonArr.length(); i++) {

                    JSONObject c = dataJsonArr.getJSONObject(i);

// Storing each json item in variable
                    PlaceString[i].place = c.getString("placeName");
                    PlaceString[i].address = c.getString("address");
                    PlaceString[i].applyunit = c.getString("applyUnit");
                    PlaceString[i].phone = c.getString("officePhone");
                    PlaceString[i].fax = c.getString("fax");
                    PlaceString[i].email= c.getString("email");
                    PlaceString[i].register= c.getString("register");

                    // String performer = c.getString("performerName");
                    //  String city = c.getString("cityName");
                    // String theme = c.getString("performTheme");
                    // String type= c.getString("performerActType");
//String username = c.getString("username");

                    // show the values in our logcat

                    Log.e(TAG,"Place:" + PlaceString[i].place + ",  Adress:" + PlaceString[i].address+ ",  ApplyUnit:" + PlaceString[i].applyunit+ ",  Phone:" + PlaceString[i].phone+ ",  Fax:" + PlaceString[i].fax+ ",  Email:" + PlaceString[i].email+ ",  Register:" + PlaceString[i].register);

                }

               // Log.e(TAG,"Place:" + PlaceString[0].place + ",  Adress:" + PlaceString[0].address);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String strFromDoInBg) {}
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
class ArtPlaceSting {

    String place ;
    String address ;
    String applyunit ;
    String phone ;
    String fax ;
    String email ;
    String register ;
}
