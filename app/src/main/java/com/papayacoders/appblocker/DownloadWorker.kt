package com.papayacoders.appblocker

import android.content.Context
import android.util.Log
import androidx.work.*
import java.util.concurrent.TimeUnit


/**
 * Created by Papaya Coders on 19,January,2023
 */
class DownloadWorker(context: Context, parameters: WorkerParameters) :
    CoroutineWorker(context, parameters) {

    override suspend fun doWork(): Result {
        Log.d("SHUBH", "download: ")
        val mywork = OneTimeWorkRequest.Builder(DownloadWorker::class.java)
            .setInitialDelay(2, TimeUnit.SECONDS)
            .build()
        WorkManager.getInstance(applicationContext).enqueue(mywork)

        return Result.success()
    }

}