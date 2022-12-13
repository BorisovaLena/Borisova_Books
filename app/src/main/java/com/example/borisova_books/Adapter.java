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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.List;

public class Adapter extends BaseAdapter{

    protected Context Context;
    List<Book> bookList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {mListener=listener;}

    public Adapter(Context Context, List<Book> bookList) {
        this.Context = Context;
        this.bookList = bookList;
    }

    @Override
    public int getCount() {return bookList.size();}

    @Override
    public Object getItem(int i) {return bookList.get(i);}

    @Override
    public long getItemId(int i) {return bookList.get(i).getIdBook();}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint("ViewHolder") View v = View.inflate(Context, R.layout.item_book,null);

        TextView TitleBook = v.findViewById(R.id.tv_TitleBook);
        TextView Author = v.findViewById(R.id.tv_Author);
        TextView GenresBook = v.findViewById(R.id.tv_GenresBook);
        ImageView Image =  v.findViewById(R.id.Img);

        Book book = bookList.get(position);
        TitleBook.setText(book.getTitleBook());
        Author.setText(book.getAuthor());
        GenresBook.setText(book.getGenre());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Context,PageBook.class);
                intent.putExtra("Books",book);
                Context.startActivity(intent);
            }
        });
        return v;
    }

    public Bitmap getUserImage(String encodedImg)
    {
        if(encodedImg!=null && !encodedImg.equals("null")) {
            byte[] bytes = Base64.decode(encodedImg, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        else
            return BitmapFactory.decodeResource(Context.getResources(), R.drawable.icon);
    }

    


}
