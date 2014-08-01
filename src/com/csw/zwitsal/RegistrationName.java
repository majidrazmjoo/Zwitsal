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
 * Created by Majid on 7/12/14.
 */
public class RegistrationName extends Activity {
    Button btnOkName;
    EditText editName;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setWindowAnimations(android.R.anim.slide_out_right);
        RegistrationName.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        setContentView(R.layout.registration_name);
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        btnOkName= (Button) findViewById(R.id.btn_OkName);
        editName= (EditText) findViewById(R.id.txtName);

        AbsoluteLayout.LayoutParams btnParams =(AbsoluteLayout.LayoutParams)btnOkName.getLayoutParams();
        btnParams=setGlobal.setTotalPositionAbs(btnParams);
        btnOkName.setLayoutParams(btnParams);

        AbsoluteLayout.LayoutParams edtParams =(AbsoluteLayout.LayoutParams)editName.getLayoutParams();
        edtParams=setGlobal.setTotalPositionAbs(edtParams);
        editName.setLayoutParams(edtParams);


        btnOkName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editName.getText().toString().equals(""))
                {
                    AlertDialog.Builder alertName=new AlertDialog.Builder(RegistrationName.this);
                    alertName.setMessage("Please enter a name.");
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
                    RegistrationFinal.name=editName.getText().toString();
                    Intent registrationDateOfBirth=new Intent(RegistrationName.this,RegistrationDateOfBirth.class);
                    startActivity(registrationDateOfBirth);

                }
            }
        });
    }
}