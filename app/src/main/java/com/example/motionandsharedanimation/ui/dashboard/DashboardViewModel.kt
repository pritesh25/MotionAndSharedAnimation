package com.example.motionandsharedanimation.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private var listData = MutableLiveData<ArrayList<DashboardData>>()

    fun setLiveHorizontalBlog() {
        val feedDataList = arrayListOf<DashboardData>(
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/airplane.png", "aeroplane"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/arctichare.png", "arctichare"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/baboon.png", "baboon"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/boat.png", "boat"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/cat.png", "cat"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/fruits.png", "fruits"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/frymire.png", "frymire"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/girl.png", "girl"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/monarch.png", "monarch"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/peppers.png", "peppers"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/pool.png", "pool"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/serrano.png", "serrano"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/watch.png", "watch"),
            DashboardData("https://homepages.cae.wisc.edu/~ece533/images/zelda.png", "zelda")
        )
        listData.value = feedDataList
    }

    fun getLiveHorizontalBlog(): MutableLiveData<ArrayList<DashboardData>> {
        return listData
    }
}