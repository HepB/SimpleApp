package com.github.hepb.simpleapp.model.mapper

import com.github.hepb.simpleapp.model.data.Notice
import com.github.hepb.simpleapp.model.view.NoticeUIModel
import java.text.DateFormat

class NoticeMapper(
    dateFormat: DateFormat,
    noDataMessage: String
) : EntityMapper<Notice, NoticeUIModel>(dateFormat, noDataMessage) {

    override fun map(model: Notice): NoticeUIModel {
        with(model) {
            return NoticeUIModel(
                flightDate = mapDate(flightDate),
                gate = gate ?: noDataMessage
            )
        }
    }
}