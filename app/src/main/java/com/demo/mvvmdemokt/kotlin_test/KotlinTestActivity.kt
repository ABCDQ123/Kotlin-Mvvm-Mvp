package com.demo.mvvmdemokt.kotlin_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.demo.mvvmdemokt.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_kotlin_test.*
import java.io.BufferedReader
import java.io.InputStreamReader

class KotlinTestActivity : AppCompatActivity() {

    private val mImageUrlArray = arrayOf("www.baidu.com", "www.taobao.com")
    private val mNumbers = Array(3) { i -> (i * 1) } // 0 1 2

    private lateinit var mDataBean: MainDataBean
    private var jsonString: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_test)
//        nullTest()
//        forTest()
//        for (i in mImageUrlArray[0]) Log.e("遍历字符串 ", " $i")
//        for (i in mNumbers) Log.e("遍历数组 ", " $i")
//        loop@ for (i in 0..10) if (i == 2) break@loop // break
//        mNumbers.forEach { if (it == 2) return }
//        mImageUrlArray.forEach { if (it == "www.taobao.com") return }
    }

    override fun onStart() {
        super.onStart()
        if (jsonString == null) init()
    }

    private fun init() {
        BufferedReader(InputStreamReader(applicationContext.assets.open("json"))).use {
            while (true) jsonString += it.readLine() ?: break
        }
        mDataBean = Gson().fromJson<MainDataBean>(jsonString, MainDataBean::class.java)
        tv_content.text = "kotlin: " + mDataBean.data?.get(0)?.content;
    }

    private var mContent: String? = null
    private fun nullTest() {
        //是否是String
        if (mContent is String) Log.e("=== String ", " $mContent")
        //为null不处理
        val m1 = mContent?.toInt()
        Log.e("null return ", " $m1")
        //为null则返回？
        val m2 = mContent?.toInt() ?: -1
        Log.e("null ? xx : null ", " $m2")
        //为null报错
        val m3 = mContent!!.toInt()
        Log.e("null exception ", " $m3")
    }

    private fun forTest() {
        for (i in 0..4) Log.e("forTest ", " $i") // 输出 0 1 2 3 4
//        for (i in 0..4 step 2) Log.e("forTest ", " $i") // 输出 0 2 4
//        for (i in 4 downTo 0 step 2) Log.e("forTest ", " $i") // 输出 4 2 0
//        for (i in 0 until 4) Log.e("forTest ", " $i") // 输出 0 1 2 3
    }
}
