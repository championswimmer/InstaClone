package com.scaler.instaclone.ui.feed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.scaler.instaclone.R
import com.scaler.instaclone.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by viewModels()
    private lateinit var sectionType: String
    private lateinit var binding: FragmentFeedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ARG_KEY = resources.getString(R.string.arg_feed_section)
        sectionType = arguments?.getString(ARG_KEY) ?: "top" // TODO: make this an enum
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(inflater, container, false)

        binding.sectionTypeTextView.text = sectionType

        return binding.root
    }

}