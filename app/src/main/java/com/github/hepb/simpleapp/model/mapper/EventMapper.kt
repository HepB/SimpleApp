package com.github.hepb.simpleapp.model.mapper

import com.github.hepb.simpleapp.model.data.Event
import com.github.hepb.simpleapp.model.view.EventUIModel
import java.text.DateFormat
import java.util.*

class EventMapper(
    dateFormat: DateFormat,
    noDataMessage: String
): EntityMapper<Event, EventUIModel>(dateFormat, noDataMessage) {

    override fun map(model: Event): EventUIModel {
        with(model) {
            return EventUIModel(
                startTime = mapDate(startTime),
                endTime = mapDate(endTime),
                name = name
            )
        }
    }
}