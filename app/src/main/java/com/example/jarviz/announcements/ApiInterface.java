package com.example.jarviz.announcements;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers("Authorization: Bearer zYQMvm69hrZKW9kWnKs3JZEWSXPzMxsr3h5Z7bK09Ttb8VvwDT6Jl3gkrqM0")
    @GET("announcements")
    Call<List<Announcements>> getAnnouncements ();

}
