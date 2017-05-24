package zhaoh.com.kotlin.mykotlinproject.recycleabout

import android.content.Context
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View
import zhaoh.com.kotlin.mykotlinproject.bean.CityBean

/**
 * Created by 19208 on 2017/5/24.
 */
class TitleItemDecoration(context: Context, mData: ArrayList<CityBean>) : RecyclerView.ItemDecoration() {

    var mTitleHeight: Int
    var mTitleSize: Int
    var mPaint: Paint? = null
    var mData: ArrayList<CityBean>? = null
    var context: Context? = null
    var mBounds: Rect? = null
    val COLOR_TITLE_BG = Int
    val COLOR_TITLE_FONT = Int

    init {

        this.context = context
        this.mData = mData
        mTitleHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30f, context.resources.displayMetrics).toInt()
        mTitleSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16f, context.resources.displayMetrics).toInt()
        mBounds = Rect()
        mPaint = Paint()
        mPaint?.textSize = mTitleSize.toFloat()
        mPaint?.isAntiAlias = true
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = (view?.layoutParams as RecyclerView.LayoutParams).viewLayoutPosition
        if (position > -1) {
            if (position == 0) {
                outRect?.set(0, mTitleHeight, 0, 0)
            } else {
                if (mData!![position].tag != mData!![position - 1].tag) {
                    outRect?.set(0, mTitleHeight, 0, 0)
                } else {
                    outRect?.set(0, 0, 0, 0)
                }
            }
        }
    }
}