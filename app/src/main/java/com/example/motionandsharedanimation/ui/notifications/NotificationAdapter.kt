package com.example.motionandsharedanimation.ui.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.motionandsharedanimation.R
import com.example.motionandsharedanimation.ui.dashboard.DashboardDetailFragment.Companion.SHARED_IMAGE_VIEW
import com.example.motionandsharedanimation.ui.dashboard.DashboardDetailFragment.Companion.SHARED_TEXT_VIEW
import com.squareup.picasso.Picasso

class NotificationAdapter(private var list: ArrayList<NotificationData>, private val cxt: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mTag = "DashboardAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FeedViewHolder(
            LayoutInflater.from(cxt).inflate(R.layout.item_notification, parent, false)
        )
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivImageNotification = view.findViewById<ImageView>(R.id.ivImageNotification)!!
        val tvTitleNotification = view.findViewById<TextView>(R.id.tvTitleNotification)!!
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is FeedViewHolder) {

            val dataItem = list[position]

            holder.tvTitleNotification.apply {
                transitionName = SHARED_TEXT_VIEW
                text = dataItem.titleName
            }

            holder.ivImageNotification.apply {
                transitionName = SHARED_IMAGE_VIEW
                Picasso.get().load(R.drawable.ic_launcher_foreground).into(this)
            }

            holder.ivImageNotification.setOnClickListener {

                it.findNavController().navigate(
                    NotificationsFragmentDirections.actionNavigationNotificationsToNotificationDetailFragment()
                )
            }
        }
    }

    fun updateFeed(it: java.util.ArrayList<NotificationData>?) {
        if (it != null) {
            list = it
            notifyDataSetChanged()
        }
    }
}