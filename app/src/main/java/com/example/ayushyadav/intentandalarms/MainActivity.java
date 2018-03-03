package com.example.ayushyadav.intentandalarms;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    public void call(View view){

        int permissionGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if(permissionGranted == PackageManager.PERMISSION_GRANTED){
            callUs();
        }else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, 1);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            int grantResult = grantResults[0];
            if(grantResult == PackageManager.PERMISSION_GRANTED){
                callUs();;
            }else {
                Toast.makeText(this,"Permission Denied. ",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void callUs(){
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_CALL);
        shareIntent.setData(Uri.parse("tel:+918447410671"));
        startActivity(shareIntent);
    }

}
