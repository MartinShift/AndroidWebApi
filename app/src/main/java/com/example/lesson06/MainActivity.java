package com.example.lesson06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class MainActivity extends AppCompatActivity {
        private RecyclerView rvNumbers;
        private List<User> users = new ArrayList<>();
        private NumberAdapter adapter;
        private Api api;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            api = NetworkService.getInstance().getApi();

            rvNumbers = findViewById(R.id.rvNumbers);

            adapter = new NumberAdapter(
                    this,
                    R.layout.item_list,
                    users
            );
            rvNumbers.setAdapter(adapter);
            LinearLayoutManager manager = new LinearLayoutManager(
                    this,
                    RecyclerView.VERTICAL,
                    false
            );
            rvNumbers.setLayoutManager(manager);

            requestAllUsers();
        }

        private void requestAllUsers() {
            Call<List<User>> call = api.getAllUsers();
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        users.clear();
                         users.addAll(response.body());
                        users.forEach(user -> user.parseName());

                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                }
            });
        }
    }