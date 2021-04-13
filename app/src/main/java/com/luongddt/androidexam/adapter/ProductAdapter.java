package com.luongddt.androidexam.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luongddt.androidexam.R;
import com.luongddt.androidexam.database.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {

    Activity activity;
    List<Product> listProduct;

    public ProductAdapter(Activity activity, List<Product> listProduct) {
        this.activity = activity;
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_product, parent, false);
        ProductHolder holder = new ProductHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductHolder vh = (ProductHolder) holder;
        Product model = listProduct.get(position);
        vh.tvID.setText(model.Id + "");
        vh.tvProduct.setText(model.Name);
        vh.tvQuantity.setText(String.valueOf(model.Quantity));
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder {

        TextView tvProduct, tvID, tvQuantity;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            tvProduct = itemView.findViewById(R.id.tvProductName);
            tvID = itemView.findViewById(R.id.tvID);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
        }
    }
}
