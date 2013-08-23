package com.example.nino;

import android.app.Activity; 
import android.os.Bundle;
import android.widget.TextView;
public class Nino_Location extends Activity {
 
 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView textView = new TextView(this);
        textView.setText("Nino_location");
        
        setContentView(textView);
    }
 
}