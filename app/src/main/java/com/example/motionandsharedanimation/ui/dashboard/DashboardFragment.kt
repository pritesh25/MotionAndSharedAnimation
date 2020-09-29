package com.example.motionandsharedanimation.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.motionandsharedanimation.databinding.FragmentDashboardBinding
import com.example.motionandsharedanimation.ui.dashboarddetail.DashboardDetailFragment

class DashboardFragment : Fragment(), DashboardCallback {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var cxt: Context
    private var _binding: FragmentDashboardBinding? = null
    private val b get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        cxt = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dashboardAdapter = DashboardAdapter(arrayListOf(), cxt, this)
        b.rvFeed.apply {
            layoutManager = LinearLayoutManager(cxt)
            adapter = dashboardAdapter
        }
        dashboardViewModel.getLiveHorizontalBlog().observe(viewLifecycleOwner, Observer {
            dashboardAdapter.updateFeed(it)
        })

        dashboardViewModel.setLiveHorizontalBlog()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemSelected(dashboardData: DashboardData, iv: ImageView, tv: TextView) {
        Navigation.findNavController(b.root).navigate(
            DashboardFragmentDirections.actionNavigationDashboardToFeedDetailFragment(
                dashboardData.imageUrl,
                dashboardData.titleName
            ), FragmentNavigatorExtras(
                iv to DashboardDetailFragment.SHARED_IMAGE_VIEW,
                tv to DashboardDetailFragment.SHARED_TEXT_VIEW
            )
        )
    }
}