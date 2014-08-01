package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Created by Majid on 7/12/14.
 */
public class RegistrationDateOfBirth extends Activity {


    Spinner spnDay;
    Spinner spnMonth;
    Spinner spnYear;
    TextView txtTitle,txtDay,txtMonth,txtYear;
    Button btnOK;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_dob);
        RegistrationDateOfBirth.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        // initliaze objects
        spnDay= (Spinner) findViewById(R.id.spinnerDay);
        spnMonth= (Spinner) findViewById(R.id.spinnerMonth);
        spnYear= (Spinner) findViewById(R.id.spinnerYear);

        txtTitle= (TextView) findViewById(R.id.txtTitleDate);
        txtDay= (TextView) findViewById(R.id.textTarikh);
        txtMonth= (TextView) findViewById(R.id.textBulan);
        txtYear= (TextView) findViewById(R.id.textTahun);

        btnOK=(Button)findViewById(R.id.btn_OkDate);

        // End of initilating

        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());

        //Arrange screen
        AbsoluteLayout.LayoutParams spinnerDayParams =(AbsoluteLayout.LayoutParams)spnDay.getLayoutParams();
        spinnerDayParams=setGlobal.setTotalPositionAbs(spinnerDayParams);
        spnDay.setLayoutParams(spinnerDayParams);

        AbsoluteLayout.LayoutParams spinnerMonthParams =(AbsoluteLayout.LayoutParams)spnMonth.getLayoutParams();
        spinnerMonthParams=setGlobal.setTotalPositionAbs(spinnerMonthParams);
        spnMonth.setLayoutParams(spinnerMonthParams);

        AbsoluteLayout.LayoutParams spinnerYearParams =(AbsoluteLayout.LayoutParams)spnYear.getLayoutParams();
        spinnerYearParams=setGlobal.setTotalPositionAbs(spinnerYearParams);
        spnYear.setLayoutParams(spinnerYearParams);

        AbsoluteLayout.LayoutParams btnOkParams =(AbsoluteLayout.LayoutParams)btnOK.getLayoutParams();
        btnOkParams=setGlobal.setTotalPositionAbs(btnOkParams);
        btnOK.setLayoutParams(btnOkParams);


        AbsoluteLayout.LayoutParams txtTitleParams =(AbsoluteLayout.LayoutParams)txtTitle.getLayoutParams();
        txtTitleParams=setGlobal.setTotalPositionAbs(txtTitleParams);
        txtTitle.setLayoutParams(txtTitleParams);

        AbsoluteLayout.LayoutParams txtTarikhParams =(AbsoluteLayout.LayoutParams)txtDay.getLayoutParams();
        txtTarikhParams=setGlobal.setTotalPositionAbs(txtTarikhParams);
        txtDay.setLayoutParams(txtTarikhParams);


        AbsoluteLayout.LayoutParams txtMonthParams =(AbsoluteLayout.LayoutParams)txtMonth.getLayoutParams();
        txtMonthParams=setGlobal.setTotalPositionAbs(txtMonthParams);
        txtMonth.setLayoutParams(txtMonthParams);

        AbsoluteLayout.LayoutParams txtYearParams =(AbsoluteLayout.LayoutParams)txtYear.getLayoutParams();
        txtYearParams=setGlobal.setTotalPositionAbs(txtYearParams);
        txtYear.setLayoutParams(txtYearParams);


        //End of arrange scrren
        //Fill Spinners
        spnDay.setAdapter(setGlobal.fillSpinner(1, 31,this));
        spnMonth.setAdapter(setGlobal.fillSpinner(1,12,this));
        spnYear.setAdapter(setGlobal.fillSpinner(2010, 2020,this));
        //End of filling

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//               String txtDateOfBirth= spnDay.getSelectedItem().toString()+"/"+spnMonth.getSelectedItem().toString()+
//                                        "/"+spnYear.getSelectedItem().toString();
                RegistrationFinal.dobDay=spnDay.getSelectedItem().toString();
                RegistrationFinal.dobMonth=spnMonth.getSelectedItem().toString();
                RegistrationFinal.dobYear=spnYear.getSelectedItem().toString();
                //RegistrationFinal.dateOfBirth=txtDateOfBirth;
                //Toast.makeText(RegistrationDateOfBirth.this,txtDateOfBirth,2000).show();
                Intent registrationSex=new Intent(RegistrationDateOfBirth.this,RegistrationSex.class);
                startActivity(registrationSex);


            }
        });


    }


}
