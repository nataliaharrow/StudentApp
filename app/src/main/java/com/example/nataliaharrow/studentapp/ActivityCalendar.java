package com.example.nataliaharrow.studentapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;

public class ActivityCalendar extends AppCompatActivity {

    private static final String TAG = "ActivityCalendar";

    private CalendarView myCalendarView;
    private TextView myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        myCalendarView = (CalendarView)findViewById(R.id.calendarView);
        myDate = (TextView)findViewById(R.id.textView);

        myCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1 + 1) + "/" + i2 + "/" + i;
                myDate.setText(date);
               // Log.d(TAG, "onSelectedDayChange: date" + date);
            }
        });
    }
}
