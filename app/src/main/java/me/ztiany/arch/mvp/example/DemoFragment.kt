package me.ztiany.arch.mvp.example

import android.os.Bundle
import com.android.base.architecture.mvp.PresenterBinder
import com.android.base.delegate.simpl.DelegateFragment

class DemoFragment : DelegateFragment(), DemoView {

    private val presenter by lazy {
        DemoPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PresenterBinder.bind(this, this, presenter)
    }

    override fun showName(name: String) {

    }

}