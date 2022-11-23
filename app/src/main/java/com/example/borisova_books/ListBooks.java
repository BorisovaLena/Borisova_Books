package com.example.borisova_books;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListBooks extends AppCompatActivity {

    Connection connection;
    List<Book> data;
    View v;
    ListView listView;
    Adapter pAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);
        v = findViewById(com.google.android.material.R.id.ghost_view);
        GetTextFormSql(v);
    }

    public void GetTextFormSql(View v)
    {
        data = new ArrayList<Book>();
        listView = findViewById(R.id.BD_Books);
        pAdapter = new Adapter(ListBooks.this, data);
        try
        {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if(connection!=null)
            {
                String query = "Select * From Products";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
            }
        }
        catch ()
        {

        }
    }

}