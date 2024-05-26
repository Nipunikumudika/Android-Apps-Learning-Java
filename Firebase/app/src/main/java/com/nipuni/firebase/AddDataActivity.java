package com.nipuni.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDataActivity extends AppCompatActivity {

    EditText et_name;
    EditText et_marks;
    Button btn_add;

    String name;
    String marks;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        et_name = findViewById(R.id.et_name);
        et_marks = findViewById(R.id.et_marks);
        btn_add = findViewById(R.id.btn_add);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("StudentInfo");

        //Register button click event
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = et_name.getText().toString().trim();
                marks = et_marks.getText().toString().trim();

                //Firebase Add Data


                UserDataBase userDataBase = new UserDataBase(name, marks);
                Log.d("TAG", "onClick: " + userDataBase);

                databaseReference.child(userDataBase.name).setValue(userDataBase).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });


            }
        });

    }
}