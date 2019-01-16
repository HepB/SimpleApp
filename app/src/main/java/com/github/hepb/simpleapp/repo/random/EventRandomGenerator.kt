package com.github.hepb.simpleapp.repo.random

import com.github.hepb.simpleapp.model.data.DataModel
import com.github.hepb.simpleapp.model.data.Event
import com.github.hepb.simpleapp.utils.nextEvent
import java.util.ArrayList
import java.util.Random

class EventRandomGenerator: ItemRandomGenerator {
    override fun generateItems(min: Int, max: Int): List<DataModel> {
        val random = Random()
        val result: MutableList<Event> = ArrayList()
        for (i in min..max) {
            result.add(random.nextEvent())
        }
        return result
    }
}