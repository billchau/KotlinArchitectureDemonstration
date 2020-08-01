package com.gamerbill.kotlinarchitecturedemo.demolibrary.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gamerbill.kotlinarchitecturedemo.demolibrary.R

fun AppCompatActivity.replace(
    fragment: Fragment,
    container: Int = R.id.content,
    backAllowed: Boolean = true,
    stackName: String = fragment.javaClass.canonicalName,
    keepState: Boolean = false
) {
    supportFragmentManager.beginTransaction().apply {
        replace(container, fragment, stackName)
        if (backAllowed) addToBackStack(stackName)
        if (keepState) commit() else commitAllowingStateLoss()
    }
}