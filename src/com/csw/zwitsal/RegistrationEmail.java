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
import android.widget.TextView;

/**
 * Created by MajidRazmjoo on 7/18/14.
 */
public class RegistrationEmail extends Activity {
    Button btnOkEmail;
    EditText editEmail;
    TextView txtTitleEmail;
    GlobalFunctions setGlobal;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_email);
        RegistrationEmail.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        btnOkEmail= (Button) findViewById(R.id.btn_OkEmail);
        editEmail= (EditText) findViewById(R.id.txtEmail);
        txtTitleEmail= (TextView) findViewById(R.id.txtTitleEmail);

        //Set Position

        AbsoluteLayout.LayoutParams btnParams =(AbsoluteLayout.LayoutParams)btnOkEmail.getLayoutParams();
        btnParams=setGlobal.setTotalPositionAbs(btnParams);
        btnOkEmail.setLayoutParams(btnParams);

        AbsoluteLayout.LayoutParams edtParams =(AbsoluteLayout.LayoutParams)editEmail.getLayoutParams();
        edtParams=setGlobal.setTotalPositionAbs(edtParams);
        editEmail.setLayoutParams(edtParams);

        AbsoluteLayout.LayoutParams txtTitleParams =(AbsoluteLayout.LayoutParams)txtTitleEmail.getLayoutParams();
        txtTitleParams=setGlobal.setTotalPositionAbs(txtTitleParams);
        txtTitleEmail.setLayoutParams(txtTitleParams);
        //End position

        btnOkEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editEmail.getText().toString().equals("")) {
                    AlertDialog.Builder alertName = new AlertDialog.Builder(RegistrationEmail.this);
                    alertName.setMessage("Please enter an email.");
                    alertName.setTitle("Warning...");
                    alertName.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alertName.show();

                } else if (setGlobal.isValidEmail(editEmail.getText().toString())){

                    RegistrationFinal.email = editEmail.getText().toString();
                    Intent registrationPhone = new Intent(RegistrationEmail.this, RegistrationPhone.class);
                    startActivity(registrationPhone);

                } else{
                    AlertDialog.Builder alertName = new AlertDialog.Builder(RegistrationEmail.this);
                    alertName.setMessage("Email address is not valid.");
                    alertName.setTitle("Warning...");
                    alertName.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alertName.show();

                }

            }
        });



    }
}