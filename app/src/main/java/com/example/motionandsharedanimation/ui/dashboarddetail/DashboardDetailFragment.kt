package com.example.motionandsharedanimation.ui.dashboarddetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import coil.load
import com.example.motionandsharedanimation.databinding.FeedFragmentBinding

class DashboardDetailFragment : Fragment() {

    private val mTag = "FeedDetailFragment"

    private var _binding: FeedFragmentBinding? = null
    private val b get() = _binding!!

    companion object {
        const val SHARED_IMAGE_VIEW = "shared_image_view"
        const val SHARED_TEXT_VIEW = "shared_text_view"
    }

    private lateinit var cxt: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        cxt = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(cxt).inflateTransition(android.R.transition.explode)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FeedFragmentBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {

            b.tvFeedDetailTitle.apply {
                transitionName =
                    SHARED_TEXT_VIEW
                text = DashboardDetailFragmentArgs.fromBundle(
                    it
                ).ImageTitle
            }

            b.ivFeedDetailImage.apply {
                transitionName =
                    SHARED_IMAGE_VIEW
                this.load(DashboardDetailFragmentArgs.fromBundle(it).ImageUrl)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}