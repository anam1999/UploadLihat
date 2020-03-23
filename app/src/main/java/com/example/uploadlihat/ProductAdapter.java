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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context myContext;
    private ArrayList<Product> productslist;

    public ProductAdapter(Context myContext, ArrayList<Product> productslist) {
        this.myContext = myContext;
        this.productslist = productslist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(myContext).inflate(R.layout.list_item,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Product product = productslist.get(position);

        holder.tvJudul.setText(product.getTitle());
        holder.tvSpek.setText(product.getspek());
        holder.tvHarga.setText(String.valueOf(product.getPrice()));
        holder.tvRating.setText(String.valueOf(product.getRating()));
//        holder.ivNotebook.setImageDrawable(myContext.getResources().getDrawable(product.getImage()));


        Glide.with(myContext)
                .load(UrlPath.DOMAIN_URL + "img/" + product.getImage())
                .apply(new RequestOptions().centerCrop())
                .into(holder.ivNotebook);
    }

    @Override
    public int getItemCount() {
        return productslist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvJudul, tvSpek, tvRating, tvHarga;
        ImageView ivNotebook;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvSpek = itemView.findViewById(R.id.tvSpek);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            ivNotebook = itemView.findViewById(R.id.ivNotebook);

        }

    }

}