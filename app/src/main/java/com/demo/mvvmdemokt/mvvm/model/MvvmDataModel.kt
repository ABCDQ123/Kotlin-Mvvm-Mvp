package com.demo.mvvmdemokt.mvvm.model

import android.content.Context
import com.demo.mvvmdemokt.mvvm.viewmodel.MvvmVMCallBack

interface MvvmDataModel {
    fun getData(context: Context, callback: MvvmVMCallBack)
    fun loadData(context: Context, callback: MvvmVMCallBack)
}