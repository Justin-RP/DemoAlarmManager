package com.example.a16022916.demoalarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnSetAlarm;
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetAlarm = findViewById(R.id.mainBtnAlarm);

        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                //Alarm is set to 5 second later
                cal.add(Calendar.SECOND, 5);

                Context contextFrom = MainActivity.this;
                Class classTo = AlarmReceiverActivity.class;
                Intent intent = new Intent(contextFrom,classTo);

                int reqCode = 12345;
                PendingIntent pendingIntent = PendingIntent.getActivity(contextFrom,
                        reqCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);

                am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);

                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent);
            }
        });
    }
}
