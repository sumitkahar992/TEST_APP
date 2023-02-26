package com.example.test_app.delegate

import android.content.Context


interface Toast {
    fun showToast(context: Context, string: String)
}



class ToastImpl : Toast {
    override fun showToast(context: Context, string: String) {
        android.widget.Toast.makeText(context, string, android.widget.Toast.LENGTH_SHORT).show()
    }

}