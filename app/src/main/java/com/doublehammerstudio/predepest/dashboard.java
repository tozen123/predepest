package com.doublehammerstudio.predepest;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class dashboard extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        dashboardInitializingAnimations(view);

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