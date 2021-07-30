package com.mayankgautam.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class UploadFile {
   public static boolean selectDocument(Context context, Activity activity) {
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED){
            return true;
        }else{
            ActivityCompat.requestPermissions(activity,new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},121);
            return ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED;
        }
    }


    public static void setProgressDialogDetail(ProgressDialog progressDialog) {
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Uploading File...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setProgress(0);
    }

    public static void Toasty(Context context){
        Toast.makeText(context, "Successfully Upload", Toast.LENGTH_SHORT).show();
    }
}
