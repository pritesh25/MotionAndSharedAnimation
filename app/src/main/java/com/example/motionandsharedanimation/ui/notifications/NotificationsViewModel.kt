package com.example.motionandsharedanimation.ui.notifications

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private var listData = MutableLiveData<ArrayList<NotificationData>>()
    fun getNotificationList(): MutableLiveData<ArrayList<NotificationData>> {
        val dataList = arrayListOf<NotificationData>(
            NotificationData("aeroplane"),
            NotificationData("arctichare"),
            NotificationData("baboon"),
            NotificationData("boat"),
            NotificationData("cat"),
            NotificationData("fruits"),
            NotificationData("frymire"),
            NotificationData("girl"),
            NotificationData("monarch"),
            NotificationData("peppers"),
            NotificationData("pool"),
            NotificationData("serrano"),
            NotificationData("watch"),
            NotificationData("zelda")
        )
        listData.value = dataList
        return listData
    }
}