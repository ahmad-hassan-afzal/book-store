package com.example.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BookDetails extends AppCompatActivity {

    public static ArrayList<BookOrderItem> cart = new ArrayList<BookOrderItem>();
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        count = 1;

        EditText edtQuantity = findViewById(R.id.edit_qty);

        Bundle data = getIntent().getExtras();

        String title = data.getString("title");
        double price = data.getDouble("price");
        int cover = data.getInt("cover");

        TextView txtTitle = findViewById(R.id.txt_view_title);
        txtTitle.setText(title);
        TextView txtPrice = findViewById(R.id.txt_view_price);
        txtPrice.setText("$"+price);
        ImageView imgCover = findViewById(R.id.img_view_cover);
        imgCover.setImageResource(cover);

        findViewById(R.id.btn_qty_plus).setOnClickListener(v -> {
            if(count > 0) count++;
            edtQuantity.setText(""+count);
        });
        findViewById(R.id.btn_qty_minus).setOnClickListener(v -> {
            if(count >= 2) count--;
            edtQuantity.setText(""+count);
        });

        findViewById(R.id.btn_checkout).setOnClickListener(v -> {
            Intent intent = new Intent(this, Checkout.class);

            startActivity(intent);
        });
        findViewById(R.id.btn_go_back).setOnClickListener(v -> {
            this.onBackPressed();
        });
        findViewById(R.id.btn_add_to_cart).setOnClickListener(v -> {
            int quantity = Integer.parseInt(edtQuantity.getText().toString());
            cart.add(new BookOrderItem(title, price, quantity));
            new Toast(this).makeText(this, title+" - Added to cart", Toast.LENGTH_SHORT).show();
        });

    }
}