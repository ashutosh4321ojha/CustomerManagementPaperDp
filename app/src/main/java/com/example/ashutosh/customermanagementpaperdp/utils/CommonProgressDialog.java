package com.example.ashutosh.customermanagementpaperdp.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by ashutosh on 2/16/2016.
 */
public class CommonProgressDialog {
    private static ProgressDialog loading = null;

    public static void showProgressDialog(Context context, String message) {
        if (loading == null) {
            loading = new ProgressDialog(context);
        }

        if (message == null) {
            loading.setMessage("Loading...");
        } else {
            loading.setMessage(message);
        }

        loading.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        loading.setCancelable(true);
        loading.show();
    }

    public static void dismissProgressDialog() {
        if (loading != null && loading.isShowing())
            loading.dismiss();
    }
}
