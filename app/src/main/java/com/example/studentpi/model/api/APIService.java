package com.example.studentpi.model.api;


import com.example.studentpi.model.Bean.Response;
import com.example.studentpi.model.Bean.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Sunflower on 2015/11/4.
 */
public interface APIService {
    @FormUrlEncoded
    @POST("/tree/testPost")
    Observable<Response<User>> testPost(@Field("id") String id);



}
