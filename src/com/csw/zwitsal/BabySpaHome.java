package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by MajidRazmjoo on 7/23/14.
 */
public class BabySpaHome extends Activity implements View.OnClickListener {
    Button btnBack;
    Button btnLengkah1;
    Button btnLengkah2;
    Button btnLengkah3;
    Button btnLengkah4;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baby_spa_home);
        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global
        //
        btnBack= (Button) findViewById(R.id.btn_BackBabySpaHome);
        btnBack.setOnClickListener(this);
        btnLengkah1=(Button) findViewById(R.id.btn_Langkah1);
        btnLengkah1.setOnClickListener(this);
        btnLengkah2=(Button) findViewById(R.id.btn_Langkah2);
        btnLengkah2.setOnClickListener(this);
        btnLengkah3=(Button) findViewById(R.id.btn_Langkah3);
        btnLengkah3.setOnClickListener(this);
        btnLengkah4=(Button) findViewById(R.id.btn_Langkah4);
        btnLengkah4.setOnClickListener(this);
        //

        //Set Position

        RelativeLayout.LayoutParams btnBackParams =(RelativeLayout.LayoutParams)btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionRel(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        RelativeLayout.LayoutParams btnLengkah1Params =(RelativeLayout.LayoutParams)btnLengkah1.getLayoutParams();
        btnLengkah1Params=setGlobal.setTotalPositionRel(btnLengkah1Params);
        btnLengkah1.setLayoutParams(btnLengkah1Params);

        RelativeLayout.LayoutParams btnLengkah2Params =(RelativeLayout.LayoutParams)btnLengkah2.getLayoutParams();
        btnLengkah2Params=setGlobal.setTotalPositionRel(btnLengkah2Params);
        btnLengkah2.setLayoutParams(btnLengkah2Params);

        RelativeLayout.LayoutParams btnLengkah3Params =(RelativeLayout.LayoutParams)btnLengkah3.getLayoutParams();
        btnLengkah3Params=setGlobal.setTotalPositionRel(btnLengkah3Params);
        btnLengkah3.setLayoutParams(btnLengkah3Params);

        RelativeLayout.LayoutParams btnLengkah4Params =(RelativeLayout.LayoutParams)btnLengkah4.getLayoutParams();
        btnLengkah4Params=setGlobal.setTotalPositionRel(btnLengkah4Params);
        btnLengkah4.setLayoutParams(btnLengkah4Params);

    }

    @Override
    public void onClick(View v) {
        Intent loadLangkahA=new Intent(BabySpaHome.this,LangkahA.class);
        switch(v.getId()){
        case R.id.btn_BackBabySpaHome:
            finish();
            break;
        case R.id.btn_Langkah1:
            loadLangkahA.putExtra("langkahImage",R.drawable.langkah1_a);
            loadLangkahA.putExtra("langkahNumber",1);
            break;
        case R.id.btn_Langkah2:
            loadLangkahA.putExtra("langkahImage", R.drawable.langkah2_a);
            loadLangkahA.putExtra("langkahNumber",2);
            break;
        case R.id.btn_Langkah3:
            loadLangkahA.putExtra("langkahImage", R.drawable.langkah3_a);
            loadLangkahA.putExtra("langkahNumber",3);
            break;
        case R.id.btn_Langkah4:
            loadLangkahA.putExtra("langkahImage", R.drawable.langkah4_a);
            loadLangkahA.putExtra("langkahNumber",4);
            break;
        }
        if (v.getId()!=R.id.btn_BackBabySpaHome){
            startActivity(loadLangkahA);
        }

    }

}