package com.example.motionandsharedanimation.ui.notifications

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.motionandsharedanimation.databinding.FragmentNotificationDetailBinding

class NotificationDetailFragment : Fragment() {

    private var _binding: FragmentNotificationDetailBinding? = null
    private val b get() = _binding!!
    private lateinit var cxt: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        cxt = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationDetailBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}