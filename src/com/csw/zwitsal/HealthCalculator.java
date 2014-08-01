package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by MajidRazmjoo on 7/26/14.
 */
public class HealthCalculator extends Activity implements View.OnClickListener{

    Button btnBack,btnCalculate,btnHome;
    EditText edtAge,edtHeight,edtWeight;
    TextView txtResult;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthcalculator);
        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global


        //Component
        btnBack= (Button) findViewById(R.id.btn_BackHealthCalculator);
        btnBack.setOnClickListener(this);
        edtAge= (EditText) findViewById(R.id.edtAge);
        edtHeight= (EditText) findViewById(R.id.edtHeight);
        edtWeight= (EditText) findViewById(R.id.edtWeight);
        txtResult= (TextView) findViewById(R.id.txtResult);
        btnCalculate= (Button) findViewById(R.id.btn_Calculate);
        btnCalculate.setOnClickListener(this);
        btnHome= (Button) findViewById(R.id.btn_Home);
        btnHome.setOnClickListener(this);

        //End

        //Position
        RelativeLayout.LayoutParams btnBackParams= (RelativeLayout.LayoutParams) btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionRel(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        RelativeLayout.LayoutParams edtAgeParams= (RelativeLayout.LayoutParams) edtAge.getLayoutParams();
        edtAgeParams=setGlobal.setTotalPositionRel(edtAgeParams);
        edtAge.setLayoutParams(edtAgeParams);

        RelativeLayout.LayoutParams edtHeightParams= (RelativeLayout.LayoutParams) edtHeight.getLayoutParams();
        edtHeightParams=setGlobal.setTotalPositionRel(edtHeightParams);
        edtHeight.setLayoutParams(edtHeightParams);

        RelativeLayout.LayoutParams edtWeightParams= (RelativeLayout.LayoutParams) edtWeight.getLayoutParams();
        edtWeightParams=setGlobal.setTotalPositionRel(edtWeightParams);
        edtWeight.setLayoutParams(edtWeightParams);

        RelativeLayout.LayoutParams txtResultParams= (RelativeLayout.LayoutParams) txtResult.getLayoutParams();
        txtResultParams=setGlobal.setTotalPositionRel(txtResultParams);
        txtResult.setLayoutParams(txtResultParams);

        RelativeLayout.LayoutParams btnCalculateParams =(RelativeLayout.LayoutParams)btnCalculate.getLayoutParams();
        btnCalculateParams=setGlobal.setTotalPositionRel(btnCalculateParams);
        btnCalculate.setLayoutParams(btnCalculateParams);

        RelativeLayout.LayoutParams btnHomeParams =(RelativeLayout.LayoutParams)btnHome.getLayoutParams();
        btnHomeParams=setGlobal.setTotalPositionRel(btnHomeParams);
        btnHome.setLayoutParams(btnHomeParams);
        //




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_BackHealthCalculator:
                finish();
                break;
            case R.id.btn_Calculate:
                break;
            case R.id.btn_Home:
                Intent loadHome=new Intent(HealthCalculator.this,Home.class);
                startActivity(loadHome);
                break;
        }
    }
}