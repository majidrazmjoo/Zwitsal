package com.csw.zwitsal;

import android.app.Application;

/**
 * Created by Majid on 7/15/14.
 */
public class ApplicationGlobal extends Application {
    private double screenWidth;
    private double screenHeight;


    public double getWidth(){
        return screenWidth;
    }
    public void setWidth(double width)
    {
        screenWidth=width;
    }
    public double getHeight(){
        return screenHeight;
    }
    public void setHeight(double height)
    {
        screenHeight=height;
    }

}
