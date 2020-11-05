package com.demo.mvvmdemokt.mvvm.model.bean

import com.demo.mvvmdemokt.R

class MvvmDataBean1 {
    var code: Int? = null
    var `data`: List<Data>? = null

    class Data : BaseAdapterItem {
        override fun getItemViewType(): Int {
            return R.layout.item_mvvm1
        }

        var title: String? = "默认标题"
        var content: String? = null
        var imageUrl: String? = null
    }
}