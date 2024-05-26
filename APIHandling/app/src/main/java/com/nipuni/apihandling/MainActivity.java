package com.nipuni.apihandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.nipuni.apihandling.models.PostBody;
import com.nipuni.apihandling.models.PostResponse;
import com.nipuni.apihandling.models.UserData;
import com.nipuni.apihandling.models.UserDataList;
import com.nipuni.apihandling.network.APIInterface;
import com.nipuni.apihandling.network.RestAPIClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private APIInterface service;
    private RestAPIClient client;
    private String base_url;
    private ArrayList<UserDataList> userDataLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        base_url = "https://reqres.in/api/";
        client = new RestAPIClient(base_url);
        service = client.buildApi();

        /*Call<UserData> call=service.getUser();
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                userDataLists = response.body().getUserDataLists();
                Log.d("TAG","onResponse:"+userDataLists);

            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {


            }
        });*/

        PostBody postBody = new PostBody("Kamal","SSE");
        Call<PostResponse> callPost = service.createUser(postBody);
        callPost.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if(response.isSuccessful()){
                    //code200
                    Log.d("TAG","onResponse:"+response);
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {

            }
        });
    }
}