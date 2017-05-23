package zhaoh.com.kotlin.mykotlinproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import zhaoh.com.kotlin.mykotlinproject.cityview.ContactViewTest

/**
 * Created by 19208 on 2017/5/18.
 */

class MainFragment : BaseFragment(), View.OnClickListener {

    override fun onClick(v: View?) {
        when (id) {
            R.id.contactViewBtn -> {
                val intent = Intent(myContext, ContactViewTest::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.main_layout_fragment, container, false)
    }
}
