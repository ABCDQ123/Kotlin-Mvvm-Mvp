package com.demo.mvvmdemokt

import android.Manifest
import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Message
import androidx.core.app.ActivityCompat

object PermissionController {

    private var mPermissions = arrayOf(
        Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @JvmStatic
    fun apply(context: Context) {
        ActivityCompat.requestPermissions(context as Activity, mPermissions, 1)
    }

}