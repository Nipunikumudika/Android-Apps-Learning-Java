package com.nipuni.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn_gridview;
    private Button btn_recyclerview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_gridview=findViewById(R.id.btn_gridview);
        btn_recyclerview=findViewById(R.id.btn_recyclerview);

        btn_gridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentgridview=new Intent(getApplicationContext(),GridViewActivity.class);
                startActivity(intentgridview);
            }
        });

        btn_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentrecyclerview=new Intent(getApplicationContext(),RecyclerViewActivity.class);
                startActivity(intentrecyclerview);
            }
        });


    }
}