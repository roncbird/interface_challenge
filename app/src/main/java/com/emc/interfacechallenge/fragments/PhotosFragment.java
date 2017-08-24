package com.emc.interfacechallenge.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emc.interfacechallenge.R;
import com.emc.interfacechallenge.utilities.FontCache;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotosFragment extends Fragment
{
    private TextView tv_delete_image_one;
    private TextView tv_delete_image_two;
    private TextView tv_delete_image_three;
    private TextView tv_delete_image_four;
    private TextView tv_delete_image_five;
    private TextView tv_delete_image_six;

    public PhotosFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Typeface fontAwesome = FontCache.get("fontawesome-webfont.ttf", getActivity());

        tv_delete_image_one = (TextView)view.findViewById(R.id.tv_delete_image_one);
        tv_delete_image_one.setTypeface(fontAwesome);
        tv_delete_image_two = (TextView)view.findViewById(R.id.tv_delete_image_two);
        tv_delete_image_two.setTypeface(fontAwesome);
        tv_delete_image_three = (TextView)view.findViewById(R.id.tv_delete_image_three);
        tv_delete_image_three.setTypeface(fontAwesome);
        tv_delete_image_four = (TextView)view.findViewById(R.id.tv_delete_image_four);
        tv_delete_image_four.setTypeface(fontAwesome);
        tv_delete_image_five = (TextView)view.findViewById(R.id.tv_delete_image_five);
        tv_delete_image_five.setTypeface(fontAwesome);
        tv_delete_image_six = (TextView)view.findViewById(R.id.tv_delete_image_six);
        tv_delete_image_six.setTypeface(fontAwesome);

    }

    public static PhotosFragment newInstance()
    {
        return new PhotosFragment();
    }

}
