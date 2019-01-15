package com.github.hepb.simpleapp.repo.random

import com.github.hepb.simpleapp.model.data.DataModel
import com.github.hepb.simpleapp.model.data.Notice
import com.github.hepb.simpleapp.utils.nextInt
import io.github.benas.randombeans.api.EnhancedRandom
import java.util.*

class NoticeRandomGenerator: ItemRandomGenerator {
    override fun generateItems(min: Int, max: Int): List<DataModel> {
        val random = Random()
        val numberOfEntities = random.nextInt(min..max)
        return EnhancedRandom.randomListOf(numberOfEntities, Notice::class.java)
    }
}