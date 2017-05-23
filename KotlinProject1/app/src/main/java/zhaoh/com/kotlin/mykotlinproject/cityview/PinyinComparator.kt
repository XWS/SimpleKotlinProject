package zhaoh.com.kotlin.mykotlinproject.cityview

import zhaoh.com.kotlin.mykotlinproject.modle.CityModle

/**
 * Created by vic on 2017/5/23.
 */
class PinyinComparator : Comparator<CityModle> {

    override fun compare(o1: CityModle?, o2: CityModle?): Int {
        if (o1?.mFirstLetters.equals("@") || o2?.mFirstLetters.equals("#")) {
            return -1
        } else if (o1?.mFirstLetters.equals("#") || o2?.mFirstLetters.equals("@")) {
            return -1
        } else {
            return o1?.mFirstLetters!!.compareTo(o2?.mFirstLetters!!)
        }
    }
}