package com.emc.interfacechallenge.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.emc.interfacechallenge.fragments.BasicsFragment;
import com.emc.interfacechallenge.fragments.PhotosFragment;
import com.emc.interfacechallenge.fragments.PreferencesFragment;

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
        fragmentsList.add(BasicsFragment.newInstances());
        fragmentsList.add(PreferencesFragment.newInstances());
        fragmentsList.add(PhotosFragment.newInstance());

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
