package com.hr180023.samet_saricicek_final.retrofit;

import com.hr180023.samet_saricicek_final.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("ssaricicek/hr180023sametsaricicek/main/json/nba_teams_2021.json")   // endpointlerin ilgili fonksiyona göre ayarlanması
    Call<List<Model>> getGithubList();

}
