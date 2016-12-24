package tw.edu.yzu.www.streetartist;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
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

    ArtString[] artString;
    boolean first = true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.view_art, container, false);
        if (first==true){
            artString =new ArtString[3500];
            for(int i=0;i<3500;i++) {
                artString[i] = new ArtString();
            }
            first=false;
        }
        new AsyncTaskParseJson().execute();
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
                       /* if (c.isNull("performTheme")==true&&c.isNull("perfoermerActType")==true) {//return true or false)
                            artString[i].name = c.getString("performerName");
                            artString[i].city = c.getString("cityName");
                            Log.e(TAG,"Name:" + artString[i].name + ",  City:" + artString[i].city );

                        }*/
                        if (c.isNull("performTheme")==false&&c.isNull("performerName")==false) {//return true or false)
                            artString[i].name = c.getString("performerName");
                            artString[i].city = c.getString("cityName");
                            artString[i].theme = c.getString("performTheme");
                            artString[i].type = c.getString("performerActType");
                            Log.e(TAG,"Name:" + artString[i].name + ",  City:" + artString[i].city+ ",  Theme:" + artString[i].theme+ ",  Type:" + artString[i].type );
                        }

                        // String performer = c.getString("performerName");
                        //  String city = c.getString("cityName");
                        // String theme = c.getString("performTheme");
                        // String type= c.getString("performerActType");
//String username = c.getString("username");

                        // show the values in our logcat



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

    class ArtString {

        String name ;
        String city ;
        String theme ;
        String type ;

    }




