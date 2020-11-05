package com.demo.mvvmdemokt.mvp.model.data

data class MvpDataBean(
    var code: Int?,
    var `data`: List<Data>?
)

data class Data(
    var content: String?,
    var imageUrl: String?,
    var title: String?
)