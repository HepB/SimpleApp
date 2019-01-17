package com.github.hepb.simpleapp.repo.random

import com.github.hepb.simpleapp.model.data.DataModel
import com.github.hepb.simpleapp.model.data.Movie
import com.github.hepb.simpleapp.utils.nextMovie
import java.util.*

class MovieRandomGenerator: ItemRandomGenerator {
    override fun generateItems(count: Int): List<DataModel> {
        val random = Random()
        val result: MutableList<Movie> = ArrayList()
        for (i in 1..count) {
            result.add(random.nextMovie())
        }
        return result
    }
}