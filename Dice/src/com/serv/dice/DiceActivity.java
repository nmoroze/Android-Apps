package com.serv.dice;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import java.util.Random;


public class DiceActivity extends Activity {
    public Random Rnd = new Random();
    public int result = 0;
    public int intModifier = 0;
    public TextView resultDisplay;
    public EditText modifier;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        resultDisplay = (TextView) findViewById(R.id.Result);
        modifier = (EditText) findViewById(R.id.Modifier);      
    }
    public void random4(View view){
    	if (modifier.getText().toString().equals("")){
    		intModifier = 0;
    	}
    	else{
    	intModifier = Integer.parseInt(modifier.getText().toString());
    	}
    	result = Rnd.nextInt(4)+1+intModifier;
    	resultDisplay.setText(String.valueOf(result-intModifier)+"+"+String.valueOf(intModifier)+"="+String.valueOf(result));
    }
    public void random6(View view){
    	if (modifier.getText().toString().equals("")){
    		intModifier = 0;
    	}
    	else{
    	intModifier = Integer.parseInt(modifier.getText().toString());
    	}
    	result = Rnd.nextInt(6)+1+intModifier;
    	resultDisplay.setText(String.valueOf(result-intModifier)+"+"+String.valueOf(intModifier)+"="+String.valueOf(result));
    }
    public void random8(View view){
    	if (modifier.getText().toString().equals("")){
    		intModifier = 0;
    	}
    	else{
    	intModifier = Integer.parseInt(modifier.getText().toString());
    	}
    	result = Rnd.nextInt(8)+1+intModifier;
    	resultDisplay.setText(String.valueOf(result-intModifier)+"+"+String.valueOf(intModifier)+"="+String.valueOf(result));
    }
    public void random10(View view){
    	if (modifier.getText().toString().equals("")){
    		intModifier = 0;
    	}
    	else{
    	intModifier = Integer.parseInt(modifier.getText().toString());
    	}
    	result = Rnd.nextInt(10)+1+intModifier;
    	resultDisplay.setText(String.valueOf(result-intModifier)+"+"+String.valueOf(intModifier)+"="+String.valueOf(result));
    }
    public void random12(View view){
    	if (modifier.getText().toString().equals("")){
    		intModifier = 0;
    	}
    	else{
    	intModifier = Integer.parseInt(modifier.getText().toString());
    	}
    	result = Rnd.nextInt(12)+1+intModifier;
    	resultDisplay.setText(String.valueOf(result-intModifier)+"+"+String.valueOf(intModifier)+"="+String.valueOf(result));
    }
    public void random20(View view){
    	if (modifier.getText().toString().equals("")){
    		intModifier = 0;
    	}
    	else{
    	intModifier = Integer.parseInt(modifier.getText().toString());
    	}
    	result = Rnd.nextInt(20)+1+intModifier;
    	resultDisplay.setText(String.valueOf(result-intModifier)+"+"+String.valueOf(intModifier)+"="+String.valueOf(result));
    }
    public void random100(View view){
    	if (modifier.getText().toString().equals("")){
    		intModifier = 0;
    	}
    	else{
    	intModifier = Integer.parseInt(modifier.getText().toString());
    	}
    	result = Rnd.nextInt(100)+1+intModifier;
    	resultDisplay.setText(String.valueOf(result-intModifier)+"+"+String.valueOf(intModifier)+"="+String.valueOf(result));
    }
}