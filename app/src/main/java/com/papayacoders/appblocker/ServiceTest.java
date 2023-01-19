package com.papayacoders.appblocker;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.util.Timer;
import java.util.TimerTask;

public class ServiceTest extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mTimer = new Timer();
        mTimer.schedule(timerTask, 500, 500);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {

            startForeground();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private Timer mTimer;

    TimerTask timerTask = new TimerTask() {

        @Override
        public void run() {
            Log.d("Log", "Running");
        }
    };

    public void onDestroy() {
        try {
            mTimer.cancel();
            timerTask.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent("com.android.papayacoders");
        intent.putExtra("yourvalue", "torestore");
        sendBroadcast(intent);

        String alarm = Context.ALARM_SERVICE;
        AlarmManager am = (AlarmManager) getSystemService(alarm);

        Intent inte = new Intent("REFRESH_THIS");
        PendingIntent pi = PendingIntent.getBroadcast(this, 123456789, inte, PendingIntent.FLAG_MUTABLE);

        int type = AlarmManager.RTC_WAKEUP;

        am.setExact(type, System.currentTimeMillis(), pi);

    }

    private void startForeground() {
        NotificationChannel chan = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            chan = new NotificationChannel(getPackageName(),
                    "MusicPro", NotificationManager.IMPORTANCE_MIN);
            chan.setShowBadge(false);
            chan.setLightColor(-16776961);
            chan.setLockscreenVisibility(0);
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (manager != null) {
                manager.createNotificationChannel(chan);
            } else {
                throw new AssertionError();
            }
            startForeground(2, new NotificationCompat.Builder((Context) this, getPackageName())
                    .setOngoing(true)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("Finding Music For You...")
                    .setPriority(Notification.PRIORITY_MAX)
                    .setCategory(NotificationCompat.CATEGORY_SERVICE)
                    .build());

        }

    }


}
