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

import com.ivan.biver.R;
import com.ivan.biver.controller.MainActivity;


public class StartFragment extends Fragment {

    Button mSignWithGoogle;
    Button mSignWithTwitter;
    Button mSignWithFacebook;
    Button mSignWithEmail;
    Button mSignWithPhone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_start, container, false);

        mSignWithGoogle = v.findViewById(R.id.btnInGoogle);

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

        return v;

    }

}
