package com.example.androidbasic2

import android.annotation.SuppressLint
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class JobScheduler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_job_scheduler)

        val button = findViewById<Button>(R.id.btn)

        button.setOnClickListener {
            scheduleJob()
        }
    }

    @SuppressLint("ServiceCast")
    private fun scheduleJob(){
        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val componentName = ComponentName(this,JobServicePlan::class.java)
        val jobInfo = JobInfo.Builder(1,componentName)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            .setRequiresCharging(true)
            .setPersisted(true)
            .build()
        val result = jobScheduler.schedule(jobInfo)
        if(result == JobScheduler.RESULT_SUCCESS){
            Log.d("MainActivity","Job Scheduled successfully!!!")
        }
        else{
            Log.d("MainActivity","Job Scheduling failed!!!")
        }
    }
}