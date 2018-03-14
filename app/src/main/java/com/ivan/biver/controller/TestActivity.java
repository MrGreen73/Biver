package com.ivan.biver.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ivan.biver.R;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        RecyclerView rv = findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();

        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);




    }


    class Person {
        String name;
        String age;
        int photoId;
        Person(String name, String age, int photoId) {
            this.name = name;
            this.age = age;
            this.photoId = photoId;
        }
    }

    private List<Person> persons;

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.ic_home_black_24dp));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.ic_dashboard_black_24dp));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_notifications_black_24dp));
    }

}



