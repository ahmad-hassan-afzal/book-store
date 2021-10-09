package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Checkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        double total = 0.0;
        String titles = "";
        String prices = "";

        for (BookOrderItem i:BookDetails.cart ) {
            titles += i.getTitle()+"\n";
            prices += i.getQuantity()+" x "+i.getPrice()+"\n";
            total += i.getPrice()*i.getQuantity();
        }
        if (titles == "") titles = "Cart is Empty";
        TextView txtTitles = findViewById(R.id.txt_order_titles);
        TextView txtPrices = findViewById(R.id.txt_order_prices);
        TextView txtTotal = findViewById(R.id.txt_order_total);

        txtTitles.setText(titles);
        txtPrices.setText(prices);
        txtTotal.setText("$" + new DecimalFormat("###.##").format(total));

    }
}