package tw.edu.yzu.www.streetartist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 阿賢賢 on 2016/12/15.
 */

public class Fragment_SA_write extends Fragment {
    public MySQLiteManager db;
    private Button update;
    public EditText  name,date,time,place,context,introduction;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.fragment_sa_write, container, false);
        update = (Button)v.findViewById(R.id.UP);
        name=(EditText)v.findViewById(R.id.name);
        date=(EditText)v.findViewById(R.id.date);
        time=(EditText)v.findViewById(R.id.time);
        place=(EditText)v.findViewById(R.id.place);
        context=(EditText)v.findViewById(R.id.context);
        introduction=(EditText)v.findViewById(R.id.introduction);

        db=new MySQLiteManager(getActivity());

        update.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View a)
            {
                db.addData(name.getText().toString(),date.getText().toString(),time.getText().toString(),place.getText().toString(),context.getText().toString(),introduction.getText().toString());
                getFragmentManager().popBackStack();
                SAActivity.findsite.setVisibility(View.VISIBLE);
                SAActivity.update.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(),"上傳成功!!",Toast.LENGTH_SHORT).show();
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
}
