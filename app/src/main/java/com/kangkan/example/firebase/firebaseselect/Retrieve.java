package com.kangkan.example.firebase.firebaseselect;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Retrieve extends AppCompatActivity {

    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String>adapter;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        user=new User();

        listView=findViewById(R.id.listView);
        database=FirebaseDatabase.getInstance();
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.user,R.id.UserInfo, list);


        ref=database.getReference("user");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()){

                    user=ds.getValue(User.class);
                    list.add(user.getPname().toString()+" "+user.getP_place().toString()+" "+user.getP_price().toString());
                }

                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                //Toast.makeText(Retrieve.this, "DB Error", Toast.LENGTH_LONG).show();

            }
        });

    }
}
