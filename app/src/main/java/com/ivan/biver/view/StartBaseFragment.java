package com.ivan.biver.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ivan.biver.R;
import com.ivan.biver.controller.LoginActivity;
import com.ivan.biver.controller.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartBaseFragment extends Fragment {

    private Button mBtnEnter;
    private Button mBtnEnterForOrder;
    private Button mBtnRegister;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_start_base, container, false);

        mBtnEnter = v.findViewById(R.id.btnEnter);
        mBtnEnterForOrder = v.findViewById(R.id.btnEnterForOrder);
        mBtnRegister = v.findViewById(R.id.btnRegister);

        mBtnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainIntent = new Intent(getActivity(), MainActivity.class);
                startActivity(mainIntent);
                getActivity().finish();

            }
        });

        mBtnEnterForOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent loginIntent = new Intent(getActivity(), LoginActivity.class);
                startActivity(loginIntent);
                getActivity().finish();

            }
        });



        return v;

    }

}
