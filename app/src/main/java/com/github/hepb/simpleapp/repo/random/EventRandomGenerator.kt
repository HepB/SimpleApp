package com.github.hepb.simpleapp.repo.random

import com.github.hepb.simpleapp.model.data.DataModel
import com.github.hepb.simpleapp.model.data.Event
import com.github.hepb.simpleapp.utils.nextEvent
import java.util.ArrayList
import java.util.Random

class EventRandomGenerator: ItemRandomGenerator {
    override fun generateItems(count: Int): List<DataModel> {
        val random = Random()
        val result: MutableList<Event> = ArrayList()
        for (i in 1..count) {
            result.add(random.nextEvent())
        }
        return result
    }
}