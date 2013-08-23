package com.example.nino;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
public class Nino_Main extends TabActivity {
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nino_main);
        
        Resources res = getResources();  //리소스 객체 생성
        TabHost tabHost = getTabHost();  //TabHost 객체 생성
        TabHost.TabSpec spec;    //TabHost.TabSpec 선언
        Intent intent;      //Intent 선언
        
        intent = new Intent(this, Nino_List.class);
        spec = tabHost.newTabSpec("tab1")
             .setIndicator("List")
             .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent(this, Nino_Message.class);
        spec = tabHost.newTabSpec("tab2")
             .setIndicator("Message")
             .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent(this, Nino_Location.class);
        spec = tabHost.newTabSpec("tab3")
             .setIndicator("Location")
             .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent(this, Nino_Setting.class);
        spec = tabHost.newTabSpec("tab4")
             .setIndicator("Setting")
             .setContent(intent);
        tabHost.addTab(spec);
        
        tabHost.setCurrentTab(0); //초기 선택 탭 설정
    }
}