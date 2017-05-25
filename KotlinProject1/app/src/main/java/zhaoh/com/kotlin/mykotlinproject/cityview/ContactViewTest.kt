package zhaoh.com.kotlin.mykotlinproject.cityview

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import zhaoh.com.kotlin.mykotlinproject.R
import zhaoh.com.kotlin.mykotlinproject.adapter.CommonAdapter
import zhaoh.com.kotlin.mykotlinproject.bean.CityBean

/**
 * Created by vic on 2017/5/19.
 */
class ContactViewTest : AppCompatActivity() {

    private var recycleView: RecyclerView? = null
    private val mData = listOf(
            CityBean("A", "安徽")
            , CityBean("B", "北京")
            , CityBean("F", "福建")
            , CityBean("G", "广东")
            , CityBean("G", "甘肃")
            , CityBean("G", "贵州")
            , CityBean("G", "广西")
            , CityBean("H", "河南")
            , CityBean("H", "湖北")
            , CityBean("H", "湖南")
            , CityBean("H", "河北")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("J", "江苏")
            , CityBean("R", "日本")
            , CityBean("R", "日本")
            , CityBean("R", "日本")
            , CityBean("R", "日本"))

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