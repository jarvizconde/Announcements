package com.example.jarviz.announcements;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;
    private List<Announcements> announcements;
    private ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*recyclerView = (RecyclerView)findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = Api_Client.getApiClient().create(ApiInterface.class);
        Call<List<Announcements>> call = apiInterface.getAnnouncements();


        call.enqueue(new Callback<List<Announcements>>() {
            @Override
            public void onResponse(Call<List<Announcements>> call, Response<List<Announcements>> response) {


                announcements = response.body();
                recyclerAdapter =  new RecyclerAdapter(announcements);
                recyclerView.setAdapter(recyclerAdapter);

            }

            @Override
            public void onFailure(Call<List<Announcements>> call, Throwable t) {

            }
        });*/
        ListFragment fragment = new ListFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, fragment);
        fragmentTransaction.commit();
    }
}
