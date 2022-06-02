package me.ztiany.arch.mvp.example

import android.os.Bundle
import com.android.base.delegate.simpl.DelegateActivity
import com.android.base.delegate.simpl.DelegateFragment
import me.ztiany.arch.delegate.example.R
import timber.log.Timber
import timber.log.Timber.DebugTree

class MainActivity : DelegateActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(DebugTree())

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.act_frag_container, DelegateFragment(), "DelegateFragment")
                .commit()
        }

    }

}