package com.technorapper.kotlinpracsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.technorapper.kotlinpracsi.fragment.SecondFragment
import com.technorapper.kotlinpracsi.fragment.BlankFragment

open class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainActivityViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnStart).setOnClickListener {
            //finish()
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }
        findViewById<Button>(R.id.btnStartFragment).setOnClickListener {
            addFragment(R.id.flContainer, BlankFragment(),"")

        }
        findViewById<Button>(R.id.btnStartSecondFragment).setOnClickListener {
            addFragment(R.id.flContainer, SecondFragment(),"")

        }
        viewModel.testSime()
    }
 fun test(){}
    override fun onDestroy() {
        super.onDestroy()
    }
    protected fun addFragment(
        @IdRes containerViewId: Int,
        fragment: Fragment,
        fragmentTag: String
    ) {
        supportFragmentManager
            .beginTransaction()
            .add(containerViewId, fragment, fragmentTag)

            //  .disallowAddToBackStack()
            .addToBackStack(null)
            .commit()
    }
}