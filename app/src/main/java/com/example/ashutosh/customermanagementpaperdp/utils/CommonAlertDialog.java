package com.example.ashutosh.customermanagementpaperdp.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by ashutosh on 2/16/2016.
 */
public  class CommonAlertDialog {
   private static AlertDialog.Builder myAlertDialog=null;
   // private static OnClickInterface onClickInterface;


    public static void setDialog(Context context,String message){
        if(myAlertDialog==null)
         myAlertDialog=new AlertDialog.Builder(context);

        myAlertDialog.setTitle("--- Title ---");
        myAlertDialog.setMessage(message);
        myAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                // do something when the OK button is clicked

                //myAlertDialog.d
            }
        });

        myAlertDialog.show();

    }
/*
    public static void setDialog(Context context,String message){
        if(myAlertDialog==null)
            myAlertDialog=new AlertDialog.Builder(context);

        myAlertDialog.setTitle("--- Title ---");
        myAlertDialog.setMessage(message);
        myAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                // do something when the OK button is clicked

                //myAlertDialog.d
            }
        });

        myAlertDialog.show();

    }




    public void onDialogOkClick(Context context,String message,){
    public static void setDialog(



    }
    public interface OnClickInterface{

        public void onDialogOkClick();
    }
*/

}
