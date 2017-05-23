package zhaoh.com.kotlin.mykotlinproject.cityview

import android.content.Context
import android.util.AttributeSet
import android.widget.GridView

/**
 * Created by vic on 2017/5/23.
 */
open class MyGridView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0) : GridView(context, attributeSet, defStyleAttr) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val expendHeight = MeasureSpec.makeMeasureSpec(Int.MAX_VALUE shr 2, MeasureSpec.AT_MOST)
        super.onMeasure(widthMeasureSpec, expendHeight)
    }
}
