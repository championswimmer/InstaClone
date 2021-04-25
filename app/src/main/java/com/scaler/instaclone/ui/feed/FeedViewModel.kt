package com.scaler.instaclone.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scaler.instaclone.data.ImgurRepo
import com.scaler.libimgur.models.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {


    private val _images = MutableLiveData<List<Image>>()
    val images: LiveData<List<Image>> = _images

    fun fetchFeed(section: String) = viewModelScope.launch(Dispatchers.IO) {
        when (section) {
            "hot" -> _images.postValue(ImgurRepo.getHotGallery())
            "top" -> _images.postValue(ImgurRepo.getTopGallery())
            else -> _images.postValue(ImgurRepo.getTopGallery())

        }
    }
}