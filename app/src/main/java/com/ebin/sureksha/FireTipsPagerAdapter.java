package com.ebin.sureksha;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

public class FireTipsPagerAdapter extends FragmentPagerAdapter {
    private final int numOfTabs;

    public FireTipsPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.numOfTabs = numOfTabs;
    }

    @NotNull
    @Override
    public Fragment getItem(int position) {
        return FireTipsTabsFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

}
