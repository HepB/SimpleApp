package com.github.hepb.simpleapp.contract.model

import com.github.hepb.simpleapp.model.view.UiModel
import io.reactivex.Single

interface ItemRepo {
    fun getItems(): Single<List<UiModel>>
}