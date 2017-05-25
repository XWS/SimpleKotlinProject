package zhaoh.com.kotlin.mykotlinproject.recycleabout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.widget.LinearLayoutManager
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
    var mBounds: Rect? = null   //用于存放测量文字Rect
    val COLOR_TITLE_BG: Int
    val COLOR_TITLE_FONT: Int

    init {

        this.context = context
        this.mData = mData
        mTitleHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30f, context.resources.displayMetrics).toInt()
        mTitleSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16f, context.resources.displayMetrics).toInt()
        mBounds = Rect()
        mPaint = Paint()
        mPaint?.textSize = mTitleSize.toFloat()
        mPaint?.isAntiAlias = true
        COLOR_TITLE_BG = Color.parseColor("#FF050505")
        COLOR_TITLE_FONT = Color.parseColor("#FF000000")
    }

    override fun onDraw(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)
        val left = parent?.paddingLeft
        val right = parent?.width!! - parent.paddingRight
        val childCount = parent.childCount
        var index = 0
        while (index < childCount) {
            val childView = parent.getChildAt(index)
            val layoutParams = childView.layoutParams as RecyclerView.LayoutParams
            val positon = layoutParams.viewLayoutPosition
            if (positon == 0 || (mData!![index - 1].tag == mData!![positon].tag)) {
                drawTitleArea(c, left!!, right, childView, layoutParams, index)
            }
            index++
        }
    }

    fun drawTitleArea(c: Canvas?, left: Int, right: Int, childView: View, layoutParams: RecyclerView.LayoutParams, postion: Int) {
        mPaint?.color = COLOR_TITLE_BG
        c?.drawRect(left.toFloat(), (childView.top - layoutParams.topMargin - mTitleHeight).toFloat(), right.toFloat(), (childView.top - layoutParams.topMargin).toFloat(), mPaint)
        mPaint?.color = COLOR_TITLE_FONT
        mPaint?.getTextBounds(mData!![postion].tag, 0, mData!![postion].tag.length, mBounds)
        c?.drawText(mData!![postion].tag, childView.paddingStart.toFloat(), (childView.top - layoutParams.topMargin - (mTitleHeight / 2 - mBounds!!.height() / 2)).toFloat(), mPaint)
    }

    override fun onDrawOver(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.onDrawOver(c, parent, state)
        val postion = (parent?.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        val tag = mData!![postion].tag
        var childView = parent.getChildAt(postion)

        mPaint?.color = COLOR_TITLE_BG
        c?.drawRect(parent.paddingLeft.toFloat(), parent.paddingTop.toFloat(), (parent.right - parent.paddingRight).toFloat(), (parent.paddingTop + mTitleHeight).toFloat(), mPaint)
        mPaint?.color = COLOR_TITLE_FONT
        mPaint?.getTextBounds(tag, 0, tag.length, mBounds)
        c?.drawText(tag, childView.paddingLeft.toFloat(), (parent.paddingTop + mTitleHeight - (mTitleHeight / 2 - mBounds!!.height() / 2)).toFloat(), mPaint)
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