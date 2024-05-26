package com.nipuni.permissions;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.PrimitiveIterator;

public class SendSmsActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_phoneno;
    private EditText et_message;
    private Button btn_send;
    private String phone_number;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        et_phoneno = findViewById(R.id.et_phoneno);
        et_message = findViewById(R.id.et_message);
        btn_send = findViewById(R.id.btn_send);

        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            if(checkSelfPermission(Manifest.permission.SEND_SMS)== getPackageManager().PERMISSION_DENIED){
                String[] permissions = {Manifest.permission.SEND_SMS};
                requestPermissions(permissions,1000);
            }
        }

        btn_send.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        phone_number = et_phoneno.getText().toString();
        msg = et_message.getText().toString();
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+94"+phone_number,null,msg,null,null);

    }
}