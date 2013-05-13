package com.nzmtech.proximitytools;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.widget.Toast;


public class ProximityHandler extends Service implements SensorEventListener {
	float dist;
	Context context;
	SensorManager manager;
	Sensor proximity;
	 @Override
	   public IBinder onBind(Intent intent) {
	      return null;
	   }

	   @Override
	   public void onCreate() {
		   context=getApplicationContext();
		   manager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
			if(manager.getSensorList(Sensor.TYPE_PROXIMITY).size() != 0)
			{
				proximity = manager.getSensorList(Sensor.TYPE_PROXIMITY).get(0);
				manager.registerListener(this,proximity,SensorManager.SENSOR_DELAY_NORMAL);
			}
		   Toast.makeText(context, "Activated sensor service!", Toast.LENGTH_SHORT).show();
	   }

	   @Override
	   public void onDestroy() {
		   //stop listening!
		   manager.unregisterListener(this);
	   }

	   @Override
	   public void onStart(Intent intent, int startid) {
		   
	   }
	
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		//IDGAF
	}
	
	public void onSensorChanged(SensorEvent event) {
		dist=event.values[0];	
		KeyguardManager kgMgr = 
			    (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
		boolean locked = kgMgr.inKeyguardRestrictedInputMode();
		if(locked) {
			manager.unregisterListener(this);
			while(kgMgr.inKeyguardRestrictedInputMode());
			manager.registerListener(this, proximity,SensorManager.SENSOR_DELAY_NORMAL);
		}
		else if(dist==0.0f)
		{
			SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
			String shortcut=prefs.getString("shortcut", "settings");
			if(shortcut.equals("settings")){
				Intent i= new Intent(android.provider.Settings.ACTION_SETTINGS);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(i);
			}
			else if(shortcut.equals("other")) {
				PackageManager packageManager = this.getPackageManager();
				Intent launchIntent = packageManager.getLaunchIntentForPackage(prefs.getString("other", "com.nzmtech.proximitytools.MainActivity"));
				launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(launchIntent);
			}
			else if(shortcut.equals("vibrate"))
			{
				AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
				am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
			}
			else if(shortcut.equals("silent"))
			{
				AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
				am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			}
		}
	}
}
