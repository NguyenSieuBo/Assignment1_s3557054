package com.assignment1.bo.nguyensieuboassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SimpleCalendarActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView dateDisplay;
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("SimpleCalendarActivity", "Now running onStart");
    }

    @Override
    protected void onResume() {
        Log.i("SimpleCalendarActivity", "Now running onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("SimpleCalendarActivity", "Now running onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("SimpleCalendarActivity", "Now running onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i("SimpleCalendarActivity", "Now running onRestart");
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("SimpleCalendarActivity", "Now running onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calendar);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        Calendar selected = Calendar.getInstance();
        selected.set(Calendar.DAY_OF_YEAR, (int) calendarView.getDate());
        dateDisplay = (TextView) findViewById(R.id.date_display);
        dateDisplay.setText("Date: ");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2)
            {
                dateDisplay.setText("Date: " + i2 + " / " + (i1+1) + " / " + i);

                Toast.makeText(getApplicationContext(), "Selected Date:\n" + "Day = " + i2 + "\n" + "Month = " + (i1+1) + "\n" + "Year = " + i, Toast.LENGTH_LONG).show();
            }
        });
    }
}