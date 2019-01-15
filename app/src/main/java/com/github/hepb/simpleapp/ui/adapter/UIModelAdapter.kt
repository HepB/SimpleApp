package com.github.hepb.simpleapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.github.hepb.simpleapp.model.view.UiModel

class UIModelAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val items: MutableList<UiModel> = ArrayList()

    override fun getItemViewType(position: Int) = items[position].getType()
    override fun getItemCount(): Int = items.size


    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}