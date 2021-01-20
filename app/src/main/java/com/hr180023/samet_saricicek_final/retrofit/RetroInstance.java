package com.hr180023.samet_saricicek_final.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {
    public static String BASE_URL = "https://raw.githubusercontent.com/";

    private static Retrofit retrofit;



    public static Retrofit getRetroClient() {   // retrofit ile ilgili ayarların yapıldığı bölüm. Örnek: BASE_URL in atanması
        OkHttpClient okClient = new OkHttpClient.Builder()
                .build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().client(okClient).baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
