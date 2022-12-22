package com.example.reto1_session.Adapters;

import android.content.Context;
import android.content.Intent;
import android.icu.text.IDNA;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reto1_session.Catalog;
import com.example.reto1_session.DB.DBFirebase;
import com.example.reto1_session.Entities.Product;
import com.example.reto1_session.Form;
import com.example.reto1_session.Info;
import com.example.reto1_session.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> arrayProducts;

    public ProductAdapter(Context context, ArrayList<Product> arrayProducts) {
        this.context = context;
        this.arrayProducts = arrayProducts;
    }

    public ArrayList<Product> getArrayProducts() {
        return arrayProducts;
    }

    public void setArrayProducts(ArrayList<Product> arrayProducts) {
        this.arrayProducts = arrayProducts;
    }

    @Override
    public int getCount() {
        return arrayProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.product_template, null);

        //Creo producto igual al que se referencia
        Product product = arrayProducts.get(i);

        //Referenciando elementos de la plantilla (product_template)
        ImageView imgProduct = (ImageView) view.findViewById(R.id.imgProduct);
        TextView textNameProduct = (TextView) view.findViewById(R.id.textNameProduct);
        TextView textDescriptionProduct = (TextView) view.findViewById(R.id.textDescriptionProduct);
        TextView textPriceProduct = (TextView) view.findViewById(R.id.textPriceProduct);
        Button btnEditProduct = (Button) view.findViewById(R.id.btnEditProduct);
        Button btnDeleteProduct = (Button) view.findViewById(R.id.btnDeleteProduct);

        //Pasar los datos que vienen de producto
        imgProduct.setImageResource(R.drawable.rym);
        textNameProduct.setText(product.getName());
        textDescriptionProduct.setText(product.getDescription());
        textPriceProduct.setText(String.valueOf(product.getPrice()));

        btnDeleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBFirebase dbFirebase = new DBFirebase();
                dbFirebase.deleteData(product.getId(), context);
            }
        });

        btnEditProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Form.class);
                //intent.putExtra("image", true);
                intent.putExtra("edit", true);
                intent.putExtra("id", product.getId());
                intent.putExtra("name", product.getName());
                intent.putExtra("description", product.getDescription());
                intent.putExtra("price", product.getPrice());
                intent.putExtra("image", product.getImage());
                intent.putExtra("latitud", product.getLatitud());
                intent.putExtra("longitud", product.getLongitud());
                context.startActivity(intent);
            }
        });

        //Link desde la foto en el catálogo hasta el activity_info de cada producto
        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), Info.class);
                intent.putExtra("image", product.getImage());
                intent.putExtra("name", product.getName());
                intent.putExtra("description", product.getDescription());
                intent.putExtra("price", product.getPrice());
                context.startActivity(intent);
            }
        });

        return view;
    }
}
