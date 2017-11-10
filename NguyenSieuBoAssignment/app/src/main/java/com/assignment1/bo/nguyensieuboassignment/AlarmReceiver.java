package com.assignment1.bo.nguyensieuboassignment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

public class AlarmReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        long ringdelay = 10000;
        final Toast tst = Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG);
        tst.show();
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        // Make sure to ring the default ringtone when it cannot find anything.
        if (alarmUri == null)
        {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        final Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();
        // Set time to stop the clock around 10 seconds
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                ringtone.stop();
                tst.cancel();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, ringdelay);
        // Set disable the toast message

    }
}
