package me.ztiany.arch.mvp.example

import com.android.base.architecture.mvp.IBaseView

interface DemoView : IBaseView {

    fun showName(name: String)

}