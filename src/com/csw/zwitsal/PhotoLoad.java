package com.csw.zwitsal;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by MajidRazmjoo on 7/30/14.
 */
public class PhotoLoad extends Activity implements View.OnClickListener{
    private static final int SELECT_PICTURE = 1;
    private  String selectedImagePath;
    Button btnBack,btnLoadGallery,btnLoadFacebook,btnHome,btnForward;
    ImageView imgLoaded;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_load);
        //Global Setting
        ApplicationGlobal appSetting= (ApplicationGlobal) getApplicationContext();
        GlobalFunctions setGlobal=new GlobalFunctions(appSetting.getWidth(),appSetting.getHeight());
        // End
        //Component
        btnBack= (Button) findViewById(R.id.btn_BackPhotoLoad);
        btnBack.setOnClickListener(this);
        btnLoadGallery= (Button) findViewById(R.id.btn_PhotoLoadGallery);
        btnLoadGallery.setOnClickListener(this);
        btnLoadFacebook= (Button) findViewById(R.id.btn_PhotoLoadFacebook);
        btnLoadFacebook.setOnClickListener(this);
        btnForward= (Button) findViewById(R.id.btn_ForwardLoadPhoto);
        btnForward.setOnClickListener(this);
        btnHome= (Button) findViewById(R.id.btn_Home);
        btnHome.setOnClickListener(this);
        imgLoaded= (ImageView) findViewById(R.id.imageLoaded);
        //


        RelativeLayout.LayoutParams btnBackParams= (RelativeLayout.LayoutParams) btnBack.getLayoutParams();
        btnBackParams=setGlobal.setTotalPositionRel(btnBackParams);
        btnBack.setLayoutParams(btnBackParams);

        RelativeLayout.LayoutParams btnPhotoLoadGalleryParams= (RelativeLayout.LayoutParams) btnLoadGallery.getLayoutParams();
        btnPhotoLoadGalleryParams=setGlobal.setTotalPositionRel(btnPhotoLoadGalleryParams);
        btnLoadGallery.setLayoutParams(btnPhotoLoadGalleryParams);

        RelativeLayout.LayoutParams btnPhotoLoadFacebook= (RelativeLayout.LayoutParams) btnLoadFacebook.getLayoutParams();
        btnPhotoLoadFacebook=setGlobal.setTotalPositionRel(btnPhotoLoadFacebook);
        btnLoadFacebook.setLayoutParams(btnPhotoLoadFacebook);

        RelativeLayout.LayoutParams imgLoadedParams =(RelativeLayout.LayoutParams)imgLoaded.getLayoutParams();
        imgLoadedParams=setGlobal.setTotalPositionRel(imgLoadedParams);
        imgLoaded.setLayoutParams(imgLoadedParams);

        RelativeLayout.LayoutParams btnForwardLoadPhotoParams =(RelativeLayout.LayoutParams)btnForward.getLayoutParams();
        btnForwardLoadPhotoParams=setGlobal.setTotalPositionRel(btnForwardLoadPhotoParams);
        btnForward.setLayoutParams(btnForwardLoadPhotoParams);

        RelativeLayout.LayoutParams btnHomeParams =(RelativeLayout.LayoutParams)btnHome.getLayoutParams();
        btnHomeParams=setGlobal.setTotalPositionRel(btnHomeParams);
        btnHome.setLayoutParams(btnHomeParams);
        //
    }
    private Bitmap getScaledBitmap(String picturePath, int width, int height) {
        BitmapFactory.Options sizeOptions = new BitmapFactory.Options();
        sizeOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(picturePath, sizeOptions);

        int inSampleSize = calculateInSampleSize(sizeOptions, width, height);

        sizeOptions.inJustDecodeBounds = false;
        sizeOptions.inSampleSize = inSampleSize;

        return BitmapFactory.decodeFile(picturePath, sizeOptions);
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and
            // width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will
            // guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                System.out.println("Image Path : " + selectedImagePath);
                //imgLoaded.setImageURI(selectedImageUri);
                imgLoaded.setImageBitmap(getScaledBitmap(selectedImagePath, imgLoaded.getWidth(),  imgLoaded.getWidth()));
            }
        }
    }

    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_BackPhotoLoad:
                finish();
                break;
            case R.id.btn_PhotoLoadGallery:
                Intent loadGallery=new Intent();
                loadGallery.setType("image/*");
                loadGallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(loadGallery,"Select Picture"),SELECT_PICTURE);
                break;
            case R.id.btn_ForwardLoadPhoto:
                Intent loadPhotoFilter=new Intent(PhotoLoad.this,PhotoFilter.class);
                imgLoaded.destroyDrawingCache();
                imgLoaded.setDrawingCacheEnabled(true);
                PhotoFilter.bmpInput=imgLoaded.getDrawingCache();
                startActivity(loadPhotoFilter);
                break;
            case R.id.btn_Home:
                Intent loadHome=new Intent(PhotoLoad.this,Home.class);
                startActivity(loadHome);
                break;
        }
    }
}