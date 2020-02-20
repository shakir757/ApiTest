package com.example.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Inquiries {

    @GET("5e4e37872f00006c0016a47b")
    Call<List<Get>> getMessage();
}
