package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by MajidRazmjoo on 7/27/14.
 */
public class HealthJadwal extends Activity implements View.OnClickListener {

    Button btnBack,btnHome,btn0,btn1,btn2,btn4,btn5,btn6,btn9,btn12,btn15,btn18,btn24;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_jadwal);
        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global

        // Component
        btnBack= (Button) findViewById(R.id.btn_BackJadwal);
        btnBack.setOnClickListener(this);
        btnHome= (Button) findViewById(R.id.btn_Home);
        btnHome.setOnClickListener(this);
        btn0= (Button) findViewById(R.id.btn_Jadwal0);
        btn0.setOnClickListener(this);
        btn1= (Button) findViewById(R.id.btn_Jadwal1);
        btn1.setOnClickListener(this);
        btn2= (Button) findViewById(R.id.btn_Jadwal2);
        btn2.setOnClickListener(this);
        btn4= (Button) findViewById(R.id.btn_Jadwal4);
        btn4.setOnClickListener(this);
        btn5= (Button) findViewById(R.id.btn_Jadwal5);
        btn5.setOnClickListener(this);
        btn6= (Button) findViewById(R.id.btn_Jadwal6);
        btn6.setOnClickListener(this);
        btn9= (Button) findViewById(R.id.btn_Jadwal9);
        btn9.setOnClickListener(this);
        btn12= (Button) findViewById(R.id.btn_Jadwal12);
        btn12.setOnClickListener(this);
        btn15= (Button) findViewById(R.id.btn_Jadwal15);
        btn15.setOnClickListener(this);
        btn18= (Button) findViewById(R.id.btn_Jadwal18);
        btn18.setOnClickListener(this);
        btn24= (Button) findViewById(R.id.btn_Jadwal24);
        btn24.setOnClickListener(this);
        //

        //Set Position

        RelativeLayout.LayoutParams btnBackParams =(RelativeLayout.LayoutParams)btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionRel(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        RelativeLayout.LayoutParams btnHomeParams =(RelativeLayout.LayoutParams)btnHome.getLayoutParams();
        btnHomeParams=setGlobal.setTotalPositionRel(btnHomeParams);
        btnHome.setLayoutParams(btnHomeParams);

        RelativeLayout.LayoutParams btn0Params= (RelativeLayout.LayoutParams) btn0.getLayoutParams();
        btn0Params=setGlobal.setTotalPositionRel(btn0Params);
        btn0.setLayoutParams(btn0Params);

        RelativeLayout.LayoutParams btn1Params= (RelativeLayout.LayoutParams) btn1.getLayoutParams();
        btn1Params=setGlobal.setTotalPositionRel(btn1Params);
        btn1.setLayoutParams(btn1Params);

        RelativeLayout.LayoutParams btn2Params= (RelativeLayout.LayoutParams) btn2.getLayoutParams();
        btn2Params=setGlobal.setTotalPositionRel(btn2Params);
        btn2.setLayoutParams(btn2Params);

        RelativeLayout.LayoutParams btn4Params= (RelativeLayout.LayoutParams) btn4.getLayoutParams();
        btn4Params=setGlobal.setTotalPositionRel(btn4Params);
        btn4.setLayoutParams(btn4Params);

        RelativeLayout.LayoutParams btn5Params= (RelativeLayout.LayoutParams) btn5.getLayoutParams();
        btn5Params=setGlobal.setTotalPositionRel(btn5Params);
        btn5.setLayoutParams(btn5Params);

        RelativeLayout.LayoutParams btn6Params= (RelativeLayout.LayoutParams) btn6.getLayoutParams();
        btn6Params=setGlobal.setTotalPositionRel(btn6Params);
        btn6.setLayoutParams(btn6Params);

        RelativeLayout.LayoutParams btn9Params= (RelativeLayout.LayoutParams) btn9.getLayoutParams();
        btn9Params=setGlobal.setTotalPositionRel(btn9Params);
        btn9.setLayoutParams(btn9Params);

        RelativeLayout.LayoutParams btn12Params= (RelativeLayout.LayoutParams) btn12.getLayoutParams();
        btn12Params=setGlobal.setTotalPositionRel(btn12Params);
        btn12.setLayoutParams(btn12Params);

        RelativeLayout.LayoutParams btn15Params= (RelativeLayout.LayoutParams) btn15.getLayoutParams();
        btn15Params=setGlobal.setTotalPositionRel(btn15Params);
        btn15.setLayoutParams(btn15Params);

        RelativeLayout.LayoutParams btn18Params= (RelativeLayout.LayoutParams) btn18.getLayoutParams();
        btn18Params=setGlobal.setTotalPositionRel(btn18Params);
        btn18.setLayoutParams(btn18Params);

        RelativeLayout.LayoutParams btn24Params= (RelativeLayout.LayoutParams) btn24.getLayoutParams();
        btn24Params=setGlobal.setTotalPositionRel(btn24Params);
        btn24.setLayoutParams(btn24Params);
    }

    @Override
    public void onClick(View v) {
        Intent loadDetailJadwal=new Intent(HealthJadwal.this,HealthJadwalDetail.class);
        switch(v.getId()){
            case R.id.btn_BackJadwal:
                finish();
                break;
            case R.id.btn_Jadwal0:
                HealthJadwalDetail.imageNumber=0;
                break;
            case R.id.btn_Jadwal1:
                HealthJadwalDetail.imageNumber=1;
                break;
            case R.id.btn_Jadwal2:
                HealthJadwalDetail.imageNumber=2;
                break;
            case R.id.btn_Jadwal4:
                HealthJadwalDetail.imageNumber=3;
                break;
            case R.id.btn_Jadwal5:
                HealthJadwalDetail.imageNumber=4;
                break;
            case R.id.btn_Jadwal6:
                HealthJadwalDetail.imageNumber=5;
                break;
            case R.id.btn_Jadwal9:
                HealthJadwalDetail.imageNumber=6;
                break;
            case R.id.btn_Jadwal12:
                HealthJadwalDetail.imageNumber=7;
                break;
            case R.id.btn_Jadwal15:
                HealthJadwalDetail.imageNumber=8;
                break;
            case R.id.btn_Jadwal18:
                HealthJadwalDetail.imageNumber=9;
                break;
            case R.id.btn_Jadwal24:
                HealthJadwalDetail.imageNumber=10;
                break;
            case R.id.btn_Home:
                Intent loadHome=new Intent(HealthJadwal.this,Home.class);
                startActivity(loadHome);
                break;
        }
        if (v.getId()!=R.id.btn_Home || v.getId()!=R.id.btn_BackJadwal)
        {
            startActivity(loadDetailJadwal);
        }

    }
}