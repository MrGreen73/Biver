package com.ivan.biver.view;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ivan.biver.R;
import com.ivan.biver.controller.MainActivity;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {



    private EditText mRegisterEmail;
    private EditText mRegisterPhone;
    private EditText mRegisterPassword;
    private Button mRegisterBtn;

    //Progress Dialog
    private ProgressDialog mRegProgress;

    //Firebase Auth
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_register, container, false);

        //Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        mRegisterEmail = v.findViewById(R.id.registerEmail);
        mRegisterPhone = v.findViewById(R.id.registerPhone);
        mRegisterPassword = v.findViewById(R.id.registerPassword);
        mRegisterBtn = v.findViewById(R.id.registerBtn);

        mRegisterBtn.setOnClickListener(view -> {

            String email = mRegisterEmail.getText().toString();
            String phone = mRegisterPhone.getText().toString();
            String password = mRegisterPassword.getText().toString();

            View focusView = null;

            if (!TextUtils.isEmpty(phone) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {

                mRegProgress = new ProgressDialog(getActivity());
                mRegProgress.setTitle("Регистрация аккаунта");
                mRegProgress.setMessage("Это займет пару секунд");
                mRegProgress.setCanceledOnTouchOutside(false);
                mRegProgress.show();

                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                registerUser(email, phone, password);

            } else {

                if (TextUtils.isEmpty(phone)){

                    mRegisterPhone.setError("Введите телефон");
                    focusView = mRegisterPhone;

                }

                if (TextUtils.isEmpty(password)) {

                    mRegisterPassword.setError("Введите пароль");
                    focusView = mRegisterPassword;

                }

                if (TextUtils.isEmpty(email)) {

                    mRegisterEmail.setError("Введите почту");
                    focusView = mRegisterEmail;

                }

                focusView.requestFocus();

            }

        });

        return v;

    }

    private void registerUser(String email, String phone, String password) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

            Snackbar.make(getView(), password, Snackbar.LENGTH_LONG).show();

            if (task.isSuccessful()) {

                FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = current_user.getUid();

                mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);

                HashMap<String, String> userMap = new HashMap<>();
                userMap.put("Email", email);
                userMap.put("Phone", phone);
                userMap.put("card", "0000 0000 0000 0000");

                mDatabase.setValue(userMap).addOnCompleteListener(task1 -> {

                    if (task1.isSuccessful()) {

                        mRegProgress.dismiss();

                        Intent mainIntent = new Intent(getActivity(), MainActivity.class);
                        startActivity(mainIntent);
                        getActivity().finish();

                    }

                });

            } else {

                mRegProgress.hide();
//                Snackbar.make(getView(), "ПАРОЛЬ ИЛИ ЛОГИН ВВЕДЕНЫ НЕКОРРЕКТНО", Snackbar.LENGTH_LONG).show();

            }
        });

    }

}
