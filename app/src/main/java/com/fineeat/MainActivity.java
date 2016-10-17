package com.fineeat;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    //cwz 11/10/16 Added to create tab test
    //Created development branch
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    int[] tabImages = { R.drawable.home, R.drawable.search, R.drawable.favorite, R.drawable.account };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initTab();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void initTab(){
        //cwz 11/10/16 Added to create tab
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getApplicationContext(), getSupportFragmentManager());

        //List of tabs
        viewPagerAdapter.addFragment(new MainFragment(), "Home");
        viewPagerAdapter.addFragment(new SearchFragment(), "Search");
        viewPagerAdapter.addFragment(new FavouriteFragment(), "Favourite");
        viewPagerAdapter.addFragment(new AccountFragment(), "Account");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setTabIcon(tabLayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if ( tab.getIcon() != null ){
                    tab.getIcon().setColorFilter(Color.parseColor("#ed4958"), PorterDuff.Mode.MULTIPLY);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if ( tab.getIcon() != null ){
                    tab.getIcon().clearColorFilter();
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //Not used
            }
        });
    }

    //Used in initTab
    public void setTabIcon(TabLayout tabLayout){
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(tabImages[i]);
            //set selected colour filter for the first tab - might not be the best may to check again in the future
            if( i == 0 ){
                tabLayout.getTabAt(i).getIcon().setColorFilter(Color.parseColor("#ed4958"), PorterDuff.Mode.MULTIPLY);
            }
        }
    }
}
