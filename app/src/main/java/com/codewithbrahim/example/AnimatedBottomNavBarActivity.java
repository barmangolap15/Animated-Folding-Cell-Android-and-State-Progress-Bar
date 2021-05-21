package com.codewithbrahim.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class AnimatedBottomNavBarActivity extends AppCompatActivity {

    private static final String TAG = AnimatedBottomNavBarActivity.class.getSimpleName();
    AnimatedBottomBar animatedBottomBar;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_bottom_nav_bar);

        animatedBottomBar = findViewById(R.id.animatedBottomBar);

        if (savedInstanceState == null){
            animatedBottomBar.selectTabById(R.id.home, true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container_animated, homeFragment).commit();

        }

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int newIndex, @NotNull AnimatedBottomBar.Tab newTab) {

                Fragment fragment = null;
                switch (newTab.getId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.book:
                        fragment = new BookFragment();
                        break;
                    case R.id.user:
                        fragment = new UserFragment();
                        break;
                }

                if (fragment != null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container_animated, fragment).commit();

                }else {
                    Log.e(TAG, "Error in creating Fragments");
                }

            }
        });

    }
}