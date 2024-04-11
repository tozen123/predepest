package com.doublehammerstudio.predepest;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class DataMain extends Fragment implements DataDensityAdapter.ItemClickListener{

    List<DataDensityModel> mData = new ArrayList<>();
    private DatabaseReference mDatabase;
    private BarChart barChart;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_data_main, container, false);

        barChart = view.findViewById(R.id.bar_chart);
        recyclerView = view.findViewById(R.id.recyclerDataDensity);


        barChart.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);


        mDatabase = FirebaseDatabase.getInstance().getReference();
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
    public interface OnDataFetchListener {
        void onDataFetched(List<DataDensityModel> data);
    }

    private void listMode(View view) {

        barChart.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fetchPushedData("pushed_density", new OnDataFetchListener() {
            @Override
            public void onDataFetched(List<DataDensityModel> data) {
                DataDensityAdapter adapter = new DataDensityAdapter(data);
                adapter.setClickListener(DataMain.this);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    private void fetchPushedData(String path, OnDataFetchListener listener) {
        List<DataDensityModel> data = new ArrayList<>();



        //db_connection.push_data("/pushed_density", f"{time_handler.get_time()}", f"{densityLabelCount}, {humidity}, {temperature}, {precipitation}")
        mDatabase.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    String key = childSnapshot.getKey();
                    String value = childSnapshot.getValue(String.class);

                    String splitted_density = value.split(",")[0].toString();
                    String splitted_humidity = value.split(",")[1].toString();
                    String splitted_temp = value.split(",")[2].toString();
                    String splitted_pre = value.split(",")[3].toString();
                    String splitted_dpcount = value.split(",")[4].toString();

                    data.add(new DataDensityModel(splitted_density, key, splitted_humidity, splitted_temp, splitted_pre, splitted_dpcount));
                }
                listener.onDataFetched(data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase", "Fetch data cancelled", error.toException());
                listener.onDataFetched(data); // Notify listener with empty list in case of error
            }
        });

        mData = data;
    }


    @Override
    public void onItemClick(View view, int position) {

        List<DataDensityModel> dataList = mData;
        DataDensityModel selectedModel = dataList.get(position);


        DataDensityBottomSheetFragment bottomSheetFragment = DataDensityBottomSheetFragment.newInstance(selectedModel);
        bottomSheetFragment.show(requireActivity().getSupportFragmentManager(), bottomSheetFragment.getTag());
    }
    private void chartMode(View view){
        barChart.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);

        fetchPushedData("pushed_density", new OnDataFetchListener() {
            @Override
            public void onDataFetched(List<DataDensityModel> mData) {
                List<BarEntry> entries = new ArrayList<>();
                List<String> dates = new ArrayList<>(); // Store dates separately for x-axis labels
                for (int i = 0; i < mData.size(); i++) {
                    float dpCount = Float.parseFloat(mData.get(i).getDetectedPestLabel());
                    String date = mData.get(i).getDateLabel();
                    entries.add(new BarEntry(i, dpCount));
                    dates.add(date); // Add date to the list
                }

                // Create a dataset from the data
                BarDataSet dataSet = new BarDataSet(entries, "Density Count");

                // Optional: Customize appearance
                dataSet.setColor(Color.BLUE);

                // Create a BarData object and add the dataset to it
                BarData barData = new BarData(dataSet);

                // Set data to chart
                barChart.setData(barData);

                // Optional: Customize chart appearance and behavior
                barChart.setDrawGridBackground(false);
                barChart.setDrawBarShadow(false);
                barChart.animateY(1000);

                // Customize X-axis
                XAxis xAxis = barChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(dates)); // Set dates as x-axis labels
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // Set x-axis position to bottom
                xAxis.setGranularity(1f); // Set the granularity to 1 to show all labels
                xAxis.setLabelRotationAngle(45f); // Rotate the labels by 45 degrees
                xAxis.setLabelCount(dates.size()); // Set the number of labels to display

                // Customize chart appearance and behavior
                barChart.setDrawGridBackground(false);
                barChart.setDrawBarShadow(false);
                barChart.animateY(1000);

                // Enable zoom
                barChart.setPinchZoom(true);

                // Set an initial zoom level
                barChart.zoom(3f, 3f, 0, 0); // Here, 2f indicates the zoom level (2x), and (1f, 0, 0) indicates the zoom center

                barChart.invalidate();
            }
        });
    }


}