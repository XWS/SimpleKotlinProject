package zhaoh.com.kotlin.mykotlinproject.cityview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.GridView
import zhaoh.com.kotlin.mykotlinproject.modle.CityModle

/**
 * Created by vic on 2017/5/23.
 */
class SideBar @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attributeSet, defStyleAttr) {

    val letters = listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#")
    var choose: Int = -1
    var paint: Paint = Paint()

    init {
        setBackgroundColor(Color.parseColor("#F0F0F0"))
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val width = width
        val height = height
        val singleHeight = height / letters.size
        letters.forEachIndexed { index, letter ->
            paint.color = Color.parseColor("#606060")
            paint.typeface = Typeface.DEFAULT_BOLD
            paint.isAntiAlias = true
            paint.textSize = 20f
            if (choose == 1) {
                paint.color = Color.parseColor("#4F41FD")
                paint.isFakeBoldText = true
            }
            val xPos = width / 2 - paint.measureText(letter) / 2
            val yPos = singleHeight * index + paint.measureText(letter) / 2
            canvas?.drawText(letter, xPos, yPos, paint)
            paint.reset()
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(event)
    }
}