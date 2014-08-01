package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

/**
 * Created by MajidRazmjoo on 7/27/14.
 */
public class HealthTracker extends Activity implements View.OnClickListener{

    Button btnBack,btnChartLakiLaki,btnChartPerempuan,btnHome;
    ImageView imgHeader,imgChart;
    ScrollView scrChart;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_tracker_chart);
        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global
        //
        btnBack= (Button) findViewById(R.id.btn_BackChart);
        btnBack.setOnClickListener(this);
        btnChartLakiLaki= (Button) findViewById(R.id.btn_TrackerLakiLaki);
        btnChartLakiLaki.setOnClickListener(this);
        btnChartPerempuan= (Button) findViewById(R.id.btn_TrackerPerempuan);
        btnChartPerempuan.setOnClickListener(this);
        btnHome= (Button) findViewById(R.id.btn_Home);
        btnHome.setOnClickListener(this);
        imgHeader= (ImageView) findViewById(R.id.img_Tracker_Header);
        imgChart= (ImageView) findViewById(R.id.imageChart);
        scrChart= (ScrollView) findViewById(R.id.scrollTracker);
        //

        //Set Position
        RelativeLayout.LayoutParams btnBackParams =(RelativeLayout.LayoutParams)btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionRel(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        RelativeLayout.LayoutParams btnChartLakiParams =(RelativeLayout.LayoutParams)btnChartLakiLaki.getLayoutParams();
        btnChartLakiParams=setGlobal.setTotalPositionRel(btnChartLakiParams);
        btnChartLakiLaki.setLayoutParams(btnChartLakiParams);

        RelativeLayout.LayoutParams btnChartPerempuanParams =(RelativeLayout.LayoutParams)btnChartPerempuan.getLayoutParams();
        btnChartPerempuanParams=setGlobal.setTotalPositionRel(btnChartPerempuanParams);
        btnChartPerempuan.setLayoutParams(btnChartPerempuanParams);

        RelativeLayout.LayoutParams btnHomeParams =(RelativeLayout.LayoutParams)btnHome.getLayoutParams();
        btnHomeParams=setGlobal.setTotalPositionRel(btnHomeParams);
        btnHome.setLayoutParams(btnHomeParams);

        RelativeLayout.LayoutParams imgHeaderParams =(RelativeLayout.LayoutParams)imgHeader.getLayoutParams();
        imgHeaderParams=setGlobal.setTotalPositionRel(imgHeaderParams);
        imgHeader.setLayoutParams(imgHeaderParams);

        RelativeLayout.LayoutParams scrChartParams =(RelativeLayout.LayoutParams)scrChart.getLayoutParams();
        scrChartParams=setGlobal.setTotalPositionRel(scrChartParams);
        scrChart.setLayoutParams(scrChartParams);
        // End Position

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_BackChart:
                finish();
                break;
            case R.id.btn_TrackerLakiLaki:
                imgHeader.setImageResource(R.drawable.tracker_lakilaki_header);
                imgChart.setImageResource(R.drawable.health_chart_lakilaki);
                break;
            case R.id.btn_TrackerPerempuan:
                imgHeader.setImageResource(R.drawable.tracker_perempuan_header);
                imgChart.setImageResource(R.drawable.health_chart_perempuan);
                break;
            case R.id.btn_Home:
                Intent loadHome=new Intent(HealthTracker.this,Home.class);
                startActivity(loadHome);
                break;

        }

    }
}