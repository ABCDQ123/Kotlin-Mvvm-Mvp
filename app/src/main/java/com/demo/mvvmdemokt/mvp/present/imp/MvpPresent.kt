package com.demo.mvvmdemokt.mvp.present.imp

import android.content.Context
import androidx.core.content.ContextCompat
import com.demo.mvvmdemokt.R
import com.demo.mvvmdemokt.mvp.model.imp.MvpDataImp
import com.demo.mvvmdemokt.mvp.model.data.MvpDataBean
import com.demo.mvvmdemokt.mvp.model.MvpDataModel
import com.demo.mvvmdemokt.mvp.present.MvpPMCallBack
import com.demo.mvvmdemokt.mvp.present.MvpPVCallBack
import com.demo.mvvmdemokt.mvp.view.MvpViewModel
import com.google.gson.Gson

class MvpPresent(context: Context, view: MvpViewModel) : MvpPVCallBack, MvpPMCallBack {

    private var mContext = context
    private var mDataModel: MvpDataModel? = MvpDataImp(context, this)
    private var mView: MvpViewModel? = view

    override fun getData(position: Int) {
        if (mDataModel == null) return
        mDataModel?.getList()
    }

    override fun destroy() {
        mDataModel = null
        mView = null
    }

    override fun response(data: Any) {
        if (mView == null) return
        var dataBean = Gson().fromJson<MvpDataBean>(data.toString(), MvpDataBean::class.java)
        var view = mView?.getAdapter()
        view?.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorAccent))
    }

}