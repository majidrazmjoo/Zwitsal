package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by MajidRazmjoo on 7/26/14.
 */
public class HealthHome extends Activity implements View.OnClickListener {

    Button btnBack;
    Button btnHealthCalculator;
    Button btnHealthTracker;
    Button btnJadwal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthtracker_home);
        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global
        //
        btnBack= (Button) findViewById(R.id.btn_BackHealthTracker);
        btnBack.setOnClickListener(this);
        btnHealthCalculator =(Button) findViewById(R.id.btn_HealthCalculator);
        btnHealthCalculator.setOnClickListener(this);
        btnHealthTracker =(Button) findViewById(R.id.btn_HealthTrackerChart);
        btnHealthTracker.setOnClickListener(this);
        btnJadwal =(Button) findViewById(R.id.btn_JadwalImunisasi);
        btnJadwal.setOnClickListener(this);
        //

        //Set Position

        RelativeLayout.LayoutParams btnBackParams =(RelativeLayout.LayoutParams)btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionRel(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        RelativeLayout.LayoutParams btnHealthCalculatorParams =(RelativeLayout.LayoutParams) btnHealthCalculator.getLayoutParams();
        btnHealthCalculatorParams=setGlobal.setTotalPositionRel(btnHealthCalculatorParams);
        btnHealthCalculator.setLayoutParams(btnHealthCalculatorParams);

        RelativeLayout.LayoutParams btnHealthTrackerParams =(RelativeLayout.LayoutParams) btnHealthTracker.getLayoutParams();
        btnHealthTrackerParams=setGlobal.setTotalPositionRel(btnHealthTrackerParams);
        btnHealthTracker.setLayoutParams(btnHealthTrackerParams);

        RelativeLayout.LayoutParams btnJadwalParams =(RelativeLayout.LayoutParams) btnJadwal.getLayoutParams();
        btnJadwalParams=setGlobal.setTotalPositionRel(btnJadwalParams);
        btnJadwal.setLayoutParams(btnJadwalParams);

       //End

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btn_BackHealthTracker:
                finish();
                break;
            case R.id.btn_HealthCalculator:
                Intent loadHealthCalculator=new Intent(HealthHome.this,HealthCalculator.class);
                startActivity(loadHealthCalculator);
                break;
            case R.id.btn_HealthTrackerChart:
                Intent loadTrackerChart=new Intent(HealthHome.this,HealthTracker.class);
                startActivity(loadTrackerChart);
                break;
            case R.id.btn_JadwalImunisasi:
                Intent loadJadwalImu=new Intent(HealthHome.this,HealthJadwal.class);
                startActivity(loadJadwalImu);
                break;

        }
    }

}