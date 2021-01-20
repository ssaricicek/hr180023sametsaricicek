package com.hr180023.samet_saricicek_final.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.hr180023.samet_saricicek_final.MyApp;
import com.hr180023.samet_saricicek_final.R;
import com.hr180023.samet_saricicek_final.model.Model;
import com.hr180023.samet_saricicek_final.utils.Constants;
import com.hr180023.samet_saricicek_final.utils.Glide;

public class NBAteamDetailActivity extends AppCompatActivity {
    CardView cardView_logo;
    TextView textView_kurulus_tarih, textView_detail_of_team, textView_item_team_name_detail_font_size;
    ImageView imageView_team_logo_detail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nba_team_detail);
        cardView_logo = findViewById(R.id.cardView_logo);     // xml layout id lerinin bağlanması
        imageView_team_logo_detail = findViewById(R.id.imageView_team_logo_detail);
        textView_kurulus_tarih = findViewById(R.id.textView_kurulus_tarih);
        textView_detail_of_team = findViewById(R.id.textView_detail_of_team);
        textView_item_team_name_detail_font_size = findViewById(R.id.textView_item_team_name_detail_font_size);

        final Model model = getIntent().getExtras().getParcelable("githubModel");

        Glide.useGlide(MyApp.getAppContext(),model.getKucuk_logo(), imageView_team_logo_detail);   // glide yardımcı classo ile ilgili urlden imageViewe görüntünün oluşturulması


        textView_kurulus_tarih.setText(model.getRenkler());      // gelen modelden renk string verisinin set edilmesi
        textView_detail_of_team.setText(model.getTakim_tarih());  // gelen modelden takim_tarih string verisinin set edilmesi
        textView_item_team_name_detail_font_size.setText(model.getTakim_adi());  // gelen modelden takim_adi string verisinin set edilmesi

        if(Constants.bestTeam.equals(model.getTakim_adi())){
            Toast.makeText(MyApp.getAppContext(), "MIAMI HEAT!!!", Toast.LENGTH_SHORT).show();
        }




    }
}
