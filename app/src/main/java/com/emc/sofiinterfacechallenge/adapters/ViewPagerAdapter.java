package com.emc.sofiinterfacechallenge.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.emc.sofiinterfacechallenge.fragments.Basics;
import com.emc.sofiinterfacechallenge.fragments.Photos;
import com.emc.sofiinterfacechallenge.fragments.Preferences;

import java.util.ArrayList;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    private ArrayList<Fragment> fragmentsList = new ArrayList<>();

    Context context;

	public ViewPagerAdapter(FragmentManager fm, Context context) {
		super(fm);
        this.context = context;
        initializeFragments();
	}

    private void initializeFragments()
    {
        fragmentsList.add(Basics.newInstances());
        fragmentsList.add(Preferences.newInstances());
        fragmentsList.add(Photos.newInstance());

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

	@Override
	public int getCount() {
		return fragmentsList.size();
	}

}
