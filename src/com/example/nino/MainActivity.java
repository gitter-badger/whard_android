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
         * ��ư�� Ŭ�������ʸ� ��Ŭ�������ʸ� �Ǵ�
         * ��Ŭ���Ǹ� ����Ʈ�� �����
         * ���� ��Ƽ��Ƽ, ���� ��Ƽ��Ƽ�� �����ϰ� �Ѿ�� �Ѵ�.
         * 
         */
    }
}