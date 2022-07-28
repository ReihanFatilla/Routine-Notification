package com.reift.randomnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.reift.randomnotification.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var mWorkManager = WorkManager.getInstance()

        val periodicWork = PeriodicWorkRequest.Builder(
            NotificationWorker::class.java, 1, TimeUnit.MINUTES)
            .build()
        mWorkManager.enqueue(periodicWork)

    }
}