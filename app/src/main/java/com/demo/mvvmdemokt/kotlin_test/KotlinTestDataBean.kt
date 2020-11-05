package com.demo.mvvmdemokt.kotlin_test

data class MainDataBean(
    var code: Int?,
    var `data`: List<Data>?
)

data class Data(
    var content: String?,
    var imageUrl: String?,
    var title: String?
)