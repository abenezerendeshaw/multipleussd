package com.ussd;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class CustomModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;

    public CustomModule(ReactApplicationContext context ) {
        super(context);
        reactContext = context;
    }


    @ReactMethod

    public  void show(){

        Intent callIntent = new Intent(Intent.ACTION_CALL);


        String ussdCode = "*999*2*1*2*1*1*1"  + Uri.encode("#");
        callIntent.setData(Uri.parse("tel:" +ussdCode));

        if (ActivityCompat.checkSelfPermission(reactContext,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        reactContext.startActivity(callIntent);

        Toast.makeText(reactContext,"this is cool", Toast.LENGTH_LONG ).show();

    }

    @NonNull
    @Override
    public String getName() {
        return "CustomModule";
    }
}
