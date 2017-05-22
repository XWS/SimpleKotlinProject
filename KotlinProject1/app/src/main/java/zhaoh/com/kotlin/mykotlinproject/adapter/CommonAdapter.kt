package zhaoh.com.kotlin.mykotlinproject.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import zhaoh.com.kotlin.mykotlinproject.BR
import zhaoh.com.kotlin.mykotlinproject.dao.onClick
import zhaoh.com.kotlin.mykotlinproject.viewholder.MyViewHolder

/**
 * Created by 19208 on 2017/5/21.
 */
open class CommonAdapter<T>(var LayoutRes: Int, var mData: List<T>) : RecyclerView.Adapter<MyViewHolder>() {

    private var onItemClickListen: onClick<Int>? = null

    override fun onBindViewHolder(p0: MyViewHolder?, p1: Int) {
        var mBinging = p0?.getBinding()
        mBinging?.setVariable(BR.item, mData[p1])
        if (onItemClickListen != null) {
            p0?.itemView?.setOnClickListener {
                onItemClickListen?.call(p1)
                mBinging?.root
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    /**
     * 返回viewType的类型
     */
    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    /**
     * 主要作用是把view传给viewHolder
     */
    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(p0?.context)
        val view = layoutInflater.inflate(LayoutRes, p0)//此view可以根据viewType返回不同的View
        return MyViewHolder(view)
    }

    open fun setOnItemClickListener(onItemClickListen: onClick<Int>?): Unit {
        this.onItemClickListen = onItemClickListen
    }
}

