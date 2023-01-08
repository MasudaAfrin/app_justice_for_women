package com.example.nusratjahan.user1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class ItemStudentAdapter extends BaseAdapter{

    private Context activity;    private ArrayList<StudentInfo> allStudent = new ArrayList<>(); private LayoutInflater layoutInflater = null;

    public ItemStudentAdapter(Context activity, ArrayList<StudentInfo> allStudent) {
        this.activity = activity;
        this.allStudent = allStudent;
        this.layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private static class ViewHolder{
        private TextView name, email, phn, type; }
        private ViewHolder viewHolder = null;
    @Override
    public int getCount() {
        return allStudent.size();
    }

    @Override
    public Object getItem(int position) {
        return allStudent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        final int pos = position;
        if(view == null){
            viewHolder = new ViewHolder();
        view = layoutInflater.inflate(R.layout.row_cell,null);
        viewHolder.name = view.findViewById(R.id.name1);
        viewHolder.email = view.findViewById(R.id.email1);
        viewHolder.phn =  view.findViewById(R.id.phn1);
        viewHolder.type =  view.findViewById(R.id.type1);
        view.setTag(viewHolder);         }else {
            viewHolder= (ViewHolder) view.getTag();         }
            viewHolder.name.setText(allStudent.get(pos).getFname());
        viewHolder.email.setText(allStudent.get(pos).getFemail());
        viewHolder.phn.setText(allStudent.get(pos).getFphn());
        viewHolder.type.setText(allStudent.get(pos).getType());
        return view;
    }
}
