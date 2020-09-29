package com.example.motionandsharedanimation.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.motionandsharedanimation.R
import com.example.motionandsharedanimation.ui.dashboarddetail.DashboardDetailFragment.Companion.SHARED_IMAGE_VIEW
import com.example.motionandsharedanimation.ui.dashboarddetail.DashboardDetailFragment.Companion.SHARED_TEXT_VIEW

class DashboardAdapter(
    private var list: ArrayList<DashboardData>,
    private val cxt: Context,
    private val dashboardCallback: DashboardCallback
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mTag = "DashboardAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FeedViewHolder(LayoutInflater.from(cxt).inflate(R.layout.item_feed, parent, false))
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivImageFeed = view.findViewById<ImageView>(R.id.ivImageFeed)!!
        val tvTitleFeed = view.findViewById<TextView>(R.id.tvTitleFeed)!!
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is FeedViewHolder) {

            val dataItem = list[position]

            holder.tvTitleFeed.apply {
                transitionName = SHARED_TEXT_VIEW
                text = dataItem.titleName
            }

            holder.ivImageFeed.apply {
                transitionName = SHARED_IMAGE_VIEW
                this.load(dataItem.imageUrl)
            }

            holder.ivImageFeed.setOnClickListener {
                dashboardCallback.onItemSelected(dataItem, holder.ivImageFeed, holder.tvTitleFeed)
            }
        }
    }

    fun updateFeed(it: java.util.ArrayList<DashboardData>?) {
        if (it != null) {
            list = it
            notifyDataSetChanged()
        }
    }
}