package com.demo.mvvmdemokt.mvvm.model.bean

import com.demo.mvvmdemokt.R

class MvvmDataBean2 {
    var code: Int? = null
    var `data`: List<Data>? = null

    class Data : BaseAdapterItem {

        override fun getItemViewType(): Int {
            return R.layout.item_mvvm2
        }

        var title: String? = null
        var content: String? = null
    }
}