package com.example.chatplus.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import java.util.ArrayList;

public class FragmentsAdapters extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentaArrayList = new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();

    public FragmentsAdapters(@NonNull FragmentManager fm, int behavior) {
        super(fm , behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentaArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentaArrayList.size();
    }

    public void addFragment(Fragment fragment,String title){

        fragmentaArrayList.add(fragment);
        fragmentTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}

