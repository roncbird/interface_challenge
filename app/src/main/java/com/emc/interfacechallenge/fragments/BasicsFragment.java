package com.emc.interfacechallenge.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emc.interfacechallenge.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicsFragment extends Fragment
{


    public BasicsFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basics, container, false);
    }

    public static BasicsFragment newInstances()
    {
        return new BasicsFragment();
    }

}
