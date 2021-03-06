package com.android.base.architecture.mvp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.android.base.delegate.fragment.FragmentDelegate
import com.android.base.delegate.fragment.FragmentDelegateOwner

class PresenterBinder constructor(private val lifecycle: Lifecycle) : FragmentDelegate<Fragment> {

    private var isCalled: Boolean = false
    private var host: Fragment? = null

    override fun onAttachToFragment(fragment: Fragment) {
        host = fragment
    }

    override fun onDetachFromFragment() {
        host = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        if (!isCalled) {
            lifecycle.onStart()
            val activity = host?.activity
            activity?.findViewById<View>(android.R.id.content)?.post { lifecycle.onPostStart() }
            isCalled = true
        }
    }

    override fun onResume() {
        lifecycle.onResume()
    }

    override fun onPause() {
        lifecycle.onPause()
    }

    override fun onDestroy() {
        lifecycle.onDestroy()
    }

    companion object {

        fun <V : IBaseView> bind(
            fragmentDelegateOwner: FragmentDelegateOwner,
            v: V,
            p: IPresenter<V>
        ): PresenterBinder {
            p.bindView(v)
            val lifecycleDelegate = PresenterBinder(p)
            fragmentDelegateOwner.addDelegate(lifecycleDelegate)
            return lifecycleDelegate
        }
    }

}

fun <V : IBaseView> FragmentDelegateOwner.bindPresenter(v: V, p: IPresenter<V>): PresenterBinder {
    p.bindView(v)
    val lifecycleDelegate = PresenterBinder(p)
    addDelegate(lifecycleDelegate)
    return lifecycleDelegate
}
