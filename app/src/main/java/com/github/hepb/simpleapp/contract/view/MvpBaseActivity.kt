package com.github.hepb.simpleapp.contract.view

import com.arellomobile.mvp.MvpView

interface MvpBaseActivity: MvpView {
    fun showError(throwable: Throwable)
}