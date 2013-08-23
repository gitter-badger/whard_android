package com.example.nino;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class Nino_Setting extends Activity {
	 
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        TextView textView = new TextView(this);
	        textView.setText("Nino_setting");
	        
	        setContentView(textView);
	    }
	}
