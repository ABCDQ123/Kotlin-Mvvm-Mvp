package com.demo.mvvmdemokt.mvvm.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.demo.mvvmdemokt.R
import com.demo.mvvmdemokt.databinding.ItemMvvm1Binding
import com.demo.mvvmdemokt.databinding.ItemMvvm2Binding
import com.demo.mvvmdemokt.mvvm.model.bean.BaseAdapterItem
import com.demo.mvvmdemokt.mvvm.model.bean.MvvmDataBean1
import com.demo.mvvmdemokt.mvvm.model.bean.MvvmDataBean2

class RecyclerAdapter(context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mContext: Context = context
    private var mItems: ArrayList<BaseAdapterItem> = ArrayList()

    fun clearData() {
        mItems.clear()
        notifyDataSetChanged()
    }

    fun loadData(list: List<BaseAdapterItem>) {
        mItems.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return mItems.get(position).getItemViewType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == R.layout.item_mvvm1) {
            var itemBindg1 = DataBindingUtil.inflate<ItemMvvm1Binding>(
                LayoutInflater.from(mContext),
                R.layout.item_mvvm1,
                parent,
                false
            )
            return RecyclerHolder1(itemBindg1)
        } else {
            var itemBindg2 = DataBindingUtil.inflate<ItemMvvm2Binding>(
                LayoutInflater.from(mContext),
                R.layout.item_mvvm2,
                parent,
                false
            )
            return RecyclerHolder2(itemBindg2)
        }
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RecyclerHolder1) {
            holder.mBingding.data = mItems[position] as MvvmDataBean1.Data
            holder.mBingding.executePendingBindings()
            holder.mBingding.igImage.setOnClickListener {
                Toast.makeText(
                    mContext.applicationContext,
                    "布局1图片",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else if (holder is RecyclerHolder2) {
            holder.mBingding.data = mItems[position] as MvvmDataBean2.Data
            holder.mBingding.executePendingBindings()
            holder.mBingding.tvTitle.setOnClickListener {
                Toast.makeText(
                    mContext.applicationContext,
                    "布局2标题",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    class RecyclerHolder1(bingding: ItemMvvm1Binding) :
        RecyclerView.ViewHolder(bingding.root) {
        var mBingding = bingding
    }

    class RecyclerHolder2(bingding: ItemMvvm2Binding) :
        RecyclerView.ViewHolder(bingding.root) {
        var mBingding = bingding
    }
}