package zhaoh.com.kotlin.mykotlinproject.viewholder

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by 19208 on 2017/5/21.
 */

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val mBinding: ViewDataBinding = DataBindingUtil.bind(itemView)

    fun getBinding(): ViewDataBinding {
        return mBinding
    }
}
