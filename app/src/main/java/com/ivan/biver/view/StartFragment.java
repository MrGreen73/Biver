package com.ivan.biver.view;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.ivan.biver.R;
import com.ivan.biver.controller.MainActivity;


public class StartFragment extends Fragment {

    private Button mSignWithGoogle;
    private Button mSignWithFacebook;
    private Button mSignWithTwitter;
    private Button mSignWithEmail;
    private Button mSign;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_start, container, false);

        mSignWithGoogle = v.findViewById(R.id.btnInGoogle);
        mSignWithFacebook = v.findViewById(R.id.btnInFacebook);
        mSignWithTwitter = v.findViewById(R.id.btnInTwitter);
        mSignWithEmail = v.findViewById(R.id.btnInEmail);
        mSign = v.findViewById(R.id.btnLogin);

        mSignWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar = Snackbar.make(v, "Для перехода нажмите ВХОД", Snackbar.LENGTH_LONG);
                snackbar.setAction("ВХОД", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent MainActivity = new Intent(getActivity(), MainActivity.class);
                        startActivity(MainActivity);
                        getActivity().finish();

                    }
                }).show();

            }
        });


        mSignWithFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "Вы хотите войти через Facebook" , Snackbar.LENGTH_LONG).show();

            }
        });

        mSignWithTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "Вы хотите войти через Twitter" , Snackbar.LENGTH_LONG).show();

            }
        });


        mSignWithEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "Вы хотите войти через Email" , Snackbar.LENGTH_LONG).show();

            }
        });

        mSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar = Snackbar.make(v, "Вы хотите войти?", Snackbar.LENGTH_LONG);
                snackbar.setAction("ДА", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent MainActivity = new Intent(getActivity(), MainActivity.class);
                        startActivity(MainActivity);
                        getActivity().finish();

                    }
                }).show();

            }
        });

        return v;

    }

}
