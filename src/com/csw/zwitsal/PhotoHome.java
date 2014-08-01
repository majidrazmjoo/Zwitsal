package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by MajidRazmjoo on 7/29/14.
 */
public class PhotoHome extends Activity implements View.OnClickListener{
    Button btnBack,btnPhotoUpload,btnPhotoGallery;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_landing);
        //Global Setting
        ApplicationGlobal appSetting= (ApplicationGlobal) getApplicationContext();
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        // End
        //Component
        btnBack= (Button) findViewById(R.id.btn_BackPhotoLanding);
        btnBack.setOnClickListener(this);
        btnPhotoUpload= (Button) findViewById(R.id.btn_PhotoLandingUpload);
        btnPhotoUpload.setOnClickListener(this);
        btnPhotoGallery= (Button) findViewById(R.id.btn_PhotoLandingGallery);
        btnPhotoGallery.setOnClickListener(this);
        //
        RelativeLayout.LayoutParams btnBackParams= (RelativeLayout.LayoutParams) btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionRel(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        RelativeLayout.LayoutParams btnPhotoUploadParams= (RelativeLayout.LayoutParams) btnPhotoUpload.getLayoutParams();
        btnPhotoUploadParams=setGlobal.setTotalPositionRel(btnPhotoUploadParams);
        btnPhotoUpload.setLayoutParams(btnPhotoUploadParams);

        RelativeLayout.LayoutParams btnPhotoGalleryParams= (RelativeLayout.LayoutParams) btnPhotoGallery.getLayoutParams();
        btnPhotoGalleryParams=setGlobal.setTotalPositionRel(btnPhotoGalleryParams);
        btnPhotoGallery.setLayoutParams(btnPhotoGalleryParams);
        //
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_BackPhotoLanding:
                finish();
                break;
            case R.id.btn_PhotoLandingUpload:
                Intent loadPhotoUpload=new Intent(PhotoHome.this,PhotoLoad.class);
                startActivity(loadPhotoUpload);
                break;
            case R.id.btn_PhotoLandingGallery:
                Intent loadPhotoGallery=new Intent(PhotoHome.this,PhotoLoad.class);
                startActivity(loadPhotoGallery);
                break;

        }
    }
}