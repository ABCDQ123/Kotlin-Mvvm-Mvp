package com.demo.mvvmdemokt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.mvvmdemokt.kotlin_test.KotlinTestActivity
import com.demo.mvvmdemokt.mvp.view.MvpActivity
import com.demo.mvvmdemokt.mvvm.MvvmActivity
import kotlinx.android.synthetic.main.activity_launch.*

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        PermissionController.apply(this)
        bt_kotlin_test.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    KotlinTestActivity::class.java
                )
            )
        }
        bt_kotlin_mvp.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MvpActivity::class.java
                )
            )
        }
        bt_kotlin_mvvm.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MvvmActivity::class.java
                )
            )
        }
    }
}
