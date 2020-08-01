package com.gamerbill.kotlinarchitecturedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gamerbill.kotlinarchitecturedemo.democontract.DemoFeature
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init () {
        val fragment = DashboardFragment()
        fragment.retainInstance = true
        supportFragmentManager.beginTransaction()
            .replace(R.id.content, fragment)
            .commit()
    }
}
