package com.example.ysq.customcamera;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;

public class MainActivity extends AppCompatActivity {
    RxPermissions rxPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rxPermissions = RxPermissions.getInstance(this);

        Button cameraBtn = (Button) findViewById(R.id.cameraBtn);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxPermissions.requestEach(Manifest.permission.CAMERA).subscribe(new DefaultSubscriber<Permission>() {
                    @Override
                    public void onNext(Permission permission) {
                        if (permission.granted) {
                            startActivity(new Intent(MainActivity.this, CameraActivity.class));
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
                            builder.setMessage("您未授权相机权限,将无法拍照,请在权限管理中开启相机权限")
                                    .setTitle("提示").setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Uri packageURI = Uri.parse("package:" + getPackageName());
                                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                                            startActivity(intent);
                                        }
                                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            builder.create().show();

                        }
                    }
                });

            }
        });
    }
}
