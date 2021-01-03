package com.example.rxjavaproject.data;

import com.example.rxjavaproject.pojo.PostModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {

    @GET("posts")
    public Observable<List<PostModel>> getPosts();
}
