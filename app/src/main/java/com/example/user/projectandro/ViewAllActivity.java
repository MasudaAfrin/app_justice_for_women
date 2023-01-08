package com.example.nusratjahan.user1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewAllActivity extends AppCompatActivity {


    private ListView studentListView;
    private ArrayList<StudentInfo> allStudent;
    private DatabaseReference databaseReference;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);
        Bundle bundle=getIntent().getExtras();
        studentListView = findViewById(R.id.listAllStudent);
        allStudent = new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference("APP");
        getAlldataFromDB();
    }

    private void getAlldataFromDB() {
        databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot data: dataSnapshot.getChildren()){

                Bundle bundle=getIntent().getExtras();
            StudentInfo value = data.getValue(StudentInfo.class);

            String type1= bundle.getString("key");
         if(value.type.matches(type1))
          {
            allStudent.add(value);
            ItemStudentAdapter studentAdapter = new ItemStudentAdapter(ViewAllActivity.this, allStudent);
        studentListView.setAdapter(studentAdapter); }}
        }  @Override public void onCancelled(DatabaseError error) {
        //Log.w(TAG, "Failed to read value.", error.toException());
        }    }); }
}
