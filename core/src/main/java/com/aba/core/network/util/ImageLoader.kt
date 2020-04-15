package com.aba.core.network.util

import android.widget.ImageView

interface ImageLoader {

    fun loadImage(view: ImageView,
                  placeHolderId: Int,
                  errorPlaceHolderId: Int,
                  imageUrl: String)
}