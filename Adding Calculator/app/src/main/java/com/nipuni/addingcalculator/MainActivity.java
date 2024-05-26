package com.nipuni.addingcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private EditText et_num1;
    private EditText et_num2;
    private TextView tv_result;
    private Button btn_add;
    private  Button btn_next;
    private Button btn_toast;
    private Button btn_snackbar;
    private ConstraintLayout MainC;

    private  int firstnum;
    private  int secondnum;
    private int total;
    private String total_string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_num1 = findViewById(R.id.ed_num1);
        et_num2 = findViewById(R.id.ed_num2);
        tv_result = findViewById(R.id.tv_result);
        btn_add = findViewById(R.id.btn_add);
        btn_next = findViewById(R.id.btn_next);
        btn_snackbar = findViewById(R.id.btn_snackbar);
        btn_toast = findViewById(R.id.btn_toast);
        MainC = findViewById(R.id.MainC);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstnum = Integer.parseInt(et_num1.getText().toString());
                secondnum = Integer.parseInt(et_num2.getText().toString());
                total = firstnum+secondnum;
                total_string = String.valueOf(total);
                Toast.makeText(getApplicationContext(),total_string,Toast.LENGTH_LONG).show();
                tv_result.setText(total_string);

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNext = new Intent(getApplicationContext(),NextActivity.class);
                startActivity(intentNext);
            }
        });

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hello Calculator",Toast.LENGTH_LONG).show();
            }
        });

        btn_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(MainC,"Total="+total_string,Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
    }
}