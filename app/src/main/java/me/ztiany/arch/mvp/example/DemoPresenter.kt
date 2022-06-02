package me.ztiany.arch.mvp.example

import com.android.base.architecture.mvp.RxPresenter

class DemoPresenter : RxPresenter<DemoView>() {

    fun loadName() {
        view?.showName("Alien")
    }

}