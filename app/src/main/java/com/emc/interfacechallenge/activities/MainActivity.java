package com.emc.interfacechallenge.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.emc.interfacechallenge.R;
import com.emc.interfacechallenge.adapters.ViewPagerAdapter;
import com.emc.interfacechallenge.utilities.FontCache;

public class MainActivity extends AppCompatActivity
{

    private TextView tv_back_button;

    private TabLayout tabLayout;
    private TabLayout.Tab tab;

    private ViewPager vp_main;
    private ViewPagerAdapter viewPagerAdapter;

    String tabTitles[] = new String[] { "Basics", "Preferences", "Photos" };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface fontAwesome = FontCache.get("fontawesome-webfont.ttf", this);

        tv_back_button = (TextView)findViewById(R.id.tv_back_button);
        tv_back_button.setTypeface(fontAwesome);

        vp_main = (ViewPager)findViewById(R.id.vp_main);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        vp_main.setAdapter(viewPagerAdapter);
        vp_main.setOffscreenPageLimit(3);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(vp_main);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tab = tabLayout.getTabAt(i);
            tab.setCustomView(getTabView(i));
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                if(tab.getPosition() == 0)
                {
                    tab.getCustomView().findViewById(R.id.rl_custom_tab).setBackground(ResourcesCompat.
                            getDrawable(getResources(), R.drawable.basic_tab_selected_background, null));

                    ((TextView)tab.getCustomView().findViewById(R.id.custom_tab_text)).
                            setTextColor(ResourcesCompat.getColor(getResources(), R.color.header_color, null));
                }
                else if(tab.getPosition() == 1)
                {
                    tab.getCustomView().findViewById(R.id.rl_custom_tab).setBackground(ResourcesCompat.
                            getDrawable(getResources(), R.drawable.preferences_tab_selected_background, null));

                    ((TextView)tab.getCustomView().findViewById(R.id.custom_tab_text)).
                            setTextColor(ResourcesCompat.getColor(getResources(), R.color.header_color, null));
                }
                else
                {
                    tab.getCustomView().findViewById(R.id.rl_custom_tab).setBackground(ResourcesCompat.
                            getDrawable(getResources(), R.drawable.photos_tab_selected_background, null));

                    ((TextView)tab.getCustomView().findViewById(R.id.custom_tab_text)).
                            setTextColor(ResourcesCompat.getColor(getResources(), R.color.header_color, null));
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {
                if(tab.getPosition() == 0)
                {
                    tab.getCustomView().findViewById(R.id.rl_custom_tab).
                            setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.basic_tab_border, null));

                    ((TextView)tab.getCustomView().findViewById(R.id.custom_tab_text)).
                            setTextColor(ResourcesCompat.getColor(getResources(), R.color.tab_background_white, null));
                }
                else if(tab.getPosition() == 1)
                {
                    tab.getCustomView().findViewById(R.id.rl_custom_tab).setBackground(ResourcesCompat.
                            getDrawable(getResources(), R.drawable.preferences_tab_border, null));

                    ((TextView)tab.getCustomView().findViewById(R.id.custom_tab_text)).
                            setTextColor(ResourcesCompat.getColor(getResources(), R.color.tab_background_white, null));
                }
                else
                {
                    tab.getCustomView().findViewById(R.id.rl_custom_tab).setBackground(ResourcesCompat.
                            getDrawable(getResources(), R.drawable.photos_tab_border, null));

                    ((TextView)tab.getCustomView().findViewById(R.id.custom_tab_text)).
                            setTextColor(ResourcesCompat.getColor(getResources(), R.color.tab_background_white, null));
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });
    }

    public View getTabView(int position) {
        View tab = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tab.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        RelativeLayout rl_custom_tab = (RelativeLayout)tab.findViewById(R.id.rl_custom_tab);

        if(position <= 0)
        {
            rl_custom_tab.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.basic_tab_border, null));
        }
        else if( position == 1)
        {
            rl_custom_tab.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.preferences_tab_border, null));
        }
        else
        {
            rl_custom_tab.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.photos_tab_border, null));
        }

        TextView tv = (TextView) tab.findViewById(R.id.custom_tab_text);
        tv.setText(tabTitles[position]);
        return tab;
    }
}
