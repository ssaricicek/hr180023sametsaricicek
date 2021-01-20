package com.hr180023.samet_saricicek_final.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hr180023.samet_saricicek_final.R;
import com.hr180023.samet_saricicek_final.adapter.NBAteamsAdapter;
import com.hr180023.samet_saricicek_final.model.Model;
import com.hr180023.samet_saricicek_final.viewModel.Github;

import java.util.List;

public class MainActivity  extends AppCompatActivity {

    RecyclerView recyclerView_teams;
    NBAteamsAdapter teamsAdapter;
    private Github model;
    private LinearLayoutManager linearLayoutManager;
    ProgressBar progress_bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml layout id lerinin bağlanması
        recyclerView_teams = findViewById(R.id.recyclerView_teams);

        progress_bar = findViewById(R.id.progress_bar);

        model = new ViewModelProvider(this).get(Github.class);     // api call ve observe kullanımlarının oluşturulması

        linearLayoutManager =new LinearLayoutManager(this.getApplicationContext());

        model.apiCall();

        model.getGithubListObserver().observe(this, new Observer<List<Model>>() {  // izleyici ile live data geldiğinde bunun alınıp istenilen şekilde kullanılması
            @Override
            public void onChanged(final List<Model> githubModels) {
                if(githubModels != null) {


                    teamsAdapter = new NBAteamsAdapter(MainActivity.this, githubModels);
                    recyclerView_teams.setLayoutManager(linearLayoutManager);  // recycler görünümünün nasıl olacağının set edilmedi . Burada sıralı alt alta olacak şekilde çalışacak.
                    recyclerView_teams.setAdapter(teamsAdapter);   // Modelin adaptere set edilmesi
                    teamsAdapter.notifyDataSetChanged();  // adapter de değişiklik olduğunun iletilmesi

                    teamsAdapter.setOnItemClickListener(new NBAteamsAdapter.OnItemClickListener() {     // ilgili item a tıklanıldığında olacak işlemleri içerir
                        @Override
                        public void onItemClick(int position) {

                            progress_bar.setVisibility(View.VISIBLE);;  // progress bar görünür hale gelir

                            new Handler().postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    progress_bar.setVisibility(View.GONE);  // progress bar gizlenir
                                    Intent intent = new Intent(MainActivity.this, NBAteamDetailActivity.class);
                                    intent.putExtra("githubModel", githubModels.get(position));
                                    startActivity(intent);
                                }

                            }, 3000);   // 3 saniye progress bar çalışır ve 3 saniye sonunda NBAteamDetailActivity açılır



                        }
                    });
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        alertDialogExit();
    }

    private void alertDialogExit(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle(R.string.close_app);
        dialog.setMessage(R.string.close_app_question);
        dialog.setCancelable(true);



        dialog.setPositiveButton(
                R.string.exit,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int
                            id) {
                        finishAffinity();

                    }
                });


        dialog.setNegativeButton(
                R.string.cancel,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alert = dialog.create();
        alert.show();
    }


}