package com.nzmtech.proximitytools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity  {

	TextView tv;
	Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getActionBar().setDisplayHomeAsUpEnabled(true);
        intent=new Intent(getApplicationContext(), ProximityHandler.class);
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void startService(View v)
    {
        this.startService(intent);
    }

    public void stopService(View v)
    {
        this.stopService(intent);
    }
    
    public void openSettings(View v)
    {
    	startActivity(new Intent(this,ConfigurationActivity.class));
    }
}
