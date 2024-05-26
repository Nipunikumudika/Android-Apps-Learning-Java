package com.nipuni.apihandling.network;


import com.nipuni.apihandling.models.PostBody;
import com.nipuni.apihandling.models.PostResponse;
import com.nipuni.apihandling.models.UserData;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @GET("users")
    Call<UserData> getUser();

    @POST("users")
    Call<PostResponse> createUser(@Body PostBody postBody);
}

