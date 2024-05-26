package com.nipuni.permissions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_sms;
    private Button btn_call;
    private Button btn_email;
    private Button btn_openshare;
    private Button btn_webview;
    private ImageView iv_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sms = findViewById(R.id.btn_sms);
        btn_call = findViewById(R.id.btn_call);
        btn_email = findViewById(R.id.btn_email);
        btn_openshare = findViewById(R.id.btn_openshare);
        btn_webview = findViewById(R.id.btn_webview);
        iv_1 = findViewById(R.id.iv_1);

        btn_sms.setOnClickListener(this);
        btn_call.setOnClickListener(this);
        btn_email.setOnClickListener(this);
        btn_openshare.setOnClickListener(this);
        btn_webview.setOnClickListener(this);
        iv_1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn_sms:
                Intent intentSMS = new Intent(getApplicationContext(),SendSmsActivity.class);
                startActivity(intentSMS);
                break;

            case R.id.btn_call:
                Intent intentCall = new Intent(getApplicationContext(),SendCallActivity.class);
                startActivity(intentCall);
                break;

            case R.id.btn_email:
                Intent intentEmail = new Intent(getApplicationContext(),SendEmailActivity.class);
                startActivity(intentEmail);
                break;

            case R.id.btn_openshare:
                Intent intentOpenShare = new Intent(getApplicationContext(),OpenshareActivity.class);
                startActivity(intentOpenShare);
                break;

            case R.id.btn_webview:
                Intent intentWebview = new Intent(getApplicationContext(),WebviewActivity.class);
                startActivity(intentWebview);
                break;
            case R.id.iv_1:
                String[] lang = {"English","Sinhala","Tamil"};
                AlertDialog.Builder m_builder = new AlertDialog.Builder(MainActivity.this);
                m_builder.setTitle("Choose Language...");
                m_builder.setSingleChoiceItems(lang, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i==0){
                            setLocal("en");
                            recreate();
                        }
                        else if(i==1){
                            setLocal("si");
                            recreate();
                        }
                        else if(i==2){
                            setLocal("ta");
                            recreate();
                        }
                    }
                });
                AlertDialog dialog = m_builder.create();
                dialog.show();
                break;

        }

    }
    private void setLocal(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
    }
}