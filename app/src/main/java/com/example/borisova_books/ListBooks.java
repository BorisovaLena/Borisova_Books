package com.example.borisova_books;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListBooks extends AppCompatActivity {

    Connection connection;
    List<Book> data;
    View v;
    ListView listView;
    AdapterBook pAdapter;

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
        pAdapter = new AdapterBook(ListBooks.this, data);
        try
        {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.connectionClass();
            if(connection!=null)
            {
                String query = "Select * From Books";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next())
                {
                    Book book = new Book(
                            resultSet.getInt("IdBook"),
                            resultSet.getString("TitleBook"),
                            resultSet.getString("Annitation"),
                            resultSet.getString("Summary"),
                            resultSet.getString("Image"),
                            resultSet.getString("Author"),
                            resultSet.getString("Genre"),
                            resultSet.getString("Link")
                    );
                    data.add(book);
                    pAdapter.notifyDataSetInvalidated();
                }
                connection.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        pAdapter.notifyDataSetInvalidated();
        listView.setAdapter(pAdapter);
    }

}