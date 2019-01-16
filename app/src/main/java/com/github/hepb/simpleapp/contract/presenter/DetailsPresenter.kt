package com.github.hepb.simpleapp.contract.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.hepb.simpleapp.contract.view.MvpDetailsActivity
import com.github.hepb.simpleapp.model.view.UiModel

@InjectViewState
class DetailsPresenter : MvpPresenter<MvpDetailsActivity>() {
    var model: UiModel? = null
        set(value) {
            viewState.setUiModel(value)
        }
}