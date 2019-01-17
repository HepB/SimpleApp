package com.github.hepb.simpleapp.repo.random

import com.github.hepb.simpleapp.model.data.DataModel
import com.github.hepb.simpleapp.model.data.Notice
import com.github.hepb.simpleapp.utils.nextNotice
import java.util.*

class NoticeRandomGenerator: ItemRandomGenerator {
    override fun generateItems(count: Int): List<DataModel> {
        val random = Random()
        val result: MutableList<Notice> = ArrayList()
        for (i in 1..count) {
            result.add(random.nextNotice())
        }
        return result
    }
}