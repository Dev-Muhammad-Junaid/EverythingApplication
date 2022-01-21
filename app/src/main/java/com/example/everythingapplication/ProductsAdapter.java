package com.example.everythingapplication;

import android.media.Image;
import android.util.Log;
import android.view.ViewGroup;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {


    public List<ProductsModel> getProductsModelList() {
        return productsModelList;
    }

    public void setProductsModelList(List<ProductsModel> productsModelList) {
        this.productsModelList = productsModelList;
    }

    public List<ProductsModel> productsModelList;
    public Context context;

    public ProductsAdapter()
    {

    }
    public ProductsAdapter(List<ProductsModel> productsModelList, Context context) {
        this.productsModelList = productsModelList;
        this.context = context;
    }
    @NonNull
    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_view,parent,false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ViewHolder holder, int position) {
        Log.d("CheckData", "onBindViewHolder: "+productsModelList.get(position).getTitle());
        holder.title.setText(productsModelList.get(position).getTitle());
        Glide.with(context).load(productsModelList.get(position).getImage()).into(holder.image);
    }
    @Override
    public int getItemCount() {
        return productsModelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText title;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.product_card_text);
            image = itemView.findViewById(R.id.product_card_image);
        }
    }
}