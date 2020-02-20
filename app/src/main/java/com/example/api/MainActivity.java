package com.example.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView title, sub_title, error;
    private ImageView imageView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.textViewTitle);
        sub_title = findViewById(R.id.textViewSubTitle);
        error = findViewById(R.id.textViewError);
        imageView = findViewById(R.id.imageView);

        getGet();
    }

    private void getGet() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.mocky.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Inquiries inquiries = retrofit.create(Inquiries.class);

        Call<List<Get>> call = inquiries.getMessage();

        call.enqueue(new Callback<List<Get>>() {
            @Override
            public void onResponse(Call<List<Get>> call, Response<List<Get>> response) {

                if (!response.isSuccessful()){
                    error.setText("Code: " + response.code());
                    return;
                }

                url = response.body().get(0).getUrl();
                title.setText(response.body().get(0).getUrl());
                sub_title.setText(response.body().get(0).getSub_title());
                Glide.with(MainActivity.this).load(url).into(imageView);

            }

            @Override
            public void onFailure(Call<List<Get>> call, Throwable t) {
                error.setText("Error: " + t.getMessage());
            }
        });
    }
}
