package com.example.hiennv.mystyle.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.example.hiennv.mystyle.ui.home.MainActivity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

public class PermissionUtils {
    /**
     *
     * @param context
     * @param permission
     */
    public static void singlePermission(Activity context, String permission){
        Dexter.withActivity(context)
                .withPermission(permission)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        //Dc cap
                        Toast.makeText(context, "Permission granted!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        //Tu choi nhay vao man hinh chinh
                        //Show dialog request all permission
                        Toast.makeText(context, "Permission denied!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                    }
                })
                .withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        AppLogger.e("Dexter",error);
                    }
                }).check();
    }

    /**
     *
     * @param activity
     * @param permissions
     */
    public static void allPermission(Activity activity, String[] permissions){
        Dexter.withActivity(activity)
                .withPermissions(permissions)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        AppLogger.i("Dexter",report);
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        AppLogger.i("Dexter",permissions);
                    }
                })
                .withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        AppLogger.e("Dexter",error);
                    }
                }).check();
    }
}
