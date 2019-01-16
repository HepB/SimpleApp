package com.github.hepb.simpleapp.contract.view

import com.github.hepb.simpleapp.model.view.UiModel

interface MvpMainActivity: MvpBaseActivity {
    fun setItemsData(items: List<UiModel>)
    fun onLoading()
    fun onLoadingComplete()
}