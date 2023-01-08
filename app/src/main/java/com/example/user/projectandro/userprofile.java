package com.example.nusratjahan.user1;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.*;

public class userprofile extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    TextView nameuser, emailuser;
    Button law, lawer, ngo, govt, settings;
    String p;
    ImageButton call;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        nameuser = findViewById(R.id.nameuser);
        emailuser = findViewById(R.id.emailuser);
        law = findViewById(R.id.Law);
        lawer = findViewById(R.id.Lawer);
        ngo = findViewById(R.id.Ngo);
        govt = findViewById(R.id.GOVT);
        settings = findViewById(R.id.Settings);
        call = findViewById(R.id.call);
        image = findViewById(R.id.image);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
        law.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), law.class);
                p = law.getText().toString();

                startActivity(intent);


            }
        });
        lawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), lawer.class);
                p = lawer.getText().toString();
                // intent.putExtra("key",p);
                startActivity(intent);

            }
        });

        ngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ngoo.class);
                p = ngo.getText().toString();
                // intent.putExtra("key",p);
                startActivity(intent);


            }
        });
        govt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), govt.class);
                p = ngo.getText().toString();
                // intent.putExtra("key",p);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

        private void makePhoneCall () {

            String number = "123";
            if (ContextCompat.checkSelfPermission(userprofile.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(userprofile.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        }
    }

