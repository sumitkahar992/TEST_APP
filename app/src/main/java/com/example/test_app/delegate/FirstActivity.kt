package com.example.test_app.delegate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent

class FirstActivity : AppCompatActivity(), Toast by ToastImpl(), HardwareObserver by HardwareChanges() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {  }

        showToast(this, "First Activity")

        batteryChanges()

        networkObserver()

    }


}