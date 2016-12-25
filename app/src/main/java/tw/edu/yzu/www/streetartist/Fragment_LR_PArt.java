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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import static tw.edu.yzu.www.streetartist.JsonParser.json;


/**
 * Created by user on 2016/12/20.
 */

public class Fragment_LR_PArt extends Fragment {
    public class ArtString {
        private String name ;
        private String city ;
        private String theme ;
    }
    ArtString[] artString;
    boolean first = true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.per_art, container, false);
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
                    if (c.isNull("performTheme")==false&&c.isNull("performerName")==false) {//return true or false)
                        if(Objects.equals(c.getString("performerActType"), "表演藝術")) {
                            artString[i].name = c.getString("performerName");
                            artString[i].city = c.getString("cityName");
                            artString[i].theme = c.getString("performTheme");

                            Log.e(TAG, "Name:" + artString[i].name + ",  City:" + artString[i].city + ",  Theme:" + artString[i].theme);
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
