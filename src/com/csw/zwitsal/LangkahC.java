package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

/**
 * Created by MajidRazmjoo on 7/24/14.
 */
public class LangkahC extends Activity implements View.OnClickListener {
    Button btnBack;
    Button btnFacebook;
    Button btnTwitter;
    Button btnHome;
    ImageView imageStudy;
    ScrollView scrStudy;
    ImageView imageHeader;
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.langkahc);
        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global

        //
        btnBack= (Button) findViewById(R.id.btn_BackLangkah1_Study);
        btnBack.setOnClickListener(this);
        btnFacebook=(Button) findViewById(R.id.btn_Langkah1_Study_Facebook);
        btnFacebook.setOnClickListener(this);
        btnTwitter=(Button) findViewById(R.id.btn_Langkah1_Study_Twitter);
        btnTwitter.setOnClickListener(this);
        btnHome=(Button) findViewById(R.id.btn_Home);
        btnHome.setOnClickListener(this);
        imageHeader= (ImageView) findViewById(R.id.imageHeader);
        imageStudy= (ImageView) findViewById(R.id.imageStudy);
        scrStudy= (ScrollView) findViewById(R.id.scrollStudy);
        //

        //Set Position
        RelativeLayout.LayoutParams btnBackParams =(RelativeLayout.LayoutParams)btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionRel(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        RelativeLayout.LayoutParams btnFacebookParams =(RelativeLayout.LayoutParams)btnFacebook.getLayoutParams();
        btnFacebookParams=setGlobal.setTotalPositionRel(btnFacebookParams);
        btnFacebook.setLayoutParams(btnFacebookParams);

        RelativeLayout.LayoutParams btnTwitterParams =(RelativeLayout.LayoutParams)btnTwitter.getLayoutParams();
        btnTwitterParams=setGlobal.setTotalPositionRel(btnTwitterParams);
        btnTwitter.setLayoutParams(btnTwitterParams);

        RelativeLayout.LayoutParams btnHomeParams =(RelativeLayout.LayoutParams)btnHome.getLayoutParams();
        btnHomeParams=setGlobal.setTotalPositionRel(btnHomeParams);
        btnHome.setLayoutParams(btnHomeParams);

        RelativeLayout.LayoutParams imgHeaderParams =(RelativeLayout.LayoutParams)imageHeader.getLayoutParams();
        imgHeaderParams=setGlobal.setTotalPositionRel(imgHeaderParams);
        imageHeader.setLayoutParams(imgHeaderParams);

        RelativeLayout.LayoutParams scrStudyParams =(RelativeLayout.LayoutParams)scrStudy.getLayoutParams();
        scrStudyParams=setGlobal.setTotalPositionRel(scrStudyParams);
        scrStudy.setLayoutParams(scrStudyParams);
        // End Position

        // Get image from last activity
        //int imageId=;
        //imageStudy.setImageResource(getIntent().getExtras().getInt("studyImage"));
//        imageHeader.setImageResource(getIntent().getExtras().getInt("langkahImageHeader"));
        Bitmap bm= BitmapFactory.decodeResource(getResources(),getIntent().getExtras().getInt("studyImage"));
        imageStudy.setImageBitmap(bm);
        Bitmap bm2= BitmapFactory.decodeResource(getResources(),getIntent().getExtras().getInt("langkahImageHeader"));
        imageHeader.setImageBitmap(bm2);
        //End get

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_BackLangkah1_Study:
                finish();
                break;
            case R.id.btn_Langkah1_Study_Facebook:
                Intent loadFacebook=new Intent(LangkahC.this,RegistrationEmail.class);
                startActivity(loadFacebook);
                break;
            case R.id.btn_Langkah1_Study_Twitter:
                Intent loadTwitter=new Intent(LangkahC.this,RegistrationEmail.class);
                startActivity(loadTwitter);
                break;
            case R.id.btn_Home:
                Intent loadHome=new Intent(LangkahC.this,Home.class);
                startActivity(loadHome);
                break;
        }
    }

}