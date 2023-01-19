package com.papayacoders.appblocker;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.concurrent.TimeUnit;

/**
 * Created by Papaya Coders on 19,January,2023
 */
public class DownloadWorkerJava extends Worker {

    public DownloadWorkerJava(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d("SHUBH", "download: ");

        OneTimeWorkRequest mywork = new OneTimeWorkRequest.Builder(DownloadWorkerJava.class)
                .setInitialDelay(2, TimeUnit.SECONDS)
                .build();
        WorkManager.getInstance(getApplicationContext()).enqueue(mywork);
        return Result.success();

    }
}
