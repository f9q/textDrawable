package com.example.textdrawable

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewTreeObserver
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var percentTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        percentTextView = findViewById(R.id.percentTv)
        percentTextView.resetDrawableSize()
    }
    fun TextView.resetDrawableSize(){
        this.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener{
            override fun onPreDraw(): Boolean {
                val drawables = compoundDrawables
                val viewWidth = measuredWidth
                val viewHeight = measuredHeight
                val drawable = drawables[1]
                val height = (viewHeight * 0.7f).toInt()
                val width = (viewHeight * 0.7f).toInt()
                val top = /*drawable.intrinsicHeight / 2 - height / 2*/ 0
                val left = drawable.intrinsicWidth / 2 - width / 2
                drawable.bounds.set(Rect(left,top,left + width,top + height))
                compoundDrawablePadding = width
                drawable.invalidateSelf()
                viewTreeObserver.removeOnPreDrawListener(this )
                return true
            }
        })
    }
}