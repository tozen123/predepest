package com.doublehammerstudio.predepest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class DataDensityBottomSheetFragment extends BottomSheetDialogFragment {
    DataDensityModel dataDensityModel;

    private TextView dateLbl, densityLbl, humidityLbl, tempLbl, precipLbl;

    public static DataDensityBottomSheetFragment newInstance(DataDensityModel model) {
        DataDensityBottomSheetFragment fragment = new DataDensityBottomSheetFragment();
        fragment.dataDensityModel = model;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.data_density_bottom_sheet_layout, container, false);

        dateLbl = view.findViewById(R.id.date);
        densityLbl = view.findViewById(R.id.densityLbl);
        humidityLbl = view.findViewById(R.id.humidityLbl);
        tempLbl = view.findViewById(R.id.tempLbl);
        precipLbl = view.findViewById(R.id.precipitationLbl);

        dateLbl.setText(dataDensityModel.getDateLabel());
        densityLbl.setText(dataDensityModel.getDensityLabel());
        humidityLbl.setText(dataDensityModel.getHumidityLabel());
        tempLbl.setText(String.format("%s °C", dataDensityModel.getTemperatureLabel()));
        precipLbl.setText(dataDensityModel.getPrecipitationLabel());


        Button closeButtonSheet;
        closeButtonSheet = view.findViewById(R.id.closeSheet);
        closeButtonSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return view;
    }


}