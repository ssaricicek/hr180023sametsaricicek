package com.hr180023.samet_saricicek_final.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.hr180023.samet_saricicek_final.MyApp;
import com.hr180023.samet_saricicek_final.R;
import com.hr180023.samet_saricicek_final.utils.ConnectionControl;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashActivity();
    }


    public void splashActivity(){

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                if(ConnectionControl.networkAvailableOrNot(MyApp.getAppContext())){  // yardımcı class ile internet bağlantısı kontorlü ve eğer internet bağlantısı varsa intent ile MainActivity'e geçiş
                    Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                    SplashActivity.this.startActivity(mainIntent);
                    SplashActivity.this.finish(); }
                else {
                    alertDialog();
                }
            }
        }, SPLASH_DISPLAY_LENGTH);
    }



    private void alertDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(SplashActivity.this);  // Alert dialog build edilmesi
        dialog.setTitle(R.string.no_connection);
        dialog.setMessage(R.string.connect_to_internet);
        dialog.setCancelable(true);



        dialog.setPositiveButton(    // positive Button yazısının Kapat olarak set edilmesi ve bu button a tıklanıldığında uygulamayı sonlandırma
                R.string.close,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int
                            id) {
                        finishAffinity();

                    }
                });


        dialog.setNegativeButton(  // negative Button yazısının İnterneti Aç olarak set edilmesi ve bu butona tıklanıldığında bu ayarlara gidilmesi
                R.string.open_network,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                        startActivity(intent);
                        dialog.cancel();
                    }
                });

        AlertDialog alert = dialog.create();
        alert.show();
    }
}
