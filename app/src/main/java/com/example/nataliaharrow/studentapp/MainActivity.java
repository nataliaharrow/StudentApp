package com.example.nataliaharrow.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //Submit = (Button)findViewById(R.id.Submit);
    //Submit = (Button)loginDialog.findViewById(R.id.Submit);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCalendar = (Button)findViewById(R.id.btn_calendar);
        buttonCalendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //
                Intent intent = new Intent(MainActivity.this, ActivityCalendar.class);
                startActivity(intent);
            }
        });

        Button buttonToDoList = (Button) findViewById(R.id.btn_todolist);
        buttonToDoList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ActivityToDoList.class);
                startActivity(intent);
            }
        });

        Button buttonStudyQuestions = (Button) findViewById(R.id.btn_studyquestions);
        buttonStudyQuestions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, ActivityStudyQuestions.class);
                startActivity(intent);
            }
        });
    }
}

/*
* Intent intent = new Intent(getApplicationContext(), ActivityCalendar.class);
                startActivity(intent);*/

//207266049935-2u21cu28rd7femvbbrh5h8fkvpg0mi1r.apps.googleusercontent.com