package com.example.test_app.delegate

interface HardwareObserver {

    fun networkObserver()
    fun batteryChanges()
}




class HardwareChanges : HardwareObserver {
    override fun networkObserver() {

    }

    override fun batteryChanges() {

    }

}