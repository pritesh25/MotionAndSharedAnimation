package com.example.motionandsharedanimation.ui.dashboard

import android.widget.ImageView
import android.widget.TextView

interface DashboardCallback {
    fun onItemSelected(dashboardData: DashboardData, iv: ImageView, tv: TextView)
}