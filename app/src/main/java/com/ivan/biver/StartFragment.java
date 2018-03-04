package com.ivan.biver;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class StartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_start, container, false);
/*
        Snackbar

        Snackbar
                .make(parent, "Покормил кота?", Snackbar.LENGTH_LONG)
                .setAction("Да", snackOnClickListener)
                .setActionTextColor(Color.MAGENTA) // цвет текста у кнопки действия
                .show();*/


        return v;

    }

}
