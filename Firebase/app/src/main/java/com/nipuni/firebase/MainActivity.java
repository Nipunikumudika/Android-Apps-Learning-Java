package com.nipuni.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button btn_logout;
    Button btn_add_data;
    Button btn_view_data;

    FirebaseAuth firebaseAuth;

    String user_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add_data = findViewById(R.id.btn_add);
        btn_view_data = findViewById(R.id.btn_view);
        btn_logout = findViewById(R.id.btn_logout);

        firebaseAuth = FirebaseAuth.getInstance();

        user_id = firebaseAuth.getCurrentUser().getUid();

        Toast.makeText(getApplicationContext(), user_id, Toast.LENGTH_SHORT).show();

        //Logout Event
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //user logout

                firebaseAuth.signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });

        //Add Data Event
        btn_add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd = new Intent(getApplicationContext(), AddDataActivity.class);
                startActivity(intentAdd);
            }
        });

        //View Data Event
        btn_view_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentView = new Intent(getApplicationContext(), ViewActivity.class);
                startActivity(intentView);
            }
        });
    }
}