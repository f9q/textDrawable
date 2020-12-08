package com.example.textdrawable

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var percentTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        percentTextView = findViewById(R.id.percentTv)
    }
    fun textViewReSize(){
        val drawables = percentTextView.compoundDrawables
        val viewWidth = percentTextView.measuredWidth
        val viewHeight = percentTextView.measuredHeight
        val drawable = drawables[1]
        val height = (viewHeight * 0.8f).toInt()
        val width = (viewHeight * 0.8f).toInt()
        val top = /*drawable.intrinsicHeight / 2 - height / 2*/ 0
        val left = drawable.intrinsicWidth / 2 - width / 2
        drawable.bounds.set(Rect(left,top,left + width,top + height))
        drawable.invalidateSelf()
        percentTextView.compoundDrawablePadding = width
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus){
            textViewReSize()
        }
    }
    fun textViewReSize1(){
        val drawables = percentTextView.compoundDrawables
        val viewWidth = percentTextView.measuredWidth
        val viewHeight = percentTextView.measuredHeight
        val drawable = drawables[1]
        val height = (viewHeight * 0.8f).toInt()
        val width = (viewHeight * 0.8f).toInt()
        val top = 0
        val left = 0
        drawable.bounds.set(Rect(left,top,left + width,top + height))
        percentTextView.compoundDrawablePadding = width
        drawable.invalidateSelf()
    }
}