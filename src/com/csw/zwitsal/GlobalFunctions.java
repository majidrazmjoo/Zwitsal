package com.csw.zwitsal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Majid on 7/15/14.
 */
public class GlobalFunctions extends Activity {

    private double screenX,screenY;

//    private int leftPos,topPos,widthValue,heightValue;

    public GlobalFunctions(double width, double height)
    {
        screenX=width;
        screenY=height;

    }


    public ArrayAdapter<String> fillSpinner(int start,int end,Context con){
        ArrayAdapter<String> spinnerAdapter;//=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        List<String> spinnerArray=new ArrayList<String>();
        for (int i=start;i<=end;i++)
        {
            spinnerArray.add(String.valueOf(i));

        }
        ArrayAdapter<String> sAdapter=new ArrayAdapter<String>(con,android.R.layout.simple_spinner_item,spinnerArray);
        sAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter=sAdapter;
        return (spinnerAdapter);

    }

    public static boolean isValidEmail (CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }


    public AbsoluteLayout.LayoutParams setTotalPositionAbs(AbsoluteLayout.LayoutParams inputParam){
//        int x,y,wi,he;
        AbsoluteLayout.LayoutParams finalParams=inputParam;
//        int xe=setLeftPosition(inputParam.x);
        finalParams.x=setLeftPosition(inputParam.x);
        finalParams.y=setTopPosition(inputParam.y);
        finalParams.width=setWidth(inputParam.width);
        finalParams.height=setHeight(inputParam.height);
//        x=setLeftPosition(inputParam.x);
//        y=setTopPosition(inputParam.y);
//        wi=setWidth(inputParam.width);
//        he=setHeight(inputParam.height);

        return finalParams;

    }


    public RelativeLayout.LayoutParams setTotalPositionRel(RelativeLayout.LayoutParams inputParam){
//        int x,y,wi,he;
        RelativeLayout.LayoutParams finalParams=inputParam;
//        int xe=setLeftPosition(inputParam.x);
        finalParams.leftMargin=setLeftPosition(inputParam.leftMargin);
        finalParams.topMargin=setTopPosition(inputParam.topMargin);
        finalParams.width=setWidth(inputParam.width);
        finalParams.height=setHeight(inputParam.height);
//        x=setLeftPosition(inputParam.x);
//        y=setTopPosition(inputParam.y);
//        wi=setWidth(inputParam.width);
//        he=setHeight(inputParam.height);

        return finalParams;

    }

    public RelativeLayout.LayoutParams setTotalPositionRelFilterImage(RelativeLayout.LayoutParams inputParam){
//        int x,y,wi,he;
        RelativeLayout.LayoutParams finalParams=inputParam;
//        int xe=setLeftPosition(inputParam.x);
        finalParams.leftMargin=setLeftPosition(inputParam.leftMargin);
        finalParams.topMargin=setTopPosition(inputParam.topMargin);
        int wh=setWidth(inputParam.width);
        finalParams.width=wh;
        finalParams.height=wh;
//        x=setLeftPosition(inputParam.x);
//        y=setTopPosition(inputParam.y);
//        wi=setWidth(inputParam.width);
//        he=setHeight(inputParam.height);

        return finalParams;

    }

    private   int setLeftPosition(int left)
    {
        return (int)((screenX/480)*left);
    }

    private  int setTopPosition(int top)
    {
        return (int)((screenY/800)*top);
    }

    private   int setWidth(int width)
    {
        return (int)((screenX/480)*width);
    }

    private   int setHeight(int height)
    {
        return (int)((screenY/800)*height);
    }

}
