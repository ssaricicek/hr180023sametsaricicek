package com.hr180023.samet_saricicek_final.utils;

import android.content.Context;
import android.widget.ImageView;

public class Glide {

    //context, url ve imageview bilgisinin alınıp glide kütüphanesinin kullanıldı yardımcı bölüm
    public static void useGlide(Context context, String url, ImageView imageView){
        com.bumptech.glide.Glide.with(context)
                .load(url)  // url in load edilmesi
                .fitCenter()  // görünüm ayarı
                .into(imageView); // imageview e görünümün atanması

    }
}
