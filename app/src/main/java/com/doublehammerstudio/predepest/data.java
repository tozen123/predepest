package com.doublehammerstudio.predepest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.doublehammerstudio.predepest.DataMain;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class data extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        dataInitializingAnimations(view);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        ViewPager viewPager = view.findViewById(R.id.view_pager);


        ArrayList<String> arrayList=new ArrayList<>(0);


        arrayList.add("LIST");
        arrayList.add("CHART");


        tabLayout.setupWithViewPager(viewPager);


        prepareViewPager(viewPager, arrayList);



        return view;
    }

    private void prepareViewPager(ViewPager viewPager, ArrayList<String> arrayList) {

        MainAdapter adapter=new MainAdapter(getChildFragmentManager());


        DataMain mainFragment=new DataMain();


        for(int i=0;i<arrayList.size();i++)
        {

            Bundle bundle=new Bundle();


            bundle.putString("title",arrayList.get(i));


            mainFragment.setArguments(bundle);


            adapter.addFragment(mainFragment,arrayList.get(i));
            mainFragment=new DataMain();
        }

        viewPager.setAdapter(adapter);
    }

    private class MainAdapter extends FragmentPagerAdapter {

        ArrayList<Fragment> fragmentArrayList= new ArrayList<>();
        ArrayList<String> stringArrayList=new ArrayList<>();


        public void addFragment(Fragment fragment,String s)
        {

            fragmentArrayList.add(fragment);

            stringArrayList.add(s);
        }

        public MainAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {

            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            SpannableString spannableString=new SpannableString(""+stringArrayList.get(position));
            return spannableString;
        }
    }

    private void dataInitializingAnimations(View view){
        Animation animationSlideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up_anim);
        LinearLayout linearLayout = view.findViewById(R.id.list_bar);
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
