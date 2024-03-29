package com.doublehammerstudio.predepest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DataMain extends Fragment implements DataDensityAdapter.ItemClickListener {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_data_main, container, false);


        String sTitle=getArguments().getString("title");

        switch (sTitle){
            case "LIST":
                listMode(view);
                break;
            case "CHART":
                chartMode(view);
                break;
        }



        return view;
    }
    private void listMode(View view){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerDataDensity);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<DataDensityModel> data = new ArrayList<>();

        data.add(new DataDensityModel("HIGH", "January 1, 2024 2:00 AM "));
        data.add(new DataDensityModel("HIGH", "January 1, 2024 2:00 AM "));
        data.add(new DataDensityModel("HIGH", "January 2, 2024 2:00 AM "));
        data.add(new DataDensityModel("HIGH", "January 4, 2024 2:00 AM "));
        DataDensityAdapter adapter = new DataDensityAdapter(data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClick(View view, int position) {
        DataDensityBottomSheetFragment bottomSheetFragment = new DataDensityBottomSheetFragment();
        bottomSheetFragment.show(requireActivity().getSupportFragmentManager(), bottomSheetFragment.getTag());


    }
    private void chartMode(View view){

    }
}