package com.example.clothesstore;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertSetUp();
            }
        });
        setUpData();
    }


    private void setUpData() {
        textViewResult = findViewById(R.id.aa);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://private-anon-17d91b1bdb-ddshop.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonHolder jsonPlaceHolderApi = retrofit.create(JsonHolder.class);

        Call<List<RetrofitCore>> call = jsonPlaceHolderApi.getAllProducts();

        call.enqueue(new Callback<List<RetrofitCore>>() {
            @Override
            public void onResponse(Call<List<RetrofitCore>> call, Response<List<RetrofitCore>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<RetrofitCore> posts = response.body();
                for (RetrofitCore post : posts) {
                    String content = "";
                    content += "ID: " + post.getProductId() + "\n";
                    content += "Name: " + post.getName() + "\n";
                    content += "Category: " + post.getCategory() + "\n";
                    content += "Price: " + post.getPrice() + "\n";
                    content += "Old Price: " + post.getOldPrice() + "\n";
                    content += "Stock: " + post.getStock() + "\n\n";


                    textViewResult.append(content);
                }
            }
            @Override
            public void onFailure(Call<List<RetrofitCore>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }


    private void alertSetUp(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText edittext = new EditText(this);
        alert.setMessage("Enter the id below");
        alert.setTitle("Shopping cart");
        alert.setView(edittext);
        alert.setPositiveButton("Add to cart", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://private-anon-17d91b1bdb-ddshop.apiary-mock.com/cart/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                JsonHolder jsonPlaceHolderApi = retrofit.create(JsonHolder.class);
               Call<List<RetrofitCore>> call = jsonPlaceHolderApi.addProductToCart(Integer.parseInt(edittext.getText().toString()));

                call.enqueue(new Callback<List<RetrofitCore>>() {
                    @Override
                    public void onResponse(Call<List<RetrofitCore>> call, Response<List<RetrofitCore>> response) {

                        if (!response.isSuccessful()) {
                            textViewResult.setText("Code: " + response.code());
                            return;
                        }
                        Toast t = Toast.makeText(getApplicationContext(),"h",Toast.LENGTH_SHORT);
                        t.show();

                    }
                    @Override
                    public void onFailure(Call<List<RetrofitCore>> call, Throwable t) {
                        textViewResult.setText(t.getMessage());
                    }
                });
            }
                    });
                alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
