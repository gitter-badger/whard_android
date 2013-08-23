package com.example.nino;

import hsb.ImageManager;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

public class Logo extends Activity 
{
	private Bitmap mBG = null;
	private float mTimer = 0.f;
	private float mMaxtime = 3.f;
	
	public void Load() throws OutOfMemoryError, Exception
	{
		if (mBG == null)
		{
//			String uriPath = "android.resource://"+getPackageName()+"/drawable/myvideo";
//			getResources().getDrawable(R.drawable.bonus).get
			mBG = ImageManager.LoadBackgroundBitmap(this, R.drawable.bonus);			
			if (mBG != null)
				Log.i("TagTag", "이미지 로드됬다ㅋㅋㅋ");
		}
		
		if (intent == null)
		{
			intent = new Intent(this, Nino1Activity.class);
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    this.setContentView(R.layout.logo);
	    
		try {
			Load();
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if ( mBG != null )
		{
			ImageView iv = (ImageView) findViewById(R.id.imageView1);
			iv.setImageBitmap( mBG );
		}
		
		Handler mHandler = new Handler();
		Runnable codeToRun = new Runnable() {
		    @Override
		    public void run() 
		    {
		    	if (intent != null)
		    		startActivity(intent);
		    }
		};
		
		mHandler.postDelayed(codeToRun, 1500);
	}
	
	private Intent intent = null;
}
