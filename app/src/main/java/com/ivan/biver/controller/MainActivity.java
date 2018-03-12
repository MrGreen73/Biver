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

   /* private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_store:
                    fragmentManager = getSupportFragmentManager();
                    container = fragmentManager.findFragmentById(R.id.mainContainer);
                    fragment = new StoreFragment();

                    if (container == null) {

                        fragmentManager.beginTransaction().replace(R.id.mainContainer, fragment).addToBackStack(null).commit();

                    }
                    return true;
                case R.id.navigation_discount:
                    fragmentManager = getSupportFragmentManager();
                    container = fragmentManager.findFragmentById(R.id.mainContainer);
                    fragment = new DiscountFragment();

                    if (container == null) {

                        fragmentManager.beginTransaction().replace(R.id.mainContainer, fragment).addToBackStack(null).commit();

                    }
                    return true;
                case R.id.navigation_order:
                    fragmentManager = getSupportFragmentManager();
                    container = fragmentManager.findFragmentById(R.id.mainContainer);
                    fragment = new OrderFragment();

                    if (container == null) {

                        fragmentManager.beginTransaction().replace(R.id.mainContainer, fragment).addToBackStack(null).commit();

                    }
                    return true;
            }
            return false;
            //discoutn
            //order
            //store
        }
    };
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        final Fragment container = fragmentManager.findFragmentById(R.id.mainContainer);

        final Fragment fragment = new StoreFragment();

        if (container == null) {

            fragmentManager.beginTransaction().add(R.id.mainContainer, fragment).addToBackStack(null).commit();

        }

        /*BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
*/

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_store:
                                //
                                Toast.makeText(MainActivity.this, "Store", Toast.LENGTH_SHORT).show();
                                Fragment fragment1 = new StoreFragment();

                                if (container == null) {

                                    fragmentManager.beginTransaction().replace(R.id.mainContainer, fragment1).commit();

                                }
                                break;
                            case R.id.navigation_discount:
                                Toast.makeText(MainActivity.this, "Discount", Toast.LENGTH_SHORT).show();

                                Fragment fragment2 = new DiscountFragment();

                                if (container == null) {

                                    fragmentManager.beginTransaction().replace(R.id.mainContainer, fragment2).commit();

                                }

                                 break;
                            case R.id.navigation_order:
                                Toast.makeText(MainActivity.this, "Order", Toast.LENGTH_SHORT).show();

                                Fragment fragment3 = new OrderFragment();

                                if (container == null) {

                                    fragmentManager.beginTransaction().replace(R.id.mainContainer, fragment3).commit();

                                }
                                //
                                break;
                        }
                        return true;
                    }
                });


    }

}
