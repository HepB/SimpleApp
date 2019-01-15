package com.github.hepb.simpleapp.repo.random

import com.github.hepb.simpleapp.model.data.DataModel
import java.time.LocalDate
import java.util.*

interface ItemRandomGenerator {
    fun generateItems(min: Int, max: Int): List<DataModel>
}