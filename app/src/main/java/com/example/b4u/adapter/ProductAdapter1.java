package com.example.b4u.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b4u.Product_details;
import com.example.b4u.R;
import com.example.b4u.model.Product;

import java.util.List;

public class ProductAdapter1 extends RecyclerView.Adapter<ProductAdapter1.ProductViewHolder1> {

    Context context;
    List<Product> productList;

    public ProductAdapter1(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_viewed_items1,parent,false);
        return new ProductViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder1 holder, int position) {
        holder.name.setText(productList.get(position).getName());
        holder.description.setText(productList.get(position).getDescription());
        holder.price.setText(productList.get(position).getPrice());
        holder.pricebf.setText(productList.get(position).getPrice_before());
        holder.rate.setText(productList.get(position).getRate());
        holder.img.setImageResource(productList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Product_details.class);

                i.putExtra("name", productList.get(position).getName());
                i.putExtra("description", productList.get(position).getDescription());
                i.putExtra("price", productList.get(position).getPrice());
                i.putExtra("pricebf", productList.get(position).getPrice_before());
                i.putExtra("rate", productList.get(position).getRate());
                i.putExtra("image",productList.get(position).getBigimageurl());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder1 extends RecyclerView.ViewHolder{
        TextView name,description, price, pricebf, rate;
        ImageView img;
        public ProductViewHolder1(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.product_name);
            description = itemView.findViewById(R.id.product_description);
            price = itemView.findViewById(R.id.price);
            pricebf = itemView.findViewById(R.id.price_before);
            rate = itemView.findViewById(R.id.rate);
            img = itemView.findViewById(R.id.img);

        }
    }
}
