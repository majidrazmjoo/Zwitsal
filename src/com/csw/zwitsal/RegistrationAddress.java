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
public class RegistrationAddress extends Activity {
    TextView txtTitle;
    EditText edtAddress;
    Button btnOK;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_address);
        RegistrationAddress.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());

        txtTitle= (TextView) findViewById(R.id.txtTitleAddress);
        edtAddress = (EditText) findViewById(R.id.txtAddress);
        btnOK= (Button) findViewById(R.id.btn_OkAddress);


        //Set Position

        AbsoluteLayout.LayoutParams btnParams =(AbsoluteLayout.LayoutParams)btnOK.getLayoutParams();
        btnParams=setGlobal.setTotalPositionAbs(btnParams);
        btnOK.setLayoutParams(btnParams);

        AbsoluteLayout.LayoutParams edtParams =(AbsoluteLayout.LayoutParams) edtAddress.getLayoutParams();
        edtParams=setGlobal.setTotalPositionAbs(edtParams);
        edtAddress.setLayoutParams(edtParams);

        AbsoluteLayout.LayoutParams txtTitleParams =(AbsoluteLayout.LayoutParams)txtTitle.getLayoutParams();
        txtTitleParams=setGlobal.setTotalPositionAbs(txtTitleParams);
        txtTitle.setLayoutParams(txtTitleParams);
        //End position

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtAddress.getText().toString().equals("")) {
                    AlertDialog.Builder alertName = new AlertDialog.Builder(RegistrationAddress.this);
                    alertName.setMessage("Please enter an Address.");
                    alertName.setTitle("Warning...");
                    alertName.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alertName.show();

                } else {
                    RegistrationFinal.address = edtAddress.getText().toString();
                    Intent registrationFinal = new Intent(RegistrationAddress.this, RegistrationFinal.class);
                    startActivity(registrationFinal);

                }
            }
        });

    }
}