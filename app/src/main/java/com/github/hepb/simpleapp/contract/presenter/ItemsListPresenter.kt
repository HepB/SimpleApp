package com.github.hepb.simpleapp.contract.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.github.hepb.simpleapp.App
import com.github.hepb.simpleapp.contract.view.MvpMainActivity
import com.github.hepb.simpleapp.model.view.UiModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

@InjectViewState
class ItemsListPresenter : MvpPresenter<MvpMainActivity>() {
    private val disposables: CompositeDisposable = CompositeDisposable()
    private val items: MutableList<UiModel> = ArrayList()

    fun getItems() {
        if(items.isNotEmpty()) {
            viewState.setItemsData(items)
        } else {
            getNewItems()
        }
    }

    fun getNewItems() {
        disposables.add(App.component.repo().getItems().subscribeBy(
            onSuccess = {
                viewState.onLoadingComplete()
                items.clear()
                items.addAll(it)
                viewState.setItemsData(items)
            },
            onError = {
                viewState.onLoadingComplete()
                viewState.showError(it)
            }
        ))
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

}