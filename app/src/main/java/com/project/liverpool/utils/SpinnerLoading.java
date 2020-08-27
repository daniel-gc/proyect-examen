package com.project.liverpool.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class SpinnerLoading {
    private static ProgressDialog progressDialog=null;

    private static void createProgressDialog(final Context context, boolean isCancelable){
        if(context != null){
            progressDialog = new ProgressDialog(context, ProgressDialog.STYLE_SPINNER); //R.style.AppTheme_Dark_Dialog
            progressDialog.setCancelable(isCancelable);
        }
    }

    public static void show(final Context context,String message,boolean isCancelable){
        if(progressDialog == null){
            createProgressDialog(context,isCancelable);
        }

        if(progressDialog != null && !progressDialog.isShowing()) {
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(isCancelable);
            progressDialog.show();
        }
    }

    public static void hide(){
        if (progressDialog != null && progressDialog.isShowing()) {
            try {
                progressDialog.dismiss();
            } catch (Exception e) {
            }
        }
        progressDialog = null;
    }
}
