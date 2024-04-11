package com.doublehammerstudio.predepest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class pest_information extends Fragment {

    private EditText editTextSearch;
    private RecyclerView recyclerViewSearchResults;
    PestInformationAdapter adapter;

    List<String> dataTitleList;
    List<Integer> dataImageList ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pest_information, container, false);

        editTextSearch = view.findViewById(R.id.search_edit_txt);
        recyclerViewSearchResults = view.findViewById(R.id.recyclerViewSearchResults);

        dataTitleList = getTitleData();
        dataImageList = getImageData();

        adapter = new PestInformationAdapter(getContext(), dataTitleList, dataImageList);
        recyclerViewSearchResults.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerViewSearchResults.setAdapter(adapter);
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        pestInfoInitializingAnimations(view);

        return view;
    }


    private List<Integer> getImageData() {
        List<Integer> data = new ArrayList<>();
        data.add(R.drawable.a);
        data.add(R.drawable.b);
        data.add(R.drawable.c);
        data.add(R.drawable.d);
        data.add(R.drawable.e);
        data.add(R.drawable.f);
        data.add(R.drawable.g);
        data.add(R.drawable.h);
        data.add(R.drawable.i);
        data.add(R.drawable.j);
        data.add(R.drawable.k);
        data.add(R.drawable.l);
        data.add(R.drawable.m);
        data.add(R.drawable.n);
        data.add(R.drawable.o);
        data.add(R.drawable.p);
        data.add(R.drawable.q);
        data.add(R.drawable.r);
        data.add(R.drawable.s);
        data.add(R.drawable.t);
        data.add(R.drawable.v);
        data.add(R.drawable.w);
        data.add(R.drawable.x);
        data.add(R.drawable.y);
        data.add(R.drawable.z);
        data.add(R.drawable.aa);
        data.add(R.drawable.bb);
        data.add(R.drawable.cc);
        data.add(R.drawable.dd);

        return data;
    }
    private List<String> getTitleData() {
        List<String> data = new ArrayList<>();
        data.add("Mole Crickets");
        data.add("Root Aphids");
        data.add("Root Weevils");
        data.add("Greenhorned Caterpillars");
        data.add("Rice Skippers");
        data.add("Planthoppers");
        data.add("Rice Leaffolder");
        data.add("Rice Stem Borers");
        data.add("Stalked-eyed Flies");
        data.add("Seedling Maggots");
        data.add("Rice Whorl Maggots");
        data.add("Rice Caseworms");
        data.add("Armyworms and Cutworms");
        data.add("Grasshoppers, Katydids, and Field Crickets");
        data.add("Black Bugs");
        data.add("Rice Hispa");
        data.add("Mealybugs");
        data.add("Ripening Seed Bugs");
        data.add("Stink Bugs");
        data.add("Ants");
        data.add("Rice Green Semilooper");
        data.add("Rice Thrips");
        data.add("Rice Leaf Beatles");
        data.add("Wireworms");
        data.add("Root-Feeding Mealybugs");
        data.add("Leafhoppers");
        data.add("Termites");
        data.add("White Grubs");
        data.add("Field Crickets");
        return data;
    }
    private void pestInfoInitializingAnimations(View view){
        Animation animationSlideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up_anim);
        LinearLayout linearLayout = view.findViewById(R.id.pest_main_bar);
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