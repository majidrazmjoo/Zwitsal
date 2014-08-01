package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by MajidRazmjoo on 7/23/14.
 */
public class LangkahA extends Activity implements View.OnClickListener {
    Button btnBack;
    Button btnEnter;
    Button btnHome;
    int langkahNumber;

    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.langkaha);
        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global
        //
        btnBack= (Button) findViewById(R.id.btn_BackLangkah1_a);
        btnBack.setOnClickListener(this);
        btnEnter=(Button) findViewById(R.id.btn_Langkah1_Enter);
        btnEnter.setOnClickListener(this);
        btnHome=(Button) findViewById(R.id.btn_Home);
        btnHome.setOnClickListener(this);

        //

        //Set Position

        RelativeLayout.LayoutParams btnBackParams =(RelativeLayout.LayoutParams)btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionRel(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        RelativeLayout.LayoutParams btnEnterParams =(RelativeLayout.LayoutParams)btnEnter.getLayoutParams();
        btnEnterParams=setGlobal.setTotalPositionRel(btnEnterParams);
        btnEnter.setLayoutParams(btnEnterParams);

        RelativeLayout.LayoutParams btnHomeParams =(RelativeLayout.LayoutParams)btnHome.getLayoutParams();
        btnHomeParams=setGlobal.setTotalPositionRel(btnHomeParams);
        btnHome.setLayoutParams(btnHomeParams);
        // End position

        // detect Sender
        RelativeLayout langkahA = (RelativeLayout) findViewById(R.id.langkahALayout);
        int imageLangkahA= getIntent().getExtras().getInt("langkahImage");
        if (Build.VERSION.SDK_INT>=16)
        {
            langkahA.setBackground(getResources().getDrawable(imageLangkahA));
        }
        else
        {
            langkahA.setBackgroundDrawable(getResources().getDrawable(imageLangkahA));
        }
        langkahNumber=getIntent().getExtras().getInt("langkahNumber");
        // End detection

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_BackLangkah1_a:
                finish();
                break;
            case R.id.btn_Langkah1_Enter:
                Intent loadLangkahB=new Intent(LangkahA.this,LangkahB.class);
                switch(langkahNumber){
                    case 1:
                        loadLangkahB.putExtra("langkahImage",R.drawable.langkah1_b);
                        loadLangkahB.putExtra("langkahNumber",1);
                        break;
                    case 2:
                        loadLangkahB.putExtra("langkahImage",R.drawable.langkah2_b);
                        loadLangkahB.putExtra("langkahNumber",2);
                        break;
                    case 3:
                        loadLangkahB.putExtra("langkahImage",R.drawable.langkah3_b);
                        loadLangkahB.putExtra("langkahNumber",3);
                        break;
                    case 4:
                        loadLangkahB.putExtra("langkahImage",R.drawable.langkah4_b);
                        loadLangkahB.putExtra("langkahNumber",4);
                        break;
                }
                startActivity(loadLangkahB);
                break;
            case R.id.btn_Home:
                Intent loadHome=new Intent(LangkahA.this,Home.class);
                startActivity(loadHome);
                break;
        }
    }

}