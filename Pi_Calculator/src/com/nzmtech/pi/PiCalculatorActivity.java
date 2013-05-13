package com.nzmtech.pi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tapfortap.AdView;
import com.tapfortap.TapForTap;

public class PiCalculatorActivity extends Activity {
	
	Context context;
	double pi;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //TapForTap.setDefaultAppId("54e48940-8f45-012f-2aa8-40405d9d80d6");
        //TapForTap.checkIn(this);
        
        setContentView(R.layout.calculator_layout);
        
        //AdView adView = (AdView) findViewById(R.id.ad_view);
        //adView.loadAds();
    }
    
    public void leibniz10Million(View view)
    {
    	pi=0;
    	for(int i=0;i<10000000;i++)
    	{
    		pi+=Math.pow(-1,i)/(2*i+1);
    		
    	}
    	Context context = getApplicationContext();
    	Toast.makeText(context, "Calculated value after ten million iterations = " + String.valueOf(4*pi), Toast.LENGTH_LONG).show();
    }

    public void leibnizMillion(View view)
    {
    	pi=0;
    	for(int i=0;i<1000000;i++)
    	{
    		pi+=Math.pow(-1,i)/(2*i+1);
    		
    	}
    	Context context = getApplicationContext();
    	Toast.makeText(context, "Calculated value after one million iterations = " + String.valueOf(4*pi), Toast.LENGTH_LONG).show();
    }

    public void leibniz5Million(View view)
    {
    	pi=0;
    	for(int i=0;i<5000000;i++)
    	{
    		pi+=Math.pow(-1,i)/(2*i+1);
    		
    	}
    	Context context = getApplicationContext();
    	Toast.makeText(context, "Calculated value after five million iterations = " + String.valueOf(4*pi), Toast.LENGTH_LONG).show();
    }

    public void leibniz100Thousand(View view)
    {
    	pi=0;
    	for(int q=0;q<100000;q++)
    	{
    		pi+=Math.pow(-1,q)/(2*q+1);
    		
    	}
    	Context context = getApplicationContext();
    	Toast.makeText(context, "Calculated value after 100,000 iterations = " + String.valueOf(4*pi), Toast.LENGTH_LONG).show();
    }
}
