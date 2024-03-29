package com.doublehammerstudio.predepest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class pesticide_schedule extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pesticide_schedule, container, false);
        schedInitializingAnimations(view);
        return view;
    }

    private void schedInitializingAnimations(View view){
        Animation animationSlideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up_anim);
        LinearLayout linearLayout = view.findViewById(R.id.sched_main_bar);
        linearLayout.startAnimation(animationSlideUp);

        animationSlideUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }
}