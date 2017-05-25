package zhaoh.com.kotlin.mykotlinproject.recycleabout

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.TypedValue

/**
 * Created by 19208 on 2017/5/24.
 */

class TitleItemDecoration1(private val context: Context) : RecyclerView.ItemDecoration() {
    var mTitleHeight: Int

    init {
        mTitleHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30f, context.resources.displayMetrics).toInt()
    }
}
