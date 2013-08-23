package com.example.nino;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Nino2Activity extends Activity 
{
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    this.setContentView(R.layout.nino_2);
	
	    //setting next activity
//	    intent = new Intent(this, .class);
	    
	    Log.i("TagTag", "Nuno2 started");
	    btn = (Button)findViewById(R.id.btn_OK);
	    btn.setOnClickListener(new Button.OnClickListener()
	    {
			@Override
			public void onClick(View arg0) 
			{
				if (!CheckConfirmNumber())
					return;
				if (intent != null)
				{
					startActivity(intent);
					finish();
				}
			}
	    }
	    
	    );
	}

	private boolean CheckConfirmNumber()
	{
		//check the confirm-number in here.
		return true;
	}
	
	private Intent intent = null;
	private Button btn = null;
}
