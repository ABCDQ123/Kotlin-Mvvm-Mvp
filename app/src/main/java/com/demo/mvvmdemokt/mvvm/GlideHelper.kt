package com.demo.mvvmdemokt.mvvm

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

object GlideHelper {

    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context.applicationContext).load("" + url).into(imageView)
    }

    @BindingAdapter("app:imageHeadUrl")
    @JvmStatic
    fun loadImageHead(imageView: ImageView, url: String) {
        Glide.with(imageView.context.applicationContext).load("" + url).centerCrop().into(imageView)
    }
}