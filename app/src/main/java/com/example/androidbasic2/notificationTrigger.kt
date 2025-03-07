package com.example.androidbasic2

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class notificationTrigger : AppCompatActivity() {

    val channelid = "Notification_channel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_notification_trigger)
        createNotification()

        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            showNotification()
        }
    }

    private fun createNotification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "Android Developer"
            val descriptionText = "Click Here"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelid, name, importance).apply {
                description = descriptionText
            }
            val notificationManager : NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification(){
        val intent = Intent(this,MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
            or PendingIntent.FLAG_IMMUTABLE
        )
        val notificationBuilder = NotificationCompat.Builder(this, channelid)
            .setSmallIcon(R.drawable.baseline_notifications_24)
            .setContentTitle("New Notification Trigger")
            .setContentText("Please tap to open SecondActivity")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)){
            if(ActivityCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED)
            {
                return
            }
            notify(1,notificationBuilder.build())
        }
    }
}