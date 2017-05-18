package zhaoh.com.kotlin.mykotlinproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by 19208 on 2017/5/18.
 */

class NotificationsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.notifications_layout_fragment, container, false)
    }
}
