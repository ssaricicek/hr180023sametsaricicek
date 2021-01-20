package com.hr180023.samet_saricicek_final.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hr180023.samet_saricicek_final.model.Model;
import com.hr180023.samet_saricicek_final.retrofit.APIService;
import com.hr180023.samet_saricicek_final.retrofit.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Github extends ViewModel {
    private MutableLiveData<List<Model>> githubList;

    public Github()  {
        githubList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Model>> getGithubListObserver(){
        return githubList;
    }  // izleyici

    public void apiCall(){
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<Model>> call  = apiService.getGithubList();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {  // apiye yapılan request sonrasında response geldiğinde
                githubList.postValue(response.body());  // başarılı olduğunda response bodysinden gelen modelin post edilmesi
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {   // apiye yapılan request sonrasında response fail olduğunda
                githubList.postValue(null);   // fail olduğunda gönderilecek post değeri
            }
        });
    }

}
