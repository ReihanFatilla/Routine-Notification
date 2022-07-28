package com.reift.randomnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Error
import java.util.logging.Handler

class NotificationWorker(context: Context, workerParameters: WorkerParameters):
Worker(context, workerParameters){
    override fun doWork(): Result {
        return try{
            makeStatusNotification("Routine Notification Showed!", applicationContext)
            Result.success()
        } catch (e: Error){
            Result.failure()
        }
    }

    private fun makeStatusNotification(message: String, context: Context) {

        val CHANNEL_ID = "ROUTINE_ALARM"
        val NOTIFICATION_ID = 0

        // Create the notification
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notification_important_24)
            .setContentTitle("A Routine Alarm")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setVibrate(LongArray(0))

        // Show the notification
        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build())
    }

}