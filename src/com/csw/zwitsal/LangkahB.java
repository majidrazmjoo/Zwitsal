package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by MajidRazmjoo on 7/24/14.
 */
public class LangkahB extends Activity implements View.OnClickListener{

    Button btnBack;
    Button btnFacebook;
    Button btnTwitter;
    Button btnEnter;
    Button btnHome;
    int langkahNumber;

    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.langkahb);
        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global

        //
        btnBack= (Button) findViewById(R.id.btn_BackLangkah1_b);
        btnBack.setOnClickListener(this);
        btnEnter=(Button) findViewById(R.id.btn_Langkah1_From);
        btnEnter.setOnClickListener(this);
        btnFacebook=(Button) findViewById(R.id.btn_Langkah1_B_Facebook);
        btnFacebook.setOnClickListener(this);
        btnTwitter=(Button) findViewById(R.id.btn_Langkah1_B_Twitter);
        btnTwitter.setOnClickListener(this);
        btnHome=(Button) findViewById(R.id.btn_Home);
        btnHome.setOnClickListener(this);
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

        RelativeLayout.LayoutParams btnEnterParams =(RelativeLayout.LayoutParams)btnEnter.getLayoutParams();
        btnEnterParams=setGlobal.setTotalPositionRel(btnEnterParams);
        btnEnter.setLayoutParams(btnEnterParams);

        RelativeLayout.LayoutParams btnHomeParams =(RelativeLayout.LayoutParams)btnHome.getLayoutParams();
        btnHomeParams=setGlobal.setTotalPositionRel(btnHomeParams);
        btnHome.setLayoutParams(btnHomeParams);

        // detect Sender
        RelativeLayout langkahB = (RelativeLayout) findViewById(R.id.langkahBLayout);
        int imageLangkahB= getIntent().getExtras().getInt("langkahImage");
        if (Build.VERSION.SDK_INT>=16)
        {
            langkahB.setBackground(getResources().getDrawable(imageLangkahB));
        }
        else
        {
            langkahB.setBackgroundDrawable(getResources().getDrawable(imageLangkahB));
        }
        langkahNumber=getIntent().getExtras().getInt("langkahNumber");
        // End detection

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_BackLangkah1_b:
                finish();
                break;
            case R.id.btn_Langkah1_B_Facebook:
                Intent loadFacebook=new Intent(LangkahB.this,RegistrationEmail.class);
                startActivity(loadFacebook);
                break;
            case R.id.btn_Langkah1_B_Twitter:
                Intent loadTwitter=new Intent(LangkahB.this,RegistrationEmail.class);
                startActivity(loadTwitter);
                break;
            case R.id.btn_Langkah1_From:
                Intent loadLangkahC=null;
                switch(langkahNumber){
                    case 1:
                        loadLangkahC= new Intent(LangkahB.this,Langkah1C.class);
                        break;
                    case 2:
                        loadLangkahC= new Intent(LangkahB.this,LangkahC.class);
                        loadLangkahC.putExtra("studyImage", R.drawable.langkah2_c);
                        loadLangkahC.putExtra("langkahImageHeader", R.drawable.langkah2_c_header);

                        break;
                    case 3:
                        loadLangkahC= new Intent(LangkahB.this,LangkahC.class);
                        loadLangkahC.putExtra("studyImage", R.drawable.langkah3_c);
                        loadLangkahC.putExtra("langkahImageHeader", R.drawable.langkah3_c_header);
                        break;
                    case 4:
                        loadLangkahC= new Intent(LangkahB.this,LangkahC.class);
                        loadLangkahC.putExtra("studyImage", R.drawable.langkah4_c);
                        loadLangkahC.putExtra("langkahImageHeader", R.drawable.langkah4_c_header);
                        break;
                }
                startActivity(loadLangkahC);
                break;

            case R.id.btn_Home:
                Intent loadHome=new Intent(LangkahB.this,Home.class);
                startActivity(loadHome);
                break;
        }
    }

}