package com.github.hepb.simpleapp.contract.view

import com.arellomobile.mvp.MvpView
import com.github.hepb.simpleapp.model.view.UiModel

interface MvpDetailsActivity: MvpView {
    fun setUiModel(uiModel: UiModel?)
}