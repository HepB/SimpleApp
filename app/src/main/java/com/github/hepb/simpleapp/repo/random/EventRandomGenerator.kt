package com.github.hepb.simpleapp.repo.random

import com.github.hepb.simpleapp.model.data.DataModel
import com.github.hepb.simpleapp.model.data.Event
import com.github.hepb.simpleapp.utils.nextInt
import io.github.benas.randombeans.api.EnhancedRandom
import java.util.Random

class EventRandomGenerator: ItemRandomGenerator {
    override fun generateItems(min: Int, max: Int): List<DataModel> {
        val random = Random()
        val numberOfEntities = random.nextInt(min..max)
        //EnchantedRandom можно было бы сконфигрурировать так, чтобы значения генерировались в заданных промежутках, но в условиях ограниченного времени тут и далее оставим так.
        return EnhancedRandom.randomListOf(numberOfEntities, Event::class.java)
    }
}