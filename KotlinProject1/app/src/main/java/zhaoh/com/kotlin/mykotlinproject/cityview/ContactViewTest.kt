package zhaoh.com.kotlin.mykotlinproject.cityview

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import zhaoh.com.kotlin.mykotlinproject.R
import zhaoh.com.kotlin.mykotlinproject.adapter.CommonAdapter

/**
 * Created by vic on 2017/5/19.
 */
class ContactViewTest : AppCompatActivity() {

    private var recycleView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contactview_activity_layout)

        init()
    }

    fun init(): Unit {
        recycleView = findViewById(R.id.recycleView) as RecyclerView
        recycleView?.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recycleView?.addItemDecoration(dividerItemDecoration)
    }
}