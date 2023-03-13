package com.example.sample.api;

import com.example.sample.model.*;
import org.springframework.web.servlet.function.ServerResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiClient {
    @GET("account")
    public Call<StudentAccount> getAccount();

    @GET("grades")
    public Call<StudentGrade> getGrades() ;

    @GET("address")
    public Call<StudentAddress> getAddress();

    @GET("admin")
    public Call<Users> getAdmin();

    @GET("user")
    public Call<Users> getUsers();


        static ApiClient create(String base_url){
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(base_url)
                    .build();
            return retrofit.create(ApiClient.class);
        }
    }

