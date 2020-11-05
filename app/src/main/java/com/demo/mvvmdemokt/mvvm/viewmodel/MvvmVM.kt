package com.demo.mvvmdemokt.mvvm.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.mvvmdemokt.mvp.model.data.MvpDataBean
import com.demo.mvvmdemokt.mvvm.model.MvvmDataModel
import com.demo.mvvmdemokt.mvvm.model.MvvmDataModelImp
import com.demo.mvvmdemokt.mvvm.model.bean.BaseAdapterItem
import com.demo.mvvmdemokt.mvvm.model.bean.MvvmDataBean1
import com.demo.mvvmdemokt.mvvm.model.bean.MvvmDataBean2
import com.google.gson.Gson
import java.lang.Exception

class MvvmVM : ViewModel(), MvvmVMCallBack {

    private var mModel: MvvmDataModel = MvvmDataModelImp()
    private var mPosition = 1

    fun refreshData(context: Context) {
        mPosition = 1
        mModel.getData(context, this)
    }

    fun loadData(context: Context) {
        mPosition++
        mModel.loadData(context, this)
    }

    private var mLiveData: MutableLiveData<List<BaseAdapterItem>>? = null

    fun getLiveData(): MutableLiveData<List<BaseAdapterItem>> {
        if (mLiveData == null) mLiveData = MutableLiveData()
        return mLiveData as MutableLiveData<List<BaseAdapterItem>>
    }

    override fun refreshRespose(resposne: Any) {
        if (resposne is Exception) {
        } else {
            var dataBean =
                Gson().fromJson<MvvmDataBean1>(resposne.toString(), MvvmDataBean1::class.java)
            mLiveData?.value = dataBean.data
        }
    }

    override fun loadReponse(resposne: Any) {
        if (resposne is Exception) {
        } else {
            var dataBean =
                Gson().fromJson<MvvmDataBean2>(resposne.toString(), MvvmDataBean2::class.java)
            mLiveData?.value = dataBean.data
        }
    }
}