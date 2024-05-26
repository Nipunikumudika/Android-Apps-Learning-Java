package com.nipuni.gridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView rv_contact;
    private ArrayList<String> names_list = new ArrayList<>();
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        rv_contact = findViewById(R.id.rv_contact);

        names_list.add("Npuni Kumudika");
        names_list.add("Premalal Chandrasiri");
        names_list.add("Nandawathi");
        names_list.add("Ranjith Lokusuriya");
        names_list.add("Renuka Damayanthi");
        names_list.add("Nadeesha Nethmini");
        names_list.add("Lakeesha Nethmini");
        names_list.add("Sanduni manjula");

        recyclerViewAdapter = new RecyclerViewAdapter(RecyclerViewActivity.this, names_list, new RecyclerViewAdapter.itemClickListner() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(getApplicationContext(), "Name: " , Toast.LENGTH_SHORT).show();
            }
        });
        rv_contact.setAdapter(recyclerViewAdapter);
        rv_contact.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
}