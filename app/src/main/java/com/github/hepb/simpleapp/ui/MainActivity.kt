package com.github.hepb.simpleapp.ui

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.github.hepb.simpleapp.R
import com.github.hepb.simpleapp.contract.presenter.ItemsListPresenter
import com.github.hepb.simpleapp.contract.view.MvpMainActivity
import com.github.hepb.simpleapp.model.view.UiModel
import com.github.hepb.simpleapp.ui.adapter.UIModelAdapter
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : MvpAppCompatActivity(), MvpMainActivity {

    @InjectPresenter
    lateinit var presenter: ItemsListPresenter

    private lateinit var itemsRecycler: RecyclerView
    private lateinit var adapter: UIModelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itemsRecycler = detailsList
        initRecycler()
        initSwipeRefreshLayout()
        presenter.getItems()
    }

    private fun initSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener { presenter.getNewItems() }
    }

    private fun initRecycler() {
        adapter = UIModelAdapter()
        itemsRecycler.adapter = adapter
    }

    override fun setItemsData(items: List<UiModel>) {
        Timber.d("Items: ${items.size}")
        adapter.items.clear()
        adapter.items.addAll(items)
        adapter.notifyDataSetChanged()
    }

    override fun onLoading() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun onLoadingComplete() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showError(throwable: Throwable) {
        Snackbar.make(itemsRecycler, throwable.localizedMessage, Snackbar.LENGTH_LONG).show()
    }
}
