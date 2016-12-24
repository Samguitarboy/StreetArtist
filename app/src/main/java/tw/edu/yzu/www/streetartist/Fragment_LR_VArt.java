package tw.edu.yzu.www.streetartist;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static tw.edu.yzu.www.streetartist.JsonParser.json;

/**
 * Created by user on 2016/12/20.
 */

public class Fragment_LR_VArt extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.view_art, container, false);
		new AsyncTaskParseJson().execute();
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
                    Fragment_LR.performart.setVisibility(View.VISIBLE);
                    Fragment_LR.viewart.setVisibility(View.VISIBLE);
                    Fragment_LR.creativeart.setVisibility(View.VISIBLE);
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






                    String place = c.getString("placeName");
                    String address = c.getString("address");
                    String applyunit = c.getString("applyUnit");
                    String phone = c.getString("officePhone");
                    String fax = c.getString("fax");
                    String email= c.getString("email");
                    String register= c.getString("register");

                    // String performer = c.getString("performerName");
                    //  String city = c.getString("cityName");
                    // String theme = c.getString("performTheme");
                    // String type= c.getString("performerActType");
//String username = c.getString("username");

                        // show the values in our logcat

                        Log.e(TAG,"Place:" + place + ",  Adress:" +address+ ",  ApplyUnit:" +applyunit+ ",  Phone:" +phone+ ",  Fax:" +fax+ ",  Email:" +email+ ",  Register:" +register);

                }

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
