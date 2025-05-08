package com.example.androidbasic2.endTermPractice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.widget.Toast

class AlarmReciever: BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        Toast.makeText(context,"Alarm Triggered",Toast.LENGTH_SHORT).show()

        val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val ringtone: Ringtone = RingtoneManager.getRingtone(context, alarmSound)
        ringtone.play()
    }
}