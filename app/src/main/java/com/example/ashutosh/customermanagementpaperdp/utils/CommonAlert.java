package com.example.ashutosh.customermanagementpaperdp.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by ashutosh on 2/18/2016.
 */
public class CommonAlert {

    private static AlertDialog alert;
    private static OnAlertOkClickListener onAlertOkClickListener;

    public static void showAlert(Context context,String msg) {
        alert=new AlertDialog.Builder(context).setMessage(msg).create();

        //  alert.setCancelable(true);

        alert.setButton(AlertDialog.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert.dismiss();
            }
        });
        alert.show();
    }


    public static void showAlert(Context context,String msg,OnAlertOkClickListener onAlertOkClickListener1) {
        onAlertOkClickListener=onAlertOkClickListener1;
        alert=new AlertDialog.Builder(context).setMessage(msg).create();

        alert.setButton(AlertDialog.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onAlertOkClickListener.onOkButtonClicked();
                alert.dismiss();
            }
        });
        alert.show();
    }


    public static void hideAlert() {
        if (alert!=null && alert.isShowing()){
            alert.dismiss();
        }
    }

    public interface OnAlertOkClickListener
    {
        public void onOkButtonClicked();

    }
}
