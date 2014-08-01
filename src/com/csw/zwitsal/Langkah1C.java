package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by MajidRazmjoo on 7/24/14.
 */
public class Langkah1C extends Activity implements View.OnClickListener{
    Button btnBack;
    Button btnPijatWajah;
    Button btnPijatDada;
    Button btnPijatLengan;
    Button btnPijatKaki;
    Button btnPijatPunggung;
    Button btnHome;

    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.langkah1_c);
        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global

        //
        btnBack= (Button) findViewById(R.id.btn_BackLangkah1_c);
        btnBack.setOnClickListener(this);
        btnPijatWajah=(Button) findViewById(R.id.btn_PijatWajah);
        btnPijatWajah.setOnClickListener(this);
        btnPijatDada=(Button) findViewById(R.id.btn_PijatDada);
        btnPijatDada.setOnClickListener(this);
        btnPijatLengan=(Button) findViewById(R.id.btn_PijatLengan);
        btnPijatLengan.setOnClickListener(this);
        btnPijatKaki=(Button) findViewById(R.id.btn_PijatKaki);
        btnPijatKaki.setOnClickListener(this);
        btnPijatPunggung=(Button) findViewById(R.id.btn_PijatPunggung);
        btnPijatPunggung.setOnClickListener(this);
        btnHome=(Button) findViewById(R.id.btn_Home);
        btnHome.setOnClickListener(this);
        //

        //Set Position
        RelativeLayout.LayoutParams btnBackParams =(RelativeLayout.LayoutParams)btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionRel(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        RelativeLayout.LayoutParams btnPijatWajahParams =(RelativeLayout.LayoutParams)btnPijatWajah.getLayoutParams();
        btnPijatWajahParams=setGlobal.setTotalPositionRel(btnPijatWajahParams);
        btnPijatWajah.setLayoutParams(btnPijatWajahParams);

        RelativeLayout.LayoutParams btnPijatDadaParams =(RelativeLayout.LayoutParams)btnPijatDada.getLayoutParams();
        btnPijatDadaParams=setGlobal.setTotalPositionRel(btnPijatDadaParams);
        btnPijatDada.setLayoutParams(btnPijatDadaParams);

        RelativeLayout.LayoutParams btnPijatLenganParams =(RelativeLayout.LayoutParams)btnPijatLengan.getLayoutParams();
        btnPijatLenganParams=setGlobal.setTotalPositionRel(btnPijatLenganParams);
        btnPijatLengan.setLayoutParams(btnPijatLenganParams);

        RelativeLayout.LayoutParams btnPijatKakiParams =(RelativeLayout.LayoutParams)btnPijatKaki.getLayoutParams();
        btnPijatKakiParams=setGlobal.setTotalPositionRel(btnPijatKakiParams);
        btnPijatKaki.setLayoutParams(btnPijatKakiParams);

        RelativeLayout.LayoutParams btnPijatPunggungParams =(RelativeLayout.LayoutParams)btnPijatPunggung.getLayoutParams();
        btnPijatPunggungParams=setGlobal.setTotalPositionRel(btnPijatPunggungParams);
        btnPijatPunggung.setLayoutParams(btnPijatPunggungParams);

        RelativeLayout.LayoutParams btnHomeParams =(RelativeLayout.LayoutParams)btnHome.getLayoutParams();
        btnHomeParams=setGlobal.setTotalPositionRel(btnHomeParams);
        btnHome.setLayoutParams(btnHomeParams);

    }

    @Override
    public void onClick(View v) {
        Intent loadLangkan1=new Intent(Langkah1C.this,LangkahC.class);
        switch(v.getId()){
            case R.id.btn_BackLangkah1_c:
                finish();
                break;
            case R.id.btn_PijatWajah:
                loadLangkan1.putExtra("langkahImageHeader", R.drawable.langkah1_pijatwajah_header);
                loadLangkan1.putExtra("studyImage",R.drawable.langkah1_pijatdada);
                startActivity(loadLangkan1);
                break;
            case R.id.btn_PijatDada:
                loadLangkan1.putExtra("langkahImageHeader", R.drawable.langkah1_pijatdada_header);
                loadLangkan1.putExtra("studyImage",R.drawable.langkah1_pijatdada);
                startActivity(loadLangkan1);
                break;
            case R.id.btn_PijatLengan:
                loadLangkan1.putExtra("langkahImageHeader", R.drawable.langkah1_pijatlengan_header);
                loadLangkan1.putExtra("studyImage",R.drawable.langkah1_pijatlengan);
                startActivity(loadLangkan1);
                break;
            case R.id.btn_PijatKaki:
                loadLangkan1.putExtra("langkahImageHeader", R.drawable.langkah1_pijatkaki_headr);
                loadLangkan1.putExtra("studyImage",R.drawable.langkah1_pijatkaki);
                startActivity(loadLangkan1);
                break;
            case R.id.btn_PijatPunggung:
                loadLangkan1.putExtra("langkahImageHeader", R.drawable.langkah1_pijatpunggung_header);
                loadLangkan1.putExtra("studyImage",R.drawable.langkah1_pijatpunggung);
                startActivity(loadLangkan1);
                break;
            case R.id.btn_Home:
                Intent loadHome=new Intent(Langkah1C.this,Home.class);
                startActivity(loadHome);
                break;
        }
    }

}