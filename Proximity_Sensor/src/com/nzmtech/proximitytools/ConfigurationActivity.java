package com.nzmtech.proximitytools;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(4)
public class ConfigurationActivity extends PreferenceActivity {
	TextView shortcut;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        addPreferencesFromResource(R.xml.preferences);
	        setContentView(R.layout.settings);
	        shortcut=(TextView) findViewById(R.id.shortcutText);
	        updateTextView();
	    }
	 
	 public void chooseActivity(View v)
	 {
	   	 	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

	        if(prefs.getString("shortcut","settings").equals("other"))
	        {
	    	    Intent localIntent2 = new Intent("android.intent.action.PICK_ACTIVITY");
	    	    Intent localIntent3 = new Intent("android.intent.action.MAIN",null);
	    	    localIntent3.addCategory("android.intent.category.LAUNCHER");   
	    	    localIntent2.putExtra("android.intent.extra.INTENT",localIntent3);
	    	    startActivityForResult(localIntent2, 1);
	        }
	        else
	        	Toast.makeText(this, "Please set the shortcut to 'Other activity', then use this button to pick an activity to open.", Toast.LENGTH_LONG).show();
	 }
	 @Override
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		 SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());

	     // Check which request it is that we're responding to
	     if (requestCode == 1) {
	    	   if (data != null) {
	    		      // launch the application that we just picked
					PackageManager pm = this.getPackageManager();
		        	 prefs.edit().putString("other",data.resolveActivity(pm).getPackageName()).commit();
		        	 updateTextView();

	    	   }
	         }
	 }
	 private void updateTextView()
	 {
		PackageManager pm = this.getPackageManager();
		SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());

		try {
			shortcut.setText(pm.getApplicationLabel(pm.getApplicationInfo(prefs.getString("other","com.nzmtech.proximitytools.MainActivity"), 0)));
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	 }
}
