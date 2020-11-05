package com.demo.mvvmdemokt.mvvm.model

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.demo.mvvmdemokt.mvvm.viewmodel.MvvmVMCallBack
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception

class MvvmDataModelImp : MvvmDataModel {

    override fun getData(context: Context, callback: MvvmVMCallBack) {
        Thread {
            var content = ""
            try {
                var buffReader =
                    BufferedReader(InputStreamReader(context.applicationContext.assets.open("json")))
                buffReader.use {
                    while (true) content += it.readLine() ?: break
                }
                buffReader.close()
                mHandler.post { callback.refreshRespose(content) }
            } catch (e: Exception) {
                e.printStackTrace()
                mHandler.post { callback.refreshRespose(e) }
            }
        }.start()
    }

    override fun loadData(context: Context, callback: MvvmVMCallBack) {
        Thread {
            var content = ""
            try {
                var buffReader =
                    BufferedReader(InputStreamReader(context.applicationContext.assets.open("json")))
                buffReader.use {
                    while (true) content += it.readLine() ?: break
                }
                buffReader.close()
                mHandler.post { callback.loadReponse(content) }
            } catch (e: Exception) {
                e.printStackTrace()
                mHandler.post { callback.loadReponse(e) }
            }
        }.start()
    }

    private var mHandler = Handler(Looper.getMainLooper())
}