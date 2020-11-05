package com.demo.mvvmdemokt.mvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.mvvmdemokt.R
import com.demo.mvvmdemokt.mvvm.model.bean.BaseAdapterItem
import com.demo.mvvmdemokt.mvvm.view.RecyclerAdapter
import com.demo.mvvmdemokt.mvvm.viewmodel.MvvmVM
import kotlinx.android.synthetic.main.activity_mvvm.*

class MvvmActivity : AppCompatActivity() {

    private val mMvvmVM: MvvmVM by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)
        ).get(MvvmVM::class.java)
    }

    private val mAdapter: RecyclerAdapter by lazy {
        RecyclerAdapter(this)
    }

    private var mObserver = Observer<List<BaseAdapterItem>> {
        if (mAdapter == null) return@Observer
        mAdapter?.loadData(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
        initUI()
        initData()
    }

    fun initUI() {
        rv_content.layoutManager = LinearLayoutManager(applicationContext)
        rv_content.adapter = mAdapter
        bt_refresh.setOnClickListener {
            if (mAdapter == null) return@setOnClickListener
            mAdapter?.clearData()
            mMvvmVM.refreshData(applicationContext)
        }
        bt_load.setOnClickListener {
            mMvvmVM.loadData(applicationContext)
        }
    }

    fun initData() {
        mMvvmVM.getLiveData().observe(this, mObserver)
        mMvvmVM.refreshData(applicationContext)
    }

}
