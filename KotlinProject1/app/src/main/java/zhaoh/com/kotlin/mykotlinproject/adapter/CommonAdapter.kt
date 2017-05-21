package zhaoh.com.kotlin.mykotlinproject.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import zhaoh.com.kotlin.mykotlinproject.viewholder.MyViewHolder

/**
 * Created by 19208 on 2017/5/21.
 */
class CommonAdapter<T>(var LayoutRes: Int, var mData: List<T>) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onBindViewHolder(p0: MyViewHolder?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
}

