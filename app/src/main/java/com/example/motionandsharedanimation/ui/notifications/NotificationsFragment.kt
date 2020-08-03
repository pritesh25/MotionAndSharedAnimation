package com.example.motionandsharedanimation.ui.notifications

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.motionandsharedanimation.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val b get() = _binding!!
    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var cxt: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        cxt = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notificationAdapter = NotificationAdapter(arrayListOf(), cxt)
        b.recyclerViewNotification.apply {
            layoutManager = LinearLayoutManager(cxt)
            adapter = notificationAdapter
        }

        notificationsViewModel.getNotificationList().observe(viewLifecycleOwner, Observer {
            notificationAdapter.updateFeed(it)
        })
    }
}