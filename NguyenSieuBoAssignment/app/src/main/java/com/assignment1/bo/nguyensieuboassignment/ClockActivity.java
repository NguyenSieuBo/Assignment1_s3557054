package com.assignment1.bo.nguyensieuboassignment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ClockActivity extends AppCompatActivity {
    TimePicker alarmTimePicker;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ClockActivity", "Now running onStart");
    }

    @Override
    protected void onResume() {
        Log.i("ClockActivity", "Now running onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("ClockActivity", "Now running onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("ClockActivity", "Now running onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i("ClockActivity", "Now running onRestart");
        super.onRestart();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.i("ClockActivity", "Now running onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        alarmTimePicker = (TimePicker) findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

    }
    public void OnToggleClicked(View view)
    {
        long time;
        if (((ToggleButton) view).isChecked())
        {
            Toast.makeText(ClockActivity.this, "ALARM ON", Toast.LENGTH_SHORT).show();
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
            Intent intent = new Intent(this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

            time=(calendar.getTimeInMillis()-(calendar.getTimeInMillis()%60000));
            if(System.currentTimeMillis()>time)
            {
                if (calendar.AM_PM == 0)
                    time = time + (1000*60*60*12);
                else
                    time = time + (1000*60*60*24);
            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent);
        }
        else
        {
            alarmManager.cancel(pendingIntent);
            Toast.makeText(ClockActivity.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
        }
    }
}
