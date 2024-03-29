package com.doublehammerstudio.predepest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class pest_information extends Fragment {

    private EditText editTextSearch;
    private RecyclerView recyclerViewSearchResults;
    PestInformationAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pest_information, container, false);

        editTextSearch = view.findViewById(R.id.search_edit_txt);
        recyclerViewSearchResults = view.findViewById(R.id.recyclerViewSearchResults);

        List<String> dataTitleList = getTitleData();
        List<Integer> dataImageList = getImageData();

        adapter = new PestInformationAdapter(dataTitleList, dataImageList);
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
        data.add(R.drawable.ic_launcher_background);
        data.add(R.drawable.ic_launcher_background);
        data.add(R.drawable.ic_launcher_background);
        data.add(R.drawable.ic_launcher_background);
        data.add(R.drawable.ic_launcher_background);
        data.add(R.drawable.ic_launcher_background);

        return data;
    }
    private List<String> getTitleData() {
        List<String> data = new ArrayList<>();
        data.add("Apple");
        data.add("Banana");
        data.add("Orange");
        data.add("Pineapple");
        data.add("Watermelon");
        data.add("Grapes");
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