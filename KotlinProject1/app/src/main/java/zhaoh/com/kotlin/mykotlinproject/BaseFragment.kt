package zhaoh.com.kotlin.mykotlinproject

import android.app.Activity
import android.app.Fragment
import android.content.Context

/**
 * Created by 19208 on 2017/5/18.
 */

open class BaseFragment : Fragment() {

    protected var myContext: Activity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.myContext = context as Activity
    }
}
