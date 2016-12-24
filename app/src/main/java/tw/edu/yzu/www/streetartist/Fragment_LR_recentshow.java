package tw.edu.yzu.www.streetartist;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 阿賢賢 on 2016/12/22.
 */

public class Fragment_LR_recentshow extends Fragment{
    public MySQLiteManager db;
    public TextView recent;
    public Button clear;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.fragment_recentshow, container, false);
        recent = (TextView) v.findViewById(R.id.data);
        clear = (Button)v.findViewById(R.id.clear);
        db=new MySQLiteManager(getActivity());

        Cursor all = db.getAll();
        String str = "";
        if(all.moveToFirst()) {
            do {
                str += all.getString(all.getColumnIndex("date")) + "\n" + all.getString(all.getColumnIndex("time")) + "\n" +all.getString(all.getColumnIndex("name")) + "\n" +
                        all.getString(all.getColumnIndex("place")) + "\n" +all.getString(all.getColumnIndex("context")) + "\n" +all.getString(all.getColumnIndex("introduction")) + "\n" ;
            } while (all.moveToNext());
        }
        recent.setText(str);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.clear();
                recent.setText("");
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
                    LRActivity.data.setVisibility(View.VISIBLE);
                    LRActivity.rshow.setVisibility(View.VISIBLE);
                }
                return false;
            }
        } );
        return v;
    }
}
