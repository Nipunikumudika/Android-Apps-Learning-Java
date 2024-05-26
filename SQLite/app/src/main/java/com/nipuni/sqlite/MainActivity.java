package com.nipuni.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_name;
    private EditText et_tp;
    private Button btn_add;
    private Button btn_update;
    private Button btn_delete;
    private Button btn_view;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name);
        et_tp = findViewById(R.id.et_tp);
        btn_add = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);
        btn_update = findViewById(R.id.btn_update);
        btn_view = findViewById(R.id.btn_view);

        dbHelper = new DBHelper(this);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String tp = et_tp.getText().toString();

                Boolean isDataAdded = dbHelper.insertUserData(name,tp);

                if(isDataAdded==true){
                    Toast.makeText(MainActivity.this,"Data Added...",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Error...",Toast.LENGTH_SHORT).show();
                }
            }
        });


        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = dbHelper.getData();
                if(cursor.getCount()==0){
                    Toast.makeText(MainActivity.this,"No data to show...",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()){
                    buffer.append("name:"+cursor.getString(0)+"\n");
                    buffer.append("Tp:"+cursor.getString(1)+"\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Saved data");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String tp = et_tp.getText().toString();

                Boolean isUserUpdated = dbHelper.updateUserData(name,tp);

                if(isUserUpdated == true){
                    Toast.makeText(MainActivity.this,"Data updated...",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Data not updated...",Toast.LENGTH_SHORT).show();
                }
            }
        });


        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                Boolean isDataDeleted = dbHelper.deleteUserData(name);

                if(isDataDeleted == true){
                    Toast.makeText(MainActivity.this,"Data deleted...",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Data not deleted...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}