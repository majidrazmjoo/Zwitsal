package com.csw.zwitsal;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.view.View.*;

public class Landing extends Activity implements OnClickListener{
    /**
     * Called when the activity is first created.
     */

    Button btnStart;
    GlobalFunctions setGlobal;
    public static  SharedPreferences zwitsalFisrtRun;
    Boolean firstTimeRun;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreensize();
        setContentView(R.layout.landing);
        Landing.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global

//        if (Build.VERSION.SDK_INT>=14)
//        {
//            setGlobalValue();
//        }
//        else
//        {
//            setGlobalValueOld();
//        }

        btnStart= (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(Landing.this);
        zwitsalFisrtRun=getSharedPreferences("zwitsal",MODE_PRIVATE);
        firstTimeRun= zwitsalFisrtRun.getBoolean("firstRun",true);

        //Set Position
        RelativeLayout.LayoutParams btnStartParams= (RelativeLayout.LayoutParams) btnStart.getLayoutParams();
        btnStartParams=setGlobal.setTotalPositionRel(btnStartParams);
        btnStart.setLayoutParams(btnStartParams);
        //End Position

//
//Ehsan
        //firstTimeRun=true;
//Ehsan


    }
    //Api 14 and above
//    private void setGlobalValue() {
//        Display display = getWindowManager().getDefaultDisplay();
//        Point myScreen=new Point();
//        display.getSize(myScreen);
//        DisplayMetrics realSize=new DisplayMetrics();
//        display.getMetrics(realSize);
//        Toast.makeText(this,realSize.widthPixels+""+" and "+realSize.heightPixels+"",Toast.LENGTH_LONG).show();
//
//        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
//        appSetting.setWidth(myScreen.x);
//        appSetting.setHeight(myScreen.y);
//        setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
//    }

    private void setScreensize(){
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics realSize=new DisplayMetrics();
        display.getMetrics(realSize);
        //Toast.makeText(this,realSize.widthPixels+""+" and "+realSize.heightPixels+"",Toast.LENGTH_LONG).show();
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        appSetting.setWidth(realSize.widthPixels);
        appSetting.setHeight(realSize.heightPixels);
        setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());

    }
//    private void setGlobalValueOld() {
//        int height = getWindowManager().getDefaultDisplay().getHeight();
//        int width = getWindowManager().getDefaultDisplay().getWidth();
////        Display display = getWindowManager().getDefaultDisplay();
////        Point myScreen=new Point();
////        display.getSize(myScreen);
//        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
//        appSetting.setWidth(width);
//        appSetting.setHeight(height);
//        setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
//    }

    @Override
    public void onClick(View v) {

        if (firstTimeRun)
        {
//            SharedPreferences.Editor preEditor=zwitsalFisrtRun.edit();
//            preEditor.putBoolean("firstRun", false);
//            preEditor.commit();

            Intent registrationName = new Intent(Landing.this,RegistrationName.class);
            startActivity(registrationName);
        }
        else
        {
            Intent homeScreen = new Intent(Landing.this,Home.class);
            startActivity(homeScreen);

        }

    }

}
