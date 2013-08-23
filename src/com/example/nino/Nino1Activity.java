package com.example.nino;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Nino1Activity extends Activity 
{
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);	
	    this.setContentView(R.layout.nino_1);
	    
	    //
	    
	    //
	    
	    intent = new Intent(this, Nino2Activity.class);
	    btn = (Button)findViewById(R.id.btn_confirmation);
	    btn.setOnClickListener(new Button.OnClickListener()
	    {
			@Override
			public void onClick(View arg0) 
			{
				if (intent != null)
				{
					startActivity(intent);
					finish();
				}
			}
	    }
	    
	    );
	}
		
	private Intent intent = null;
	private Button btn = null;
}
