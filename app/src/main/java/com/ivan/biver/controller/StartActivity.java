package com.ivan.biver.controller;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.inputmethod.InputMethodManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ivan.biver.R;
import com.ivan.biver.view.StartBaseFragment;
import com.ivan.biver.view.StartFragment;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        if (FirebaseAuth.getInstance().getCurrentUser() == null){

            sentToStart();

        } else {

            sentToMain();

        }

    }

    private void sentToMain() {

        Intent mainIntent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(mainIntent);
        finish();

    }

    private void sentToStart() {

        //Переход на стартовый фрагмент
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment container = fragmentManager.findFragmentById(R.id.StartContainer);
        Fragment fragment = new StartBaseFragment();

        if (container == null) {

            fragmentManager.beginTransaction().add(R.id.StartContainer, fragment).commit();

        }

    }
}
