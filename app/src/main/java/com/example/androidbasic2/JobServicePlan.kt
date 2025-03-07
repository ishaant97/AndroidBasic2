package com.example.androidbasic2

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import kotlin.concurrent.thread

class JobServicePlan : JobService() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onStartJob(p0: JobParameters?): Boolean {
        Log.d("MyJobService", "Job Started!!!")
        thread {
            Thread.sleep(5000)
            Log.d("MyJobService", "Job finished!!!")
            jobFinished(p0, false)
        }.start()
        return  true
    }

    override fun onStopJob(params: JobParameters?) : Boolean {
        Log.d("MyJobService", "Job stopped!!!")
        return false
    }

}