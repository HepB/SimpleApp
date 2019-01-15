package com.github.hepb.simpleapp.model.data

import java.util.Date

class Event(
    var startTime: Date? = null,
    var endTime: Date? = null,
    var name: String //в данном контексте String!, я так полагаю, означает, что эта переменная не может быть null, по этому так
): DataModel {
    override fun getType(): Int = DataModel.EVENT_TYPE
}