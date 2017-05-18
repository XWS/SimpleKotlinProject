package zhaoh.com.kotlin.mykotlinproject

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val fragments = ArrayList<Fragment>()
    val fragmentTags = listOf("mainFragment", "dashboardFragment", "notificationsFragment")
    var currentFragment: Fragment? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                switcherFragment(fragments[0], 0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                switcherFragment(fragments[1], 1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                switcherFragment(fragments[2], 2)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun switcherFragment(toFragment: Fragment, position: Int): Unit {

        if (currentFragment != toFragment) {
            if (toFragment.isAdded) {
                fragmentManager.beginTransaction().hide(currentFragment).show(toFragment).commit()
            } else {
                fragmentManager.beginTransaction().hide(currentFragment).add(R.id.contain, toFragment, fragmentTags.get(position)).commit()
            }
            currentFragment = toFragment
        }
    }

    fun init(): Unit {
        val mainFragment = MainFragment()
        val dashboardFragment = DashboardFragment()
        val notificationsFragment = NotificationsFragment()
        fragments.add(mainFragment)
        fragments.add(dashboardFragment)
        fragments.add(notificationsFragment)

        fragmentManager.beginTransaction().add(R.id.contain, mainFragment).commit()
        currentFragment = mainFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
