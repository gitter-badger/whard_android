package com.example.nino;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class MainActivity extends TabActivity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
//      TabHost tabHost = getTabHost();        

        Intent intent = new Intent(this, Logo.class);        
        
        startActivity(intent);
		finish();
        
        /*
         * 버튼에 클릭리스너를 온클릭리스너를 건다
         * 온클릭되면 인텐트를 만든다
         * 지금 액티비티, 다음 액티비티를 지정하고 넘어가게 한다.
         * 
         */
    }
}