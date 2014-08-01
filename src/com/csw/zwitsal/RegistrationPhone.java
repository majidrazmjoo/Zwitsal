package com.csw.zwitsal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by MajidRazmjoo on 7/18/14.
 */
public class RegistrationPhone extends Activity {
    TextView txtTitle;
    EditText edtPhone;
    Button btnOK;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_phone);
        RegistrationPhone.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());

        txtTitle= (TextView) findViewById(R.id.txtTitlePhone);
        edtPhone= (EditText) findViewById(R.id.txtPhone);
        btnOK= (Button) findViewById(R.id.btn_OkPhone);


        //Set Position

        AbsoluteLayout.LayoutParams btnParams =(AbsoluteLayout.LayoutParams)btnOK.getLayoutParams();
        btnParams=setGlobal.setTotalPositionAbs(btnParams);
        btnOK.setLayoutParams(btnParams);

        AbsoluteLayout.LayoutParams edtParams =(AbsoluteLayout.LayoutParams)edtPhone.getLayoutParams();
        edtParams=setGlobal.setTotalPositionAbs(edtParams);
        edtPhone.setLayoutParams(edtParams);

        AbsoluteLayout.LayoutParams txtTitleParams =(AbsoluteLayout.LayoutParams)txtTitle.getLayoutParams();
        txtTitleParams=setGlobal.setTotalPositionAbs(txtTitleParams);
        txtTitle.setLayoutParams(txtTitleParams);
        //End position

        try
        {
            TelephonyManager tMgr =(TelephonyManager)this.getSystemService(this.TELEPHONY_SERVICE);
            String mPhoneNumber = tMgr.getLine1Number();
            edtPhone.setText(mPhoneNumber);

        }
        catch (Exception ex)
        {

        }

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtPhone.getText().toString().equals("")) {
                    AlertDialog.Builder alertName = new AlertDialog.Builder(RegistrationPhone.this);
                    alertName.setMessage("Please enter a valid phone number.");
                    alertName.setTitle("Warning...");
                    alertName.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alertName.show();

                } else {
                    RegistrationFinal.phoneNumber = edtPhone.getText().toString();
                    Intent registrationAddress = new Intent(RegistrationPhone.this, RegistrationAddress.class);
                    startActivity(registrationAddress);

                }
            }
        });



    }
}