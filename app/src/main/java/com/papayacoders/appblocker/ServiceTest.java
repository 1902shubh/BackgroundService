package com.papayacoders.appblocker;

import static android.app.PendingIntent.FLAG_IMMUTABLE;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

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

		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.onStartCommand(intent, flags, startId);
	}

	private Timer mTimer;

	TimerTask timerTask = new TimerTask() {

		@Override
		public void run() {
			Log.e("Log", "Running");
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
	}
}
