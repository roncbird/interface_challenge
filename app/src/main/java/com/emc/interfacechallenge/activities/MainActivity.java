package com.emc.interfacechallenge.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.emc.interfacechallenge.R;
import com.emc.interfacechallenge.adapters.ViewPagerAdapter;
import com.emc.interfacechallenge.utilities.FontCache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;

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

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        vp_main = (ViewPager)findViewById(R.id.vp_main);
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

        vp_main.setCurrentItem(2, false);

        TextView tv_main_save = (TextView)findViewById(R.id.tv_main_save);
        tv_main_save.setOnClickListener(this);
        TextView tv_main_settings =(TextView)findViewById(R.id.tv_main_settings);
        tv_main_settings.setOnClickListener(this);
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

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.tv_main_settings:
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
                break;
            case R.id.tv_main_save:
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    checkPermissions(takeScreenshot());
                }
                else
                {
                    saveScreenshot(takeScreenshot());
                }
                break;
        }
    }

    public Bitmap takeScreenshot()
    {
        vp_main.getRootView().setDrawingCacheEnabled(true);
        Bitmap screenShot = Bitmap.createBitmap(vp_main.getRootView().getDrawingCache(true));
        return screenShot;
    }

    public void saveScreenshot(Bitmap screenshot) {

        String path = Environment.getExternalStorageDirectory() + File.separator + "Pictures/screenshot.png";
        File imagePath = new File(path);
        FileOutputStream fileOutputStream;

        try {
            fileOutputStream = new FileOutputStream(imagePath);
            screenshot.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            sendEmail(path);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void sendEmail(String path)
    {

        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                new String[] { "bsoumpholphakdy@sofi.org", "jaffa.sofi.org", "tlawson@sofi.org" });
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "SoFi Interface Challenge Screenshot");
        emailIntent.setType("image/png");

        Uri screenShotUri = Uri.parse("file://" + path);
        emailIntent.putExtra(Intent.EXTRA_STREAM, screenShotUri);
        startActivity(Intent.createChooser(emailIntent, "Send mail..."));

    }

    public void checkPermissions(Bitmap screenshot)
    {

        int writeExternalStorage = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (writeExternalStorage != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
        }
        else
        {
            saveScreenshot(screenshot);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    saveScreenshot(takeScreenshot());
                }
                else
                {
                    Toast.makeText(this, "Permission denied: Unable to save screen shot.", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}
