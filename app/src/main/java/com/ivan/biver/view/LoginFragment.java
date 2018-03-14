package com.ivan.biver.view;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ivan.biver.R;
import com.ivan.biver.controller.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    private EditText mLoginEmail;
    private EditText mLoginPassword;

    private Button mLoginBtn;

    private ProgressDialog mLoginProgress;

    private FirebaseAuth mAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_login, container, false);


        mAuth = FirebaseAuth.getInstance();

        mLoginProgress = new ProgressDialog(getActivity());

        mLoginEmail = v.findViewById(R.id.loginEmail);
        mLoginPassword = v.findViewById(R.id.loginPassword);

        mLoginBtn = v.findViewById(R.id.loginBtn);

        mLoginBtn.setOnClickListener(v1 -> {

            String email = mLoginEmail.getText().toString();
            String password = mLoginPassword.getText().toString();
            View focusView = null;

            if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

                mLoginProgress.setTitle("Вход в аккуант");
                mLoginProgress.setMessage("Это займет пару секунд");
                mLoginProgress.setCanceledOnTouchOutside(false);
                mLoginProgress.show();

                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                loginUser(email, password);

            } else {

                if (TextUtils.isEmpty(password)) {

                    mLoginPassword.setError("Введите пароль");
                    focusView = mLoginPassword;

                }

                if (TextUtils.isEmpty(email)) {

                    mLoginEmail.setError("Введите почту");
                    focusView = mLoginEmail;

                }

                focusView.requestFocus();

            }


        });


        return v;

    }

    private void loginUser(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

            if (task.isSuccessful()) {

                mLoginProgress.dismiss();

                Intent mainIntent = new Intent(getActivity(), MainActivity.class);
                startActivity(mainIntent);
                getActivity().finish();

            } else {

                mLoginProgress.hide();

                Snackbar.make(getView(), "ПАРОЛЬ ИЛИ ЛОГИН ВВЕДЕНЫ НЕВЕРНО", Snackbar.LENGTH_LONG).show();


            }

        });

    }

}
