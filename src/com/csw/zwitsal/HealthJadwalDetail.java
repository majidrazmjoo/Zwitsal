package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Created by MajidRazmjoo on 7/28/14.
 */
public class HealthJadwalDetail extends Activity implements View.OnClickListener {
    Button btnBack,btnBackJadwal,btnForwardJadwal,btnHome;
    ImageView imgHeader,imgJadwal;
    ScrollView scrJadwal;
    public static int imageNumber;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_jadwal_detail);
        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global
        //
        btnBack= (Button) findViewById(R.id.btn_BackJadwal);
        btnBack.setOnClickListener(this);
        btnBackJadwal= (Button) findViewById(R.id.btn_JadwalHeaderBack);
        btnBackJadwal.setOnClickListener(this);
        btnForwardJadwal= (Button) findViewById(R.id.btn_JadwalHeaderForward);
        btnForwardJadwal.setOnClickListener(this);
        btnHome= (Button) findViewById(R.id.btn_Home);
        btnHome.setOnClickListener(this);
        imgHeader= (ImageView) findViewById(R.id.img_HeaderJadwal);
        imgJadwal= (ImageView) findViewById(R.id.imageJadwalDetail);
        scrJadwal= (ScrollView) findViewById(R.id.scrollJadwal);

        //
        //Set Position
        RelativeLayout.LayoutParams btnBackParams =(RelativeLayout.LayoutParams)btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionRel(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        RelativeLayout.LayoutParams btnBackJadwalParams =(RelativeLayout.LayoutParams)btnBackJadwal.getLayoutParams();
        btnBackJadwalParams=setGlobal.setTotalPositionRel(btnBackJadwalParams);
        btnBackJadwal.setLayoutParams(btnBackJadwalParams);

        RelativeLayout.LayoutParams btnForwardJadwalParams =(RelativeLayout.LayoutParams)btnForwardJadwal.getLayoutParams();
        btnForwardJadwalParams=setGlobal.setTotalPositionRel(btnForwardJadwalParams);
        btnForwardJadwal.setLayoutParams(btnForwardJadwalParams);

        RelativeLayout.LayoutParams btnHomeParams =(RelativeLayout.LayoutParams)btnHome.getLayoutParams();
        btnHomeParams=setGlobal.setTotalPositionRel(btnHomeParams);
        btnHome.setLayoutParams(btnHomeParams);

        RelativeLayout.LayoutParams imgHeaderParams =(RelativeLayout.LayoutParams)imgHeader.getLayoutParams();
        imgHeaderParams=setGlobal.setTotalPositionRel(imgHeaderParams);
        imgHeader.setLayoutParams(imgHeaderParams);

        RelativeLayout.LayoutParams srcJadwalParams =(RelativeLayout.LayoutParams)scrJadwal.getLayoutParams();
        srcJadwalParams=setGlobal.setTotalPositionRel(srcJadwalParams);
        scrJadwal.setLayoutParams(srcJadwalParams);
        // End Position

        // set initial images
        imgHeader.setImageResource(getResourseId("jadwal_header"+imageNumber,getPackageName()));
        imgJadwal.setImageResource(getResourseId("detail_jadwal"+imageNumber,getPackageName()));
        //

    }

    private int getResourseId(String pVariableName, String pPackageName)
    {
        try {
            return getResources().getIdentifier(pVariableName, "drawable", pPackageName);
        } catch (Exception e) {
           // e.printStackTrace();
            return -1;
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_BackJadwal:
                finish();
                break;
            case R.id.btn_JadwalHeaderBack:

               if (imageNumber!=0){
                   imageNumber--;
                    imgHeader.setImageResource(getResourseId("jadwal_header"+imageNumber,getPackageName()));
                    imgJadwal.setImageResource(getResourseId("detail_jadwal"+imageNumber,getPackageName()));
                }
                break;
            case R.id.btn_JadwalHeaderForward:
                if (imageNumber!=10){
                    imageNumber++;
                    imgHeader.setImageResource(getResourseId("jadwal_header"+imageNumber,getPackageName()));
                    imgJadwal.setImageResource(getResourseId("detail_jadwal"+imageNumber,getPackageName()));
                }
                break;
            case R.id.btn_Home:
                Intent loadHome=new Intent(HealthJadwalDetail.this,Home.class);
                startActivity(loadHome);
                break;
        }
    }
}