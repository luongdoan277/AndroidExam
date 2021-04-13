package com.luongddt.androidexam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luongddt.androidexam.adapter.ProductAdapter;
import com.luongddt.androidexam.database.AppDatabase;
import com.luongddt.androidexam.database.Product;

import java.util.List;

public class ListProductActivity extends AppCompatActivity {
    RecyclerView rvProduct;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        db = AppDatabase.getAppDatabase(this);
        List<Product> list = db.productDao().getAllProduct();

        ProductAdapter adapter = new ProductAdapter(this, list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rvProduct = findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);

    }
}
