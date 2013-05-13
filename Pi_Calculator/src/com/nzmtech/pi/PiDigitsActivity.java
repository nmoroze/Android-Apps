package com.nzmtech.pi;

import android.app.Activity;
import android.os.Bundle;

import com.tapfortap.AdView;
import com.tapfortap.TapForTap;

public class PiDigitsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TapForTap.setDefaultAppId("54e48940-8f45-012f-2aa8-40405d9d80d6");
        TapForTap.checkIn(this);
        
       // AdView adView = (AdView) findViewById(R.id.ad_view1);
        //adView.loadAds();
        
        setContentView(R.layout.digits_layout);
    }
}