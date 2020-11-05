package com.demo.mvvmdemokt.mvp.model.imp

import android.content.Context
import android.os.Handler
import android.os.Message
import com.demo.mvvmdemokt.mvp.model.MvpDataModel
import com.demo.mvvmdemokt.mvp.present.MvpPMCallBack
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception

class MvpDataImp(context: Context, callback: MvpPMCallBack) :
    MvpDataModel {

    private val mContext = context
    private val mCallback = callback

    override fun getList() {
        Thread {
            var content = ""
            try {
                var buffReader =
                    BufferedReader(InputStreamReader(mContext.applicationContext.openFileInput("json")))
                buffReader.use {
                    while (true) content += it.readLine() ?: break
                }
                buffReader.close()
                var message = Message()
                message.what = 1
                mHandler.sendMessage(message)
            } catch (e: Exception) {
                var message = Message()
                message.what = 100
                mHandler.sendMessage(message)
            }
        }.start()
    }

    private var mHandler = Handler {
        if (it.what == 1) {
            var jsonString = it.obj
            mCallback.response(jsonString as Any)
        } else if (it.obj == 100) {
            mCallback.response(0 as Any)
        }
        false
    }

}