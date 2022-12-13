package com.example.borisova_books;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterBook extends BaseAdapter {

    protected Context Context;
    private OnItemClickListener mListener;
    List<Book> listBook;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {mListener=listener;}
    
    public AdapterBook(Context Context, List<Book> listBook) {
        this.Context = Context;
        this.listBook = listBook;
    }

    @Override
    public int getCount() {
        return listBook.size();
    }

    @Override
    public Object getItem(int i) {
        return listBook.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listBook.get(i).getIdBook();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View v = View.inflate(Context,R.layout.item_book,null);

        TextView TitleBook = v.findViewById(R.id.tv_TitleBook);
        TextView Author = v.findViewById(R.id.tv_Author);
        TextView GenresBook = v.findViewById(R.id.tv_GenresBook);
        ImageView Image = v.findViewById(R.id.Img);


        Book book = listBook.get(position);

        

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Context,PageBook.class);
                intent.putExtra("Products",book);
                Context.startActivity(intent);
            }
        });
        return v;
    }
}
