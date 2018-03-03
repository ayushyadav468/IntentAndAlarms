package com.example.ayushyadav.intentandalarms;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void call(View view){

        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

    }

    private void callUs(){
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_CALL);
        shareIntent.setData(Uri.parse("tel:+918447410671"));
        startActivity(shareIntent);

    }
}
