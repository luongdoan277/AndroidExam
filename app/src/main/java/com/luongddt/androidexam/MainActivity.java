package com.luongddt.androidexam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.luongddt.androidexam.database.AppDatabase;
import com.luongddt.androidexam.database.Product;

public abstract class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    EditText edProduct, edQty;
    Button btAdd;
    Button btView;
    AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);
        edProduct = findViewById(R.id.edProduct);
        edQty = findViewById(R.id.edQty);
        btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(this);
        btView = findViewById(R.id.btView);
        btView.setOnClickListener(this);
    }
    private void onAdd() {
        if (!validate()) {
            return;
        }
        Product product = new Product();
        product.Name = edProduct.getText().toString();
        product.Quantity = Integer.parseInt(edQty.getText().toString());
        long id = db.productDao().insertProduct(product);
        if (id > 0) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }
    }
    private void goToListProduct() {
        Intent intent = new Intent(this, ListProductActivity.class);
        startActivity(intent);
    }
    private boolean validate() {
        String mes = null;
        if (edProduct.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập sản phẩm";
        }else if (edQty.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập số lương";
        }
        if (mes != null) {
            Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btAdd:
                onAdd();
                break;
            case R.id.btView:
                goToListProduct();
                break;
            default:
                break;
        }
    }
}