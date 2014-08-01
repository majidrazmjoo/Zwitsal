package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by MajidRazmjoo on 7/30/14.
 */
public class PhotoFilter extends Activity implements View.OnClickListener{
    Button btnBack,btnFilterPlain,btnFilterPolka,btnFilterZigzag,btnFilterFlorals,btnFilterMessage,btnFilterOthers,btnSaveShare,btnHome;
    Button btnFilter1,btnFilter2,btnFilter3,btnFilter4,btnFilter5;
    ImageView imgFinal,imgHeader,imgFilter,imgAfterFilter;
    String filterType,filterNumber;
    public static Bitmap bmpInput;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_filter);

        //Global Setting
        ApplicationGlobal appSetting= (ApplicationGlobal) getApplicationContext();
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        // End
        //
        btnBack= (Button) findViewById(R.id.btn_BackPhotoFilter);
        btnBack.setOnClickListener(this);
        btnSaveShare= (Button) findViewById(R.id.btn_Save_Share);
        btnSaveShare.setOnClickListener(this);
        btnHome= (Button) findViewById(R.id.btn_Home);
        btnHome.setOnClickListener(this);
        btnFilterPlain= (Button) findViewById(R.id.btn_FilterPlain);
        btnFilterPlain.setOnClickListener(this);
        btnFilterPolka= (Button) findViewById(R.id.btn_FilterPolka);
        btnFilterPolka.setOnClickListener(this);
        btnFilterZigzag= (Button) findViewById(R.id.btn_FilterZigzag);
        btnFilterZigzag.setOnClickListener(this);
        btnFilterFlorals= (Button) findViewById(R.id.btn_FilterFlorals);
        btnFilterFlorals.setOnClickListener(this);
        btnFilterMessage= (Button) findViewById(R.id.btn_FilterMessage);
        btnFilterMessage.setOnClickListener(this);
        btnFilterOthers= (Button) findViewById(R.id.btn_FilterOthers);
        btnFilterOthers.setOnClickListener(this);
        btnFilter1= (Button) findViewById(R.id.btn_FilterHeader1);
        btnFilter1.setOnClickListener(this);
        btnFilter2= (Button) findViewById(R.id.btn_FilterHeader2);
        btnFilter2.setOnClickListener(this);
        btnFilter3= (Button) findViewById(R.id.btn_FilterHeader3);
        btnFilter3.setOnClickListener(this);
        btnFilter4= (Button) findViewById(R.id.btn_FilterHeader4);
        btnFilter4.setOnClickListener(this);
        btnFilter5= (Button) findViewById(R.id.btn_FilterHeader5);
        btnFilter5.setOnClickListener(this);
        imgHeader= (ImageView) findViewById(R.id.img_Filter_Header);
        imgFinal = (ImageView) findViewById(R.id.img_FilterProceed);
        imgFinal.setImageBitmap(bmpInput);
        imgFilter= (ImageView) findViewById(R.id.img_FilterApplied);
        imgAfterFilter= (ImageView) findViewById(R.id.img_AfterFilter);

        filterType="color";
        filterNumber="1";
        //
        RelativeLayout.LayoutParams btnBackParams= (RelativeLayout.LayoutParams) btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionRel(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        RelativeLayout.LayoutParams btnFilter1Params= (RelativeLayout.LayoutParams) btnFilter1.getLayoutParams();
        btnFilter1Params=setGlobal.setTotalPositionRel(btnFilter1Params);
        btnFilter1.setLayoutParams(btnFilter1Params);

        RelativeLayout.LayoutParams btnFilter2Params= (RelativeLayout.LayoutParams) btnFilter2.getLayoutParams();
        btnFilter2Params=setGlobal.setTotalPositionRel(btnFilter2Params);
        btnFilter2.setLayoutParams(btnFilter2Params);

        RelativeLayout.LayoutParams btnFilter3Params= (RelativeLayout.LayoutParams) btnFilter3.getLayoutParams();
        btnFilter3Params=setGlobal.setTotalPositionRel(btnFilter3Params);
        btnFilter3.setLayoutParams(btnFilter3Params);

        RelativeLayout.LayoutParams btnFilter4Params= (RelativeLayout.LayoutParams) btnFilter4.getLayoutParams();
        btnFilter4Params=setGlobal.setTotalPositionRel(btnFilter4Params);
        btnFilter4.setLayoutParams(btnFilter4Params);

        RelativeLayout.LayoutParams btnFilter5Params= (RelativeLayout.LayoutParams) btnFilter5.getLayoutParams();
        btnFilter5Params=setGlobal.setTotalPositionRel(btnFilter5Params);
        btnFilter5.setLayoutParams(btnFilter5Params);

        RelativeLayout.LayoutParams btnFilterPlainParams= (RelativeLayout.LayoutParams) btnFilterPlain.getLayoutParams();
        btnFilterPlainParams=setGlobal.setTotalPositionRel(btnFilterPlainParams);
        btnFilterPlain.setLayoutParams(btnFilterPlainParams);

        RelativeLayout.LayoutParams btnFilterPolkaParams= (RelativeLayout.LayoutParams) btnFilterPolka.getLayoutParams();
        btnFilterPolkaParams=setGlobal.setTotalPositionRel(btnFilterPolkaParams);
        btnFilterPolka.setLayoutParams(btnFilterPolkaParams);

        RelativeLayout.LayoutParams btnFilterZigzagParams= (RelativeLayout.LayoutParams) btnFilterZigzag.getLayoutParams();
        btnFilterZigzagParams=setGlobal.setTotalPositionRel(btnFilterZigzagParams);
        btnFilterZigzag.setLayoutParams(btnFilterZigzagParams);

        RelativeLayout.LayoutParams btnFilterFloraParams= (RelativeLayout.LayoutParams) btnFilterFlorals.getLayoutParams();
        btnFilterFloraParams=setGlobal.setTotalPositionRel(btnFilterFloraParams);
        btnFilterFlorals.setLayoutParams(btnFilterFloraParams);

        RelativeLayout.LayoutParams btnFilterMessageParams= (RelativeLayout.LayoutParams) btnFilterMessage.getLayoutParams();
        btnFilterMessageParams=setGlobal.setTotalPositionRel(btnFilterMessageParams);
        btnFilterMessage.setLayoutParams(btnFilterMessageParams);

        RelativeLayout.LayoutParams btnFilterOthersParams= (RelativeLayout.LayoutParams) btnFilterOthers.getLayoutParams();
        btnFilterOthersParams=setGlobal.setTotalPositionRel(btnFilterOthersParams);
        btnFilterOthers.setLayoutParams(btnFilterOthersParams);

        RelativeLayout.LayoutParams imgFilterHeaderParams= (RelativeLayout.LayoutParams) imgHeader.getLayoutParams();
        imgFilterHeaderParams=setGlobal.setTotalPositionRel(imgFilterHeaderParams);
        imgHeader.setLayoutParams(imgFilterHeaderParams);


        //RelativeLayout.LayoutParams imgFilterProceedParams= (RelativeLayout.LayoutParams) imgFinal.getLayoutParams();
        //imgFilterProceedParams=setGlobal.setTotalPositionRelFilterImage(imgFilterProceedParams);
        //imgFinal.setLayoutParams(imgFilterProceedParams);

        RelativeLayout.LayoutParams imgAfterParams= (RelativeLayout.LayoutParams) imgAfterFilter.getLayoutParams();
        imgAfterParams=setGlobal.setTotalPositionRelFilterImage(imgAfterParams);
        imgAfterFilter.setLayoutParams(imgAfterParams);

        RelativeLayout.LayoutParams imgFilterParams= (RelativeLayout.LayoutParams) imgFilter.getLayoutParams();
        imgFilterParams=setGlobal.setTotalPositionRelFilterImage(imgFilterParams);
        imgFilter.setLayoutParams(imgFilterParams);
        imgFinal.setLayoutParams(imgFilterParams);

        RelativeLayout.LayoutParams btnSaveShareParams =(RelativeLayout.LayoutParams)btnSaveShare.getLayoutParams();
        btnSaveShareParams=setGlobal.setTotalPositionRel(btnSaveShareParams);
        btnSaveShare.setLayoutParams(btnSaveShareParams);

        RelativeLayout.LayoutParams btnHomeParams =(RelativeLayout.LayoutParams)btnHome.getLayoutParams();
        btnHomeParams=setGlobal.setTotalPositionRel(btnHomeParams);
        btnHome.setLayoutParams(btnHomeParams);
        //
    }

    private Bitmap processingBitmap(){
        Bitmap bmp1 = null;
        Bitmap bmp2 = null;
        Bitmap bmpOverlay = null;
        try {
            imgFilter.destroyDrawingCache();
            imgFilter.setDrawingCacheEnabled(true);
            bmp1 = imgFilter.getDrawingCache();

            imgFinal.destroyDrawingCache();
            imgFinal.setDrawingCacheEnabled(true);
            bmp2 = imgFinal.getDrawingCache();

            bmpOverlay = Bitmap.createBitmap(bmp1.getWidth(),bmp1.getHeight(),bmp1.getConfig());
            Canvas canvas = new Canvas(bmpOverlay);
            canvas.drawBitmap(bmp2, 0, 0, null);
            canvas.drawBitmap(bmp1, new Matrix(), null);


        } catch (Exception e) {
            e.printStackTrace();
        }

        //return newBitmap;
        return bmpOverlay;
    }

    private void saveImageToGallery(){

        //    File zwitsalDir=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM),"zwitsal");
        try{
            imgAfterFilter.setDrawingCacheEnabled(true);
            //Bitmap b = mImage.getDrawingCache();

            MediaStore.Images.Media.insertImage(this.getContentResolver(), processingBitmap(),"Zwitsal", "Photo with Zwitsal filter");
            Toast.makeText(this,"Image stored in galley",Toast.LENGTH_LONG).show();
        }
        catch(Exception ex){
            Toast.makeText(this,"Error in saving image",Toast.LENGTH_LONG).show();
        }

    }

    private void saveImageToZwitsal(){
        Bitmap imageZwitsal;
        imageZwitsal=processingBitmap();
        String zwitsalPath=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath();
        File zwitsalDir=new File(zwitsalPath+"/Zwitsal");
        zwitsalDir.mkdir();
        Random generator= new Random();
        int picName=100000;
        picName=generator.nextInt(picName);
        String imageName = "zwitsal-" + picName + ".jpg";
        File fileImage=new File(zwitsalDir,imageName);
        if (fileImage.exists()){
            fileImage.delete();
        }
        try{
            FileOutputStream outFile=new FileOutputStream(fileImage);
            imageZwitsal.compress(Bitmap.CompressFormat.JPEG,90,outFile);
            outFile.flush();
            outFile.close();
            Toast.makeText(this,"Image stored in galley",Toast.LENGTH_LONG).show();

        }
        catch (Exception ex){
            ex.printStackTrace();
            Toast.makeText(this,"Error in saving image",Toast.LENGTH_LONG).show();
        }

    }

    private void createFilter(){
        int idFilter = getResources().getIdentifier("filter_" + filterType + filterNumber, "drawable", getPackageName());
        imgFilter.setImageResource(idFilter);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_BackPhotoFilter:
                finish();
                break;
            case R.id.btn_FilterPlain:
                imgHeader.setImageResource(R.drawable.photo_filter_color_header);
                filterType="color";
                break;
            case R.id.btn_FilterPolka:
                imgHeader.setImageResource(R.drawable.photo_filter_polka_header);
                filterType="polka";
                break;
            case R.id.btn_FilterZigzag:
                imgHeader.setImageResource(R.drawable.photo_filter_zigzag_header);
                filterType="zigzag";
                break;
            case R.id.btn_FilterFlorals:
                imgHeader.setImageResource(R.drawable.photo_filter_flora_header);
                filterType="florals";
                break;
            case R.id.btn_FilterMessage:
                imgHeader.setImageResource(R.drawable.photo_filter_message_header);
                filterType="message";
                break;
            case R.id.btn_FilterOthers:
                imgHeader.setImageResource(R.drawable.photo_filter_others_header);
                filterType="others";
                break;
            //Filters

            case R.id.btn_FilterHeader1:
                filterNumber="1";
                createFilter();
                break;
            case R.id.btn_FilterHeader2:
                filterNumber="2";
                createFilter();
                break;
            case R.id.btn_FilterHeader3:
                filterNumber="3";
                createFilter();
                break;
            case R.id.btn_FilterHeader4:
                filterNumber="4";
                createFilter();
                break;
            case R.id.btn_FilterHeader5:
                filterNumber="5";
                createFilter();
                break;
            //
            case R.id.btn_Save_Share:
//                imgAfterFilter.setImageBitmap(processingBitmap());
//                saveImageToGallery();
                saveImageToZwitsal();
                break;
            case R.id.btn_Home:
                Intent loadHome=new Intent(PhotoFilter.this,Home.class);
                startActivity(loadHome);
                break;

        }
    }
}