package com.hr180023.samet_saricicek_final.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hr180023.samet_saricicek_final.R;
import com.hr180023.samet_saricicek_final.model.Model;

import java.util.List;

public class NBAteamsAdapter extends RecyclerView.Adapter<NBAteamsAdapter.NBATeamsAdapterJavaViewHolder> {

    public OnItemClickListener mListener;
    private List<Model> lists;
    private Context context;

    public interface OnItemClickListener {
        public void onItemClick(int position);

    }

    public class NBATeamsAdapterJavaViewHolder extends RecyclerView.ViewHolder {

        TextView textView_team_name, textView_team_detail_info;
        ImageView imageView_team_logo;


        public NBATeamsAdapterJavaViewHolder(View view, final OnItemClickListener listener) {
            super(view);

            // xml layout ile id lerin bağlanması
            textView_team_name = itemView.findViewById(R.id.textView_team_name);
            textView_team_detail_info = itemView.findViewById(R.id.textView_team_detail_info);
            imageView_team_logo = itemView.findViewById(R.id.imageView_team_logo);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!= null) {
                        int pos = getAdapterPosition();
                        if(pos!= RecyclerView.NO_POSITION) {
                            listener.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }

    public void setOnItemClickListener(OnItemClickListener listener ) {
        mListener = listener;
    }

    public NBAteamsAdapter(Context context, List<Model> repoList){
        this.lists=repoList;
        this.context = context;
    }

    @NonNull
    @Override
    public NBATeamsAdapterJavaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nba_item_team,parent,false);
        NBATeamsAdapterJavaViewHolder teamsAdapterJavaViewHolder= new NBATeamsAdapterJavaViewHolder(view, mListener);
        return teamsAdapterJavaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NBAteamsAdapter.NBATeamsAdapterJavaViewHolder holder, int position) {
        holder.textView_team_detail_info.setText(lists.get(position).getTakim_tarih());  // burada gelen model verisine göre sırayla her bir Model set edilir itemlere (recyclerview içindeki itemlar)
        holder.textView_team_name.setText(lists.get(position).getTakim_adi());

       Glide.with(context)      // glide ile gelen kucuk logo url inin set edilip imageview_team_logo üzerinde gösterilmesi
                .load(lists.get(position).getKucuk_logo())
                .fitCenter()
                .into(holder.imageView_team_logo);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }



}
