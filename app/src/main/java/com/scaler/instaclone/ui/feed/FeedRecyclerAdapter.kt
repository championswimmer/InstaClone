package com.scaler.instaclone.ui.feed

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.scaler.instaclone.R
import com.scaler.instaclone.databinding.ListItemImageBinding
import com.scaler.libimgur.models.Image

class FeedRecyclerAdapter() :
    ListAdapter<Image, FeedRecyclerAdapter.FeedImageViewHolder>(FeedImageDiffCallback()) {

    class FeedImageDiffCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean =
            oldItem == newItem


        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean =
            oldItem === newItem


    }

    class FeedImageViewHolder(val binding: ListItemImageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedImageViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemImageBinding.inflate(inflater, parent, false)
        return FeedImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedImageViewHolder, position: Int) {
        val image = getItem(position)!!

        val imageUrl = if (image.isAlbum == true && image.imagesCount != 0) {
            val firstImage = image.images?.get(0)
            firstImage?.link
        } else {
            image.link
        }

        holder.binding.descTextView.text = image.title
        holder.binding.imageView.load(imageUrl) {
            placeholder(R.drawable.placeholder)
        }


    }
}