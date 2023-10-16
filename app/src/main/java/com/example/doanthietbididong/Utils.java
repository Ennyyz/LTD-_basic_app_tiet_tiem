package com.example.doanthietbididong;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    //database
    public static final String DATABASE_NAME="db-saving";
    public static  final String TABLE_USER="user";
    public static final String COLUMN_USER_ID="id";
    public static  final String COLUMN_USER_FULLNAME="fullname";
    public static  final String COLUMN_USER_EMAIL="email";
    public static  final String COLUMN_USER_DATE="date";
    public static  final String COLUMN_USER_SODIENTHOAI="sodienthoai";
    public static  final String COLUMN_USER_PASSWORD="matkhau";
    public static  final String COLUMN_USER_HOCHIEU="hochieu";


    //function
    public static Bitmap convertToBitmapFromAssets(Context context, String nameImage)
    {
        AssetManager assetManager= context.getAssets();
        try{
            InputStream inputStream= assetManager.open("images/"+nameImage);
            Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
