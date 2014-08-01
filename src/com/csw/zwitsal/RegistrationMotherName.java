package com.csw.zwitsal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by MajidRazmjoo on 7/18/14.
 */
public class RegistrationMotherName extends Activity {

    Button btnOkName;
    EditText editName;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_mother_name);
        RegistrationMotherName.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        btnOkName= (Button) findViewById(R.id.btn_OkMotherName);
        editName= (EditText) findViewById(R.id.txtMotherName);


        //Set Position

        AbsoluteLayout.LayoutParams btnParams =(AbsoluteLayout.LayoutParams)btnOkName.getLayoutParams();
        btnParams=setGlobal.setTotalPositionAbs(btnParams);
        btnOkName.setLayoutParams(btnParams);

        AbsoluteLayout.LayoutParams edtParams =(AbsoluteLayout.LayoutParams)editName.getLayoutParams();
        edtParams=setGlobal.setTotalPositionAbs(edtParams);
        editName.setLayoutParams(edtParams);
        //End position

        btnOkName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editName.getText().toString().equals(""))
                {
                    AlertDialog.Builder alertName=new AlertDialog.Builder(RegistrationMotherName.this);
                    alertName.setMessage("Please enter a mother name.");
                    alertName.setTitle("Warning...");
                    alertName.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alertName.show();

                }
                else
                {
                    RegistrationFinal.motherName=editName.getText().toString();
                    Intent registrationEmail=new Intent(RegistrationMotherName.this,RegistrationEmail.class);
                    startActivity(registrationEmail);

                }

            }
        });
    }
}