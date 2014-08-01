package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;

/**
 * Created by MajidRazmjoo on 7/19/14.
 */
public class Home extends Activity implements View.OnClickListener{
    Button btnBabySpa;
    Button btnHealthTracker;
    Button btnBabyMoments;
    Button btnBabyVideos;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Home.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global

        //initilaze component
        btnBabySpa= (Button) findViewById(R.id.btn_BabySpa);
        btnBabySpa.setOnClickListener(this);
        btnHealthTracker= (Button) findViewById(R.id.btn_HealthTracker);
        btnHealthTracker.setOnClickListener(this);
        btnBabyMoments= (Button) findViewById(R.id.btn_BabyMoments);
        btnBabyMoments.setOnClickListener(this);
        btnBabyVideos= (Button) findViewById(R.id.btn_BabyVideo);
        btnBabyVideos.setOnClickListener(this);
        //End initialize

        //Arrange screen
        AbsoluteLayout.LayoutParams btnSpaParams =(AbsoluteLayout.LayoutParams)btnBabySpa.getLayoutParams();
        btnSpaParams=setGlobal.setTotalPositionAbs(btnSpaParams);
        btnBabySpa.setLayoutParams(btnSpaParams);

        AbsoluteLayout.LayoutParams btnHealthParams =(AbsoluteLayout.LayoutParams)btnHealthTracker.getLayoutParams();
        btnHealthParams=setGlobal.setTotalPositionAbs(btnHealthParams);
        btnHealthTracker.setLayoutParams(btnHealthParams);

        AbsoluteLayout.LayoutParams btnMomentsParams =(AbsoluteLayout.LayoutParams)btnBabyMoments.getLayoutParams();
        btnMomentsParams=setGlobal.setTotalPositionAbs(btnMomentsParams);
        btnBabyMoments.setLayoutParams(btnMomentsParams);

        AbsoluteLayout.LayoutParams btnVideoParams =(AbsoluteLayout.LayoutParams)btnBabyVideos.getLayoutParams();
        btnVideoParams=setGlobal.setTotalPositionAbs(btnVideoParams);
        btnBabyVideos.setLayoutParams(btnVideoParams);
        //End position

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_BabySpa:
                Intent loadBabySpa=new Intent(Home.this,BabySpaHome.class);
                startActivity(loadBabySpa);
                break;
            case R.id.btn_HealthTracker:
                Intent loadHealthHome=new Intent(Home.this,HealthHome.class);
                startActivity(loadHealthHome);
                break;
            case R.id.btn_BabyMoments:
                Intent loadPhotoPage=new Intent(Home.this,PhotoHome.class);
                startActivity(loadPhotoPage);
                break;
            case R.id.btn_BabyVideo:
                break;

        }
    }
}