package com.example.lesson06;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("/posts")
    Call<List<Post>> getAllPosts();
    @GET("/users")
    Call<List<User>> getAllUsers();
    @GET("/posts/{id}")
    Call<Post> getPostById(@Path("id") int postId);

    @GET("/users/{id}")
    Call<User> getUserById(@Path("id") int userId);
}
