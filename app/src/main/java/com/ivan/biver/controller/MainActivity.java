package com.ivan.biver.controller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.ivan.biver.R;
import com.ivan.biver.view.DiscountFragment;
import com.ivan.biver.view.OrderFragment;
import com.ivan.biver.view.StartFragment;
import com.ivan.biver.view.StoreFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private FragmentManager fragmentManager;
    private Fragment container;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        container = fragmentManager.findFragmentById(R.id.mainContainer);
        fragment = new StoreFragment();

        if (container == null) {

            fragmentManager.beginTransaction().add(R.id.mainContainer, fragment).addToBackStack(null).commit();

        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_store:
                                fragment = new StoreFragment();

                                if (container == null) {

                                    fragmentManager.beginTransaction().replace(R.id.mainContainer, fragment).commit();

                                }
                                break;
                            case R.id.navigation_discount:
                                fragment = new DiscountFragment();

                                if (container == null) {

                                    fragmentManager.beginTransaction().replace(R.id.mainContainer, fragment).commit();

                                }

                                 break;
                            case R.id.navigation_order:
                                fragment = new OrderFragment();

                                if (container == null) {

                                    fragmentManager.beginTransaction().replace(R.id.mainContainer, fragment).commit();

                                }
                                //
                                break;
                        }
                        return true;
                    }
                });


    }

}
