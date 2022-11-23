package com.example.borisova_books;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.List;

public class Adapter extends BaseAdapter{

    protected Context Context;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {mListener=listener;}

    public Adapter(Context Context, List<Book> bookList) {
        this.Context = Context;
        this.bookList = bookList;
    }
    List<Book> bookList;

    @Override
    public int getCount() {return bookList.size();}

    @Override
    public Object getItem(int i) {return bookList.get(i);}

    @Override
    public long getItemId(int i) {return bookList.get(i).getIdBook();}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint("ViewHolder") View v = View.inflate(Context,R.layout.item_book,null);

        TextView TitleBook = v.findViewById(R.id.TitleBook);
        TextView Author = v.findViewById(R.id.Author);
        TextView GenresBook = v.findViewById(R.id.GenresBook);


        return null;
    }


}
