package com.example.motionandsharedanimation.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.example.motionandsharedanimation.R
import com.example.motionandsharedanimation.ui.dashboard.DashboardDetailFragment.Companion.SHARED_IMAGE_VIEW
import com.example.motionandsharedanimation.ui.dashboard.DashboardDetailFragment.Companion.SHARED_TEXT_VIEW
import com.squareup.picasso.Picasso

class DashboardAdapter(private var list: ArrayList<DashboardData>, private val cxt: Context) :
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
                Picasso.get().load(dataItem.imageUrl).into(this)
            }

            holder.ivImageFeed.setOnClickListener {

                it.findNavController().navigate(
                    DashboardFragmentDirections.actionNavigationDashboardToFeedDetailFragment(
                        dataItem.imageUrl,
                        dataItem.titleName
                    ), FragmentNavigatorExtras(
                        holder.ivImageFeed to SHARED_IMAGE_VIEW,
                        holder.tvTitleFeed to SHARED_TEXT_VIEW
                    )
                )
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