package com.ivan.biver.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ivan.biver.R;
import com.ivan.biver.view.StartFragment;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        //Переход на стартовый фрагмент
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment container = fragmentManager.findFragmentById(R.id.StartContainer);
        Fragment fragment = new StartFragment();

        if (container == null) {

            fragmentManager.beginTransaction().add(R.id.StartContainer, fragment).commit();

        }

    }
}
