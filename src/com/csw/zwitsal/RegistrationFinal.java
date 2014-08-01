package com.csw.zwitsal;

import android.app.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.*;

/**
 * Created by Majid on 7/12/14.
 */
public class RegistrationFinal extends Activity {
    public static String name,dobDay,dobMonth,dobYear,sex,motherName,email,phoneNumber,address;
//    public static String dateOfBirth;


    Button btnBack,btnOk;
    EditText edtName,edtDOB,edtSex,edtMotherName,edtEmail,edtPhone,edtAddress;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_final);
        RegistrationFinal.this.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        //thread
//        StrictMode.ThreadPolicy  policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
        //End thread
        //Global
        ApplicationGlobal appSetting=((ApplicationGlobal)getApplicationContext());
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        //End Global
        //
        btnBack= (Button) findViewById(R.id.btn_Back);
        btnOk=(Button) findViewById(R.id.btn_OkProfile);
        edtName= (EditText) findViewById(R.id.txtNameProfile);
        edtDOB= (EditText) findViewById(R.id.txtDOBProfile);
        edtSex= (EditText) findViewById(R.id.txtSexProfile);
        edtMotherName= (EditText) findViewById(R.id.txtMotherNameProfile);
        edtEmail= (EditText) findViewById(R.id.txtEmailProfile);
        edtPhone= (EditText) findViewById(R.id.txtPhoneProfile);
        edtAddress= (EditText) findViewById(R.id.txtAddressProfile);
        //

        //Set Position

        AbsoluteLayout.LayoutParams btnBackParams =(AbsoluteLayout.LayoutParams)btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionAbs(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        AbsoluteLayout.LayoutParams edtNameParams =(AbsoluteLayout.LayoutParams)edtName.getLayoutParams();
        edtNameParams=setGlobal.setTotalPositionAbs(edtNameParams);
        edtName.setLayoutParams(edtNameParams);

        AbsoluteLayout.LayoutParams edtDobParams =(AbsoluteLayout.LayoutParams)edtDOB.getLayoutParams();
        edtDobParams=setGlobal.setTotalPositionAbs(edtDobParams);
        edtDOB.setLayoutParams(edtDobParams);

        AbsoluteLayout.LayoutParams edtSexParams =(AbsoluteLayout.LayoutParams)edtSex.getLayoutParams();
        edtSexParams=setGlobal.setTotalPositionAbs(edtSexParams);
        edtSex.setLayoutParams(edtSexParams);

        AbsoluteLayout.LayoutParams edtMotherNameParams =(AbsoluteLayout.LayoutParams)edtMotherName.getLayoutParams();
        edtMotherNameParams=setGlobal.setTotalPositionAbs(edtMotherNameParams);
        edtMotherName.setLayoutParams(edtMotherNameParams);

        AbsoluteLayout.LayoutParams edtEmailParams =(AbsoluteLayout.LayoutParams)edtEmail.getLayoutParams();
        edtEmailParams=setGlobal.setTotalPositionAbs(edtEmailParams);
        edtEmail.setLayoutParams(edtEmailParams);

        AbsoluteLayout.LayoutParams edtPhoneParams =(AbsoluteLayout.LayoutParams)edtPhone.getLayoutParams();
        edtPhoneParams=setGlobal.setTotalPositionAbs(edtPhoneParams);
        edtPhone.setLayoutParams(edtPhoneParams);

        AbsoluteLayout.LayoutParams edtAddressParams =(AbsoluteLayout.LayoutParams)edtAddress.getLayoutParams();
        edtAddressParams=setGlobal.setTotalPositionAbs(edtAddressParams);
        edtAddress.setLayoutParams(edtAddressParams);


        AbsoluteLayout.LayoutParams btnOkParams =(AbsoluteLayout.LayoutParams)btnOk.getLayoutParams();
        btnOkParams=setGlobal.setTotalPositionAbs(btnOkParams);
        btnOk.setLayoutParams(btnOkParams);
        //End position

        //Set values

        edtName.setText(name);
        edtDOB.setText(dobDay+"/"+dobMonth+"/"+dobYear);
        edtSex.setText(sex);
        edtMotherName.setText(motherName);
        edtEmail.setText(email);
        edtPhone.setText(phoneNumber);
        edtAddress.setText(address);
        //

        edtDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialogDate = new DatePickerDialog(RegistrationFinal.this,
                        new mDateSetListener(),Integer.valueOf(dobYear), Integer.valueOf(dobMonth), Integer.valueOf(dobDay) );
                dialogDate.show();
            }
        });


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerConnection connection=new ServerConnection();
                connection.doInBackground();

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //datePicker
    class mDateSetListener implements DatePickerDialog.OnDateSetListener {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            int mYear = year;
            int mMonth = monthOfYear;
            int mDay = dayOfMonth;
            edtDOB.setText(new StringBuilder()
                    // Month is 0 based so add 1
                   .append(mDay).append("/") .append(mMonth + 1).append("/")
                    .append(mYear).append(" "));
            dobDay= String.valueOf(mDay);
            dobMonth= String.valueOf(mMonth);
            dobYear= String.valueOf(mYear);
            //System.out.println(v.getText().toString());
        }
    }
    //End Datepicker


    class ServerConnection extends AsyncTask<Void,Void,Void>
    {

        ProgressDialog pd;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd=new ProgressDialog(RegistrationFinal.this,ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT);
            pd.setMessage("Connecting to server...");
            pd.setTitle("Zwitsal");
            pd.show();
        }

        @Override
//        protected Void doInBackground(Void... params) {
//            try{
//                Registrant user=new Registrant(edtName.getText().toString(),edtDOB.getText().toString(),
//                        edtSex.getText().toString(),edtMotherName.getText().toString(),
//                        edtEmail.getText().toString(),edtPhone.getText().toString(),
//                        edtAddress.getText().toString());
//
//                Gson gson = new Gson();
//                String json = gson.toJson(user);
//                String url="http://192.168.1.170:7699/Account/Register";
//                HttpClient httpclient = new DefaultHttpClient();
//                HttpPost httppost = new HttpPost(url.toString());
//                httppost.setHeader("Content-type", "application/json");
//
//                StringEntity se = new StringEntity(json.toString());
//                se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
//                httppost.setEntity(se);
//
//                HttpResponse response = httpclient.execute(httppost);
//
//                String temp = EntityUtils.toString(response.getEntity());
//                Toast.makeText(RegistrationFinal.this, temp, Toast.LENGTH_LONG);
//                Log.i("tag", temp);
//
//
//                Toast.makeText(RegistrationFinal.this, "Sending Data to Server", Toast.LENGTH_LONG);
//
//                SharedPreferences.Editor preEditor=Landing.zwitsalFisrtRun.edit();
//                preEditor.putBoolean("firstRun", false);
//                preEditor.commit();
//
//                Intent homeScreen = new Intent(RegistrationFinal.this,Home.class);
//                startActivity(homeScreen);
//
//            }
//            catch (ClientProtocolException e) {
//                AlertDialog.Builder alertName = new AlertDialog.Builder(RegistrationFinal.this);
//                alertName.setMessage(e.getMessage());
//                alertName.setTitle("Warning...");
//                alertName.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//                alertName.show();
//
//
//            }
//            catch (IOException e) {
//                AlertDialog.Builder alertName = new AlertDialog.Builder(RegistrationFinal.this);
//                alertName.setMessage(e.getMessage());
//                alertName.setTitle("Warning...");
//                alertName.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//                alertName.show();
//            }
//
//            return null;
//        }

        protected Void doInBackground(Void... params) {
            try{
                Registrant user=new Registrant(edtName.getText().toString(),edtDOB.getText().toString(),
                        edtSex.getText().toString(),edtMotherName.getText().toString(),
                        edtEmail.getText().toString(),edtPhone.getText().toString(),
                        edtAddress.getText().toString());


                SharedPreferences.Editor preEditor=Landing.zwitsalFisrtRun.edit();
                preEditor.putBoolean("firstRun", false);
                preEditor.commit();

///
                final Dialog dlg=new Dialog(RegistrationFinal.this);
                dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dlg.setContentView(R.layout.thankyou);
                ImageView img= (ImageView) dlg.findViewById(R.id.fullimage);
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dlg.dismiss();
                        Intent homeScreen = new Intent(RegistrationFinal.this,Home.class);
                        startActivity(homeScreen);

                    }
                });
                dlg.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Intent homeScreen = new Intent(RegistrationFinal.this, Home.class);
                        startActivity(homeScreen);

                    }
                });
                dlg.show();

/////
//                Intent homeScreen = new Intent(RegistrationFinal.this,Home.class);
//                startActivity(homeScreen);

            }

            catch (Exception e) {
                AlertDialog.Builder alertName = new AlertDialog.Builder(RegistrationFinal.this);
                alertName.setMessage(e.getMessage());
                alertName.setTitle("Warning...");
                alertName.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertName.show();
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            pd.dismiss();
        }
    }

}