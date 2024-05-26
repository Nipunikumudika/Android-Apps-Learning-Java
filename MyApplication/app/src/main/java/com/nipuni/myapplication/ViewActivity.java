package com.nipuni.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    RecyclerView rv_data;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<UserDataBase> nameList = new ArrayList<>();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        rv_data= findViewById(R.id.rv_data);

        firebaseDatabase = FirebaseDatabase.getInstance();

        /*userAdapter = new UserAdapter(ViewActivity.this, nameList);
        rv_students_marks.setAdapter(userAdapter);
        rv_students_marks.setLayoutManager(new LinearLayoutManager(getApplicationContext()));*/

        databaseReference = firebaseDatabase.getReference("UserDataBase");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                Log.d("TAG", "onDataChange: " + snapshot);

                for (DataSnapshot data : snapshot.getChildren()){

                    UserDataBase userDataBase =  data.getValue(UserDataBase.class);
                    nameList.add(userDataBase);

                }

                Log.d("TAG", "onDataChange: " + nameList);

                recyclerViewAdapter = new RecyclerViewAdapter(ViewActivity.this, nameList);
                rv_data.setAdapter(recyclerViewAdapter);
                rv_data.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
}