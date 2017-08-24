package com.emc.sofiinterfacechallenge.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emc.sofiinterfacechallenge.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Basics extends Fragment
{


    public Basics()
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

    public static Basics newInstances()
    {
        return new Basics();
    }

}