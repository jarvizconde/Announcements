package com.example.jarviz.announcements;

import android.content.Context;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AnnouncementFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter recyclerAdapter;
    private List<Announcements> announcements;
    private ApiInterface apiInterface;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_announcement, container, false);


        recyclerView = (RecyclerView) v.findViewById(R.id.RecyclerView);
        recyclerAdapter = new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        getData();

        return v;
    }

    public void getData(){
        apiInterface = Api_Client.getApiClient().create(ApiInterface.class);
        Call<List<Announcements>> call = apiInterface.getAnnouncements();
        call.enqueue(new Callback<List<Announcements>>() {
            @Override
            public void onResponse(Call<List<Announcements>> call, Response<List<Announcements>> response) {

                recyclerAdapter = new RecyclerAdapter(announcements);
                recyclerView.setAdapter(recyclerAdapter);
                announcements = response.body();


            }

            @Override
            public void onFailure(Call<List<Announcements>> call, Throwable t) {

            }
        });
    }

}
