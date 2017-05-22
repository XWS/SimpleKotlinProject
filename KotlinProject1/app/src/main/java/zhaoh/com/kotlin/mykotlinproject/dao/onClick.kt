package zhaoh.com.kotlin.mykotlinproject.dao

/**
 * Created by vic on 2017/5/22.
 */
open interface onClick<in Int> {
    fun call(position: Int) {}
}