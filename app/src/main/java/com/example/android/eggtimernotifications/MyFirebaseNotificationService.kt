package com.example.android.eggtimernotifications

import android.app.NotificationManager
import androidx.core.content.ContextCompat
import com.example.android.eggtimernotifications.util.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import timber.log.Timber

/**
 * Created by Vladyslav Hontar (vhontar) on 08.04.20.
 */
class MyFirebaseNotificationService: FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Timber.i("Received token from FCM: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        message.data.let {
            Timber.i(it.toString())
        }

        message.notification?.let {
            sendNotification(it.body!!)
        }
    }

    private fun sendNotification(messageBody: String) {
        val notificationManager = ContextCompat.getSystemService(
            applicationContext, NotificationManager::class.java) as NotificationManager
        notificationManager.sendNotification(messageBody, applicationContext)
    }
}