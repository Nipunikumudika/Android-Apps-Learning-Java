package com.nipuni.permissions;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendCallActivity extends AppCompatActivity {
    private EditText et_callphoneno;
    private Button btn_calling;
    private String phone_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_call);

        et_callphoneno = findViewById(R.id.et_callphoneno);
        btn_calling = findViewById(R.id.btn_calling);

        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            if(checkSelfPermission(Manifest.permission.CALL_PHONE)== getPackageManager().PERMISSION_DENIED){
                String[] permissions = {Manifest.permission.CALL_PHONE};
                requestPermissions(permissions,1000);
            }
        }


        btn_calling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone_num = et_callphoneno.getText().toString().trim();
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phone_num));
                startActivity(callIntent);
            }
        });
    }
}