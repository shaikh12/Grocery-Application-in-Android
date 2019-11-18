package com.infodart.salman.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> Fragment = new ArrayList<>();
    private  List<String> NamePage = new ArrayList<>();

    public FragmentAdapter(FragmentManager manager){
        super(manager);
    }

    public void add(Fragment frag,String Title){
        Fragment.add(frag);
        NamePage.add(Title);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return Fragment.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return NamePage.get(position);
    }

    @Override
    public int getCount() {
        return 5;
    }
}
