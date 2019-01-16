package com.github.hepb.simpleapp.ui

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.github.hepb.simpleapp.contract.presenter.DetailsPresenter
import com.github.hepb.simpleapp.contract.view.MvpDetailsActivity
import com.github.hepb.simpleapp.model.view.UiModel
import timber.log.Timber

abstract class BaseDetailsActivity : MvpAppCompatActivity(), MvpDetailsActivity {

    @InjectPresenter
    lateinit var presenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("1")
        if (intent != null) {
            Timber.d("2")
            val uiModel = intent.getSerializableExtra(EXTRA_UI_MODEL) as UiModel
            presenter.model = uiModel
        }
    }

    companion object {
        const val EXTRA_UI_MODEL = "uiModel"
    }
}