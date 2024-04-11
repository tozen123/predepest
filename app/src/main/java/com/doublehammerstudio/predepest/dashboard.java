package com.doublehammerstudio.predepest;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class dashboard extends Fragment {


    private TextView densityCount, humidityCount, temperatureCount, percipitationCount, detectedPestCount;

    private DatabaseReference mDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        dashboardInitializingAnimations(view);


        mDatabase = FirebaseDatabase.getInstance().getReference();

        densityCount = view.findViewById(R.id.density_count_txt);
        detectedPestCount = view.findViewById(R.id.detected_pest_count_txt);
        humidityCount = view.findViewById(R.id.humidity_count_txt);
        temperatureCount = view.findViewById(R.id.temperature_count_txt);
        percipitationCount = view.findViewById(R.id.percipitation_count_txt);

        fetchData("densityLevel", densityCount, "");
        fetchData("Humidity", humidityCount, "");
        fetchData("Temperature", temperatureCount, " °C");
        fetchData("Precipitation", percipitationCount, "");
        fetchData("detected_pest_count", detectedPestCount, "");

        Button searchButton = view.findViewById(R.id.about);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InformationDialog.show(getContext(), "About", "PreDePest App\n\n" +
                        "Research Study By: \n\n" +
                        "Aquino, Marc Ceasar G. \n" +
                        "Condes, Ian Angelo A. \n" +
                        "Filio, Steven Carl V.\n" +
                        "Launto, Hashim B.\n" +
                        "Nacion Joymhelyn E.\n" +
                        "Paitan, Nicole Joy T.\n" +
                        "Palmes, Kristine Kyle O.\n" +
                        "Pili, Arabela D.\n" +
                        "Saet, Kalvin Ronn C.\n" +
                        "Samson, Elaine G." +
                        "\n\n" +
                        "App Developed By: Christian Serwelas");
            }
        });

        return view;
    }
    private void fetchData(String path, TextView count, String addOns)
    {

        mDatabase.child(path).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {

                    Object value = snapshot.getValue();


                    if (value instanceof String) {
                        String stringValue = (String) value;
                        count.setText(String.format("%s%s", stringValue, addOns));
                    } else if (value instanceof Number) {

                        Number numberValue = (Number) value;
                        count.setText(String.format("%d%s", numberValue.intValue(), addOns));
                    } else {

                        Toast.makeText(getContext(), "Data is neither String nor Number.", Toast.LENGTH_SHORT).show();
                    }
                } else {

                    Toast.makeText(getContext(), "Data does not exist.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dashboardInitializingAnimations(View view){
        LinearLayout header = view.findViewById(R.id.header);
        header.setVisibility(View.INVISIBLE);


        Animation animationSlideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up_anim);
        LinearLayout linearLayout = view.findViewById(R.id.main_bar);
        linearLayout.startAnimation(animationSlideUp);

        animationSlideUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                header.setVisibility(View.VISIBLE);


                Animation animationFadeIn = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in_animation);
                header.startAnimation(animationFadeIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}