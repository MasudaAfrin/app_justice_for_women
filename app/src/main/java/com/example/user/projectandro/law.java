package com.example.nusratjahan.user1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class law extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;
    private int lastexpandable=-1;

    List<String>listDataHeader;
    HashMap<String,List<String>>listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_law);
        prepareListData();
        expandableListView=(ExpandableListView)findViewById(R.id.expandablelistviewid);
        customAdapter=new CustomAdapter(this,listDataHeader,listDataChild);
        expandableListView.setAdapter(customAdapter);


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String childstring =listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
                Toast.makeText(getApplicationContext(),childstring,Toast.LENGTH_LONG).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if(lastexpandable!=-1 && lastexpandable!=groupPosition)
                {
                    expandableListView.collapseGroup(lastexpandable);
                }
                lastexpandable=groupPosition;
            }
        });
    }
    public void prepareListData()
    {
        String[] headerstring=getResources().getStringArray(R.array.abbreviaion_list_header);
        String[] childstring=getResources().getStringArray(R.array.abbreviation_list_child);

        listDataHeader=new ArrayList<>();
        listDataChild=new HashMap<>();

        for(int i=0;i<headerstring.length;i++)
        {
            listDataHeader.add(headerstring[i]);
            List<String>child=new ArrayList<>();
            child.add(childstring[i]);

            listDataChild.put(listDataHeader.get(i),child);

        }
    }
}
