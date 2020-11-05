package com.demo.mvvmdemokt.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.demo.mvvmdemokt.R
import com.demo.mvvmdemokt.mvp.present.imp.MvpPresent
import com.demo.mvvmdemokt.mvp.present.MvpPVCallBack
import kotlinx.android.synthetic.main.activity_mvp.*

class MvpActivity : AppCompatActivity(), MvpViewModel {

    private lateinit var mPresent: MvpPVCallBack

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        mPresent = MvpPresent(applicationContext, this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresent.destroy()
    }

    override fun viewCharge() {
        Toast.makeText(applicationContext, "数据已获取", Toast.LENGTH_SHORT).show()
    }

    override fun getAdapter(): View {
        return v_background
    }
}
