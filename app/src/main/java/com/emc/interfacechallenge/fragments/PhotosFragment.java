package com.emc.interfacechallenge.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emc.interfacechallenge.R;
import com.emc.interfacechallenge.models.ProfileModel;
import com.emc.interfacechallenge.utilities.FontCache;
import com.emc.interfacechallenge.utilities.Methods;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotosFragment extends Fragment implements View.OnLongClickListener, View.OnClickListener
{

    private ImageView iv_one;
    private ImageView iv_two;
    private ImageView iv_three;
    private ImageView iv_four;
    private ImageView iv_five;
    private ImageView iv_six;

    private ArrayList<ProfileModel> profileModelArrayList = new ArrayList<>();
    private ArrayList<TextView> deleteImageTextViewList = new ArrayList<>();
    private ArrayList<ImageView> imageViewArrayList = new ArrayList<>();

    public PhotosFragment()
    {
        // Required empty public constructor
    }

    public static PhotosFragment newInstance()
    {
        return new PhotosFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Gson gson = new Gson();
        try
        {
            JSONArray jsonArray = new JSONArray(Methods.loadJsonFile(getActivity()));

            for(int i = 0; i < 6; i++)
            {
                ProfileModel profileModel = gson.fromJson(jsonArray.getJSONObject(i).toString(), ProfileModel.class);
                profileModelArrayList.add(profileModel);
            }

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Typeface fontAwesome = FontCache.get("fontawesome-webfont.ttf", getActivity());

        TextView tv_delete_image_one = (TextView) view.findViewById(R.id.tv_delete_image_one);
        tv_delete_image_one.setTypeface(fontAwesome);
        TextView tv_delete_image_two = (TextView) view.findViewById(R.id.tv_delete_image_two);
        tv_delete_image_two.setTypeface(fontAwesome);
        TextView tv_delete_image_three = (TextView) view.findViewById(R.id.tv_delete_image_three);
        tv_delete_image_three.setTypeface(fontAwesome);
        TextView tv_delete_image_four = (TextView) view.findViewById(R.id.tv_delete_image_four);
        tv_delete_image_four.setTypeface(fontAwesome);
        TextView tv_delete_image_five = (TextView) view.findViewById(R.id.tv_delete_image_five);
        tv_delete_image_five.setTypeface(fontAwesome);
        TextView tv_delete_image_six = (TextView) view.findViewById(R.id.tv_delete_image_six);
        tv_delete_image_six.setTypeface(fontAwesome);

        TextView tv_profile_number = (TextView)view.findViewById(R.id.tv_profile_number);
        tv_profile_number.setText(profileModelArrayList.get(0).getId());

        TextView tv_profile_bio = (TextView)view.findViewById(R.id.tv_profile_bio);
        tv_profile_bio.setText(profileModelArrayList.get(0).getBio());

        deleteImageTextViewList.add(tv_delete_image_one);
        deleteImageTextViewList.add(tv_delete_image_two);
        deleteImageTextViewList.add(tv_delete_image_three);
        deleteImageTextViewList.add(tv_delete_image_four);
        deleteImageTextViewList.add(tv_delete_image_five);
        deleteImageTextViewList.add(tv_delete_image_six);

        iv_one = (ImageView)view.findViewById(R.id.iv_one);
        iv_two = (ImageView)view.findViewById(R.id.iv_two);
        iv_three = (ImageView)view.findViewById(R.id.iv_three);
        iv_four = (ImageView)view.findViewById(R.id.iv_four);
        iv_five = (ImageView)view.findViewById(R.id.iv_five);
        iv_six = (ImageView)view.findViewById(R.id.iv_six);

        imageViewArrayList.add(iv_one);
        imageViewArrayList.add(iv_two);
        imageViewArrayList.add(iv_three);
        imageViewArrayList.add(iv_four);
        imageViewArrayList.add(iv_five);
        imageViewArrayList.add(iv_six);

        int index = 0;
        for(ProfileModel profileModel: profileModelArrayList)
        {
            imageViewArrayList.get(index).setOnLongClickListener(this);
            Picasso.with(getActivity()).load(profileModel.getAvatar()).fit().into(imageViewArrayList.get(index++));

        }


    }

    @Override
    public boolean onLongClick(View v)
    {
        return setDeleteIconVisiblity(true);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.tv_delete_image_one:
                iv_one.setImageDrawable(null);
                iv_one.setOnLongClickListener(null);
                setDeleteIconVisiblity(false);
                break;
            case R.id.tv_delete_image_two:
                iv_two.setImageDrawable(null);
                iv_two.setOnLongClickListener(null);
                setDeleteIconVisiblity(false);
                break;
            case R.id.tv_delete_image_three:
                iv_three.setImageDrawable(null);
                iv_three.setOnLongClickListener(null);
                setDeleteIconVisiblity(false);
                break;
            case R.id.tv_delete_image_four:
                iv_four.setImageDrawable(null);
                iv_four.setOnLongClickListener(null);
                setDeleteIconVisiblity(false);
                break;
            case R.id.tv_delete_image_five:
                iv_five.setImageDrawable(null);
                iv_five.setOnLongClickListener(null);
                setDeleteIconVisiblity(false);
                break;
            case R.id.tv_delete_image_six:
                iv_six.setImageDrawable(null);
                iv_six.setOnLongClickListener(null);
                setDeleteIconVisiblity(false);
                break;
            default:
                break;
        }
    }

    public boolean setDeleteIconVisiblity(boolean showDeleteIcon)
    {
        if(showDeleteIcon)
        {
            for(int i = 0; i < deleteImageTextViewList.size(); i++)
            {
                if(imageViewArrayList.get(i).getDrawable() != null)
                {
                    deleteImageTextViewList.get(i).setVisibility(View.VISIBLE);
                }
                deleteImageTextViewList.get(i).setOnClickListener(this);
            }

        }
        else
        {
            for(int i = 0; i < deleteImageTextViewList.size(); i++)
            {
                deleteImageTextViewList.get(i).setVisibility(View.GONE);
            }
        }

        return true;
    }
}
