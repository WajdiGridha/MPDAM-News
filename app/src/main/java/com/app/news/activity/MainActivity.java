package com.app.news.activity;



import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.app.news.R;
import com.app.news.adapter.CategoryAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;


        ViewPager viewPager = findViewById(R.id.viewPager);

        CategoryAdapter adapter = new CategoryAdapter(mContext, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_language_english) {
            setLocale("en");
            recreate();
            return true;
        } else if (id == R.id.menu_language_arabe) {
            setLocale("ar");
            recreate();
            return true;
        } else if (id == R.id.menu_language_french) {
            setLocale("fr");
            recreate();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





    private void setLocale(String languageCode) {
        Locale newLocale = new Locale(languageCode);
        Locale.setDefault(newLocale);
        Configuration config = new Configuration();
        config.setLocale(newLocale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }



}