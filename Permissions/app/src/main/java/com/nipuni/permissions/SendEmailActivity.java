package com.nipuni.permissions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SendEmailActivity extends AppCompatActivity {

    private Button btn_sendmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        btn_sendmail = findViewById(R.id.btn_sendmail);

        btn_sendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL , new String[]{"nipunikumudika@gmail.com", "mallikarachchi63@gmail.com",});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT , "This is the Body!");
                try {
                    startActivity(Intent.createChooser(emailIntent, "Done!"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(SendEmailActivity.this, "No Email client found!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}