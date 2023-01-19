package com.papayacoders.appblocker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val inte = Intent()
//        val packageName = packageName
//        val pm = getSystemService(POWER_SERVICE) as PowerManager
//        if (!pm.isIgnoringBatteryOptimizations(packageName)) {
//            inte.action = Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
//            inte.data = Uri.parse("package:$packageName")
//            startActivity(inte)
//        }

//        startService(Intent(this, ServiceTest::class.java))


//        val saveRequest = OneTimeWorkRequest.Builder(DownloadWorker::class.java).build()
        val saveRequest = OneTimeWorkRequest.Builder(DownloadWorkerJava::class.java).build()

        WorkManager
            .getInstance(this)
            .enqueue(saveRequest)


//        val alarm: String = Context.ALARM_SERVICE
//        val am = getSystemService(alarm) as AlarmManager
//
//        val intent = Intent("REFRESH_THIS")
//        val pi = PendingIntent.getBroadcast(this, 123456789, intent, FLAG_MUTABLE)
//
//        val type = AlarmManager.RTC_WAKEUP
//        val interval = (1000 * 50).toLong()
//
//        am.setInexactRepeating(type, System.currentTimeMillis(), interval, pi)

    }
}