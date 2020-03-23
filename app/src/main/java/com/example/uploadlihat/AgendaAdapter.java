package com.example.uploadlihat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.ViewHolder> {

    private Context myContext;
    private ArrayList<Agenda> agendalist;
    public AgendaAdapter(Context myContext, ArrayList<Agenda> agendalist) {
        this.myContext = myContext;
        this.agendalist = agendalist;
    }

    @NonNull
    @Override
    public AgendaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(myContext).inflate(R.layout.list_agenda,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AgendaAdapter.ViewHolder holder, int position) {
        Agenda agenda = agendalist.get(position);
        holder.tvNamaAgenda.setText(agenda.getNama_agenda());
        holder.tvKeterangan.setText(agenda.getKeterangan());
//        holder.ivNotebook.setImageDrawable(myContext.getResources().getDrawable(product.getImage()));


        Glide.with(myContext)
                .load(Url.DOMAIN_URL + "img/" + agenda.getGambar())
                .apply(new RequestOptions().centerCrop())
                .into(holder.ivAgenda);
    }

    @Override
    public int getItemCount() {
        return agendalist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaAgenda, tvKeterangan;
        ImageView ivAgenda;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            tvNamaAgenda = itemView.findViewById(R.id.tvNamaAgenda);
            tvKeterangan = itemView.findViewById(R.id.tvKeterangan);
            ivAgenda = itemView.findViewById(R.id.ivAgenda);

        }

    }

}
