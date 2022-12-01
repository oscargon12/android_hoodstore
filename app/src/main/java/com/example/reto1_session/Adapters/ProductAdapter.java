package com.example.reto1_session.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reto1_session.Entidades.Product;
import com.example.reto1_session.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> productArrayList;

    public ProductAdapter(Context context, ArrayList<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }

    @Override
    public int getCount() {
        return productArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return productArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.product_template, null);

        Product product = productArrayList.get(i);

        //Referenciando elementos de la plantilla
        ImageView imgProduct = (ImageView) view.findViewById(R.id.imgProduct);
        TextView productName = (TextView) view.findViewById(R.id.productName);
        TextView productPrice = (TextView) view.findViewById(R.id.productPrice);
        Button productBtn = (Button) view.findViewById(R.id.productBtn);

        //Pasar los datos que vienen de producto
        imgProduct.setImageResource(product.getImage());
        productName.setText(product.getName());
        productPrice.setText(String.valueOf(product.getPrice()));

        return view;
    }
}
