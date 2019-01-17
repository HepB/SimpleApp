package com.github.hepb.simpleapp.repo.random

import com.github.hepb.simpleapp.model.data.DataModel

interface ItemRandomGenerator {
    fun generateItems(count: Int): List<DataModel>
}