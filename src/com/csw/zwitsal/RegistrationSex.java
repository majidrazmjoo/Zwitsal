package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MajidRazmjoo on 7/17/14.
 */
public class RegistrationSex extends Activity {

    TextView txtTitleSex;
    Button btnOkSex;
    Spinner spnSex;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_sex);
        RegistrationSex.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global

        //initilaze component
        btnOkSex= (Button) findViewById(R.id.btn_OkSex);
        spnSex= (Spinner) findViewById(R.id.spinnerSex);
        txtTitleSex= (TextView) findViewById(R.id.txtTitleSex);
        //End initalaize

        //Set objects Position
        //Arrange screen
        AbsoluteLayout.LayoutParams spinnerSexParams =(AbsoluteLayout.LayoutParams)spnSex.getLayoutParams();
        spinnerSexParams=setGlobal.setTotalPositionAbs(spinnerSexParams);
        spnSex.setLayoutParams(spinnerSexParams);

        AbsoluteLayout.LayoutParams txtTitleParams =(AbsoluteLayout.LayoutParams)txtTitleSex.getLayoutParams();
        txtTitleParams=setGlobal.setTotalPositionAbs(txtTitleParams);
        txtTitleSex.setLayoutParams(txtTitleParams);

        AbsoluteLayout.LayoutParams btnOkParams =(AbsoluteLayout.LayoutParams)btnOkSex.getLayoutParams();
        btnOkParams=setGlobal.setTotalPositionAbs(btnOkParams);
        btnOkSex.setLayoutParams(btnOkParams);
        //End position

        //Fill Spinner
        List<String> spinnerArray=new ArrayList<String>();
        spinnerArray.add("Lelaki");
        spinnerArray.add("Perempuan");
        ArrayAdapter<String> sAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spinnerArray);
        sAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSex.setAdapter(sAdapter);
        //End Filling

        btnOkSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrationFinal.sex=spnSex.getSelectedItem().toString();
                Intent registrationMotherName=new Intent(RegistrationSex.this,RegistrationMotherName.class);
                startActivity(registrationMotherName);

            }
        });
    }
}