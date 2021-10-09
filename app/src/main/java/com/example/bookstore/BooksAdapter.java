package com.example.bookstore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private String[] bookTitles;
    private double[] bookPrices;
    private int[] bookCovers;

    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTitle;
        private final TextView textViewPrice;
        private final ImageView imageViewCover;

        private final Button buttonView;


        public ViewHolder(View view) {
            super(view);

            textViewTitle = (TextView) view.findViewById(R.id.tv_book_title);
            textViewPrice = (TextView) view.findViewById(R.id.tv_price);
            imageViewCover = (ImageView) view.findViewById(R.id.img_book_cover);
            buttonView = (Button) view.findViewById(R.id.btn_view);

        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }
        public TextView getTextViewPrice() {
            return textViewPrice;
        }
        public ImageView getImageViewCover() {
            return imageViewCover;
        }
        public Button getButtonView() {
            return buttonView;
        }
    }
    public BooksAdapter(Context ctx, String[] titles, double[] prices, int[] covers) {
        bookTitles = titles;
        bookPrices = prices;
        bookCovers = covers;

        context = ctx;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.book_rv, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextViewTitle().setText(bookTitles[position]);
        viewHolder.getTextViewPrice().setText("$"+bookPrices[position]);
        viewHolder.getImageViewCover().setImageResource(bookCovers[position]);

        viewHolder.buttonView.setOnClickListener(v -> {
            Intent intent = new Intent(context, BookDetails.class);

            Bundle data = new Bundle();
            data.putString("title", bookTitles[position]);
            data.putDouble("price", bookPrices[position]);
            data.putInt("cover", bookCovers[position]);

            intent.putExtras(data);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return bookTitles.length;
    }
}
