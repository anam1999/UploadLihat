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

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.ViewHolder> {

    private Context myContext;
    private ArrayList<Feedback> feedbacklist;
    public FeedbackAdapter(Context myContext, ArrayList<Feedback> feedbacklist) {
        this.myContext = myContext;
        this.feedbacklist = feedbacklist;
    }

    @NonNull
    @Override
    public FeedbackAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(myContext).inflate(R.layout.list_komentar,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackAdapter.ViewHolder holder, int position) {
        Feedback feedback = feedbacklist.get(position);
        holder.tvNama.setText(feedback.getNama());
        holder.tvKomentar.setText(feedback.getKomentar());
//        holder.ivNotebook.setImageDrawable(myContext.getResources().getDrawable(product.getImage()));


        Glide.with(myContext)
                .load(UrlFeedback.DOMAIN_URL + "img/" + feedback.getGambar())
                .apply(new RequestOptions().centerCrop())
                .into(holder.ivFeedback);
    }

    @Override
    public int getItemCount() {
        return feedbacklist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvKomentar;
        ImageView ivFeedback;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvKomentar = itemView.findViewById(R.id.tvKomentar);
            ivFeedback = itemView.findViewById(R.id.ivFeedback);

        }

    }

}

