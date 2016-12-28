package tw.edu.yzu.www.streetartist;

import android.app.Fragment;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 阿賢賢 on 2016/12/22.
 */

public class Fragment_LR_recentshow extends Fragment{
    public MySQLiteManager db;
    //public TextView recent;
    public Button clear;
    private ExpandableListView listView;
    private MyAdapter adapter;
    private  List<String> group;
    private  List<List<String>> child;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v =inflater.inflate(R.layout.fragment_lr_recentshow, container, false);
        //recent = (TextView) v.findViewById(R.id.data);

        clear = (Button)v.findViewById(R.id.clear);
        db=new MySQLiteManager(getActivity());
        Cursor all = db.getAll();
        String str = "";
        int i=0;
        listView=(ExpandableListView)v.findViewById(R.id.expandable_list);
        adapter = new MyAdapter();

        group = new ArrayList<String>();
        child = new ArrayList<List<String>>();
        //String[] a = {all.getString(all.getColumnIndex("place")) , all.getString(all.getColumnIndex("context"))  , all.getString(all.getColumnIndex("introduction"))};
        // addInfo("aaaa", new String[]{/*all.getString(all.getColumnIndex("place")) + "\n" + all.getString(all.getColumnIndex("context")) + "\n" + all.getString(all.getColumnIndex("introduction"))*/"wwwww"});
        //while(all.moveToNext()) {
            while(all.moveToPosition(i)){
                str = all.getString(all.getColumnIndex("date")) + "  " + all.getString(all.getColumnIndex("time")) + "  " + all.getString(all.getColumnIndex("name"));
                group.add(str);
               // addInfo(str, new String[]{all.getString(all.getColumnIndex("place")) , all.getString(all.getColumnIndex("context"))  , all.getString(all.getColumnIndex("introduction"))});
                List<String> list = new ArrayList<String>();
                list.add(all.getString(all.getColumnIndex("place")));
                Log.i("00",all.getString(all.getColumnIndex("place")));
                list.add(all.getString(all.getColumnIndex("context")));
                Log.i("01",all.getString(all.getColumnIndex("context")));
                list.add(all.getString(all.getColumnIndex("introduction")));
                Log.i("02",all.getString(all.getColumnIndex("introduction")));
                child.add(list);
                i++;
                if(i==db.count())break;
            }

       /* for(int j=0;j<3;j++) {
            List<String> list = new ArrayList<String>();
            list.add(all.getString(all.getColumnIndex("place")));
            Log.i("00",all.getString(all.getColumnIndex("place")));
            list.add(all.getString(all.getColumnIndex("context")));
            Log.i("01",all.getString(all.getColumnIndex("context")));
            list.add(all.getString(all.getColumnIndex("introduction")));
            Log.i("02",all.getString(all.getColumnIndex("introduction")));
            child.add(list);
        }*/
            //recent.setText(str);
       // }

        listView.setAdapter(adapter);
        listView.setGroupIndicator(null);


        //clear.setEnabled(false);
        clear.setVisibility(View.INVISIBLE);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.clear();
                //recent.setText("");
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
/*
    public void addInfo(String g , String[] c){
        group.add(g);
        List<String>list = new ArrayList<String>();
        for(int i = 0;i<c.length;i++) {
            list.add(c[i]);
            child.add(list);
        }
    }*/
    class MyAdapter extends BaseExpandableListAdapter{

        @Override
        public int getGroupCount() {
            return group.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 3;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return group.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return child.get(groupPosition).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            TextView textView = null;
            if(convertView==null)
                textView = new TextView(getActivity());
            else
                textView=(TextView)convertView;
            textView.setText(group.get(groupPosition));
            textView.setTextSize(25);
            textView.setTextColor(Color.BLACK);
            textView.setPadding(36,10,0,10);
            return textView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            TextView textView = null;
            if(convertView==null)
                textView = new TextView(getActivity());
            else
                textView=(TextView)convertView;
            textView.setText(child.get(groupPosition).get(childPosition));
            Log.i("group",Integer.toString(groupPosition));
            Log.i("child",Integer.toString(childPosition));
            textView.setTextSize(20);
            textView.setTextColor(Color.BLACK);
            textView.setPadding(72,10,0,10);
            return textView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
