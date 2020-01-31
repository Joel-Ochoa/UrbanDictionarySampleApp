package com.example.urbandictionarysampleapp.view

import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.urbandictionarysampleapp.R

abstract class BaseActivity : AppCompatActivity() {

    lateinit var contentLoadingLayout : ConstraintLayout

    override fun setContentView(layoutResID: Int) {
        val baseLayout = layoutInflater.inflate(R.layout.activity_base, null)
        val activityFrame = baseLayout.findViewById<FrameLayout>(R.id.activity_frame)
        layoutInflater.inflate(layoutResID, activityFrame, true)
        super.setContentView(baseLayout)

        contentLoadingLayout = baseLayout.findViewById(R.id.loading_layout)

    }

    fun showLoadingBar() {
        contentLoadingLayout.visibility = View.VISIBLE
    }

    fun dismissLoadingBar() {
        contentLoadingLayout.visibility = View.GONE
    }

}