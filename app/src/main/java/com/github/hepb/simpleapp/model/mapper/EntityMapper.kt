package com.github.hepb.simpleapp.model.mapper

import java.text.DateFormat
import java.util.Date

abstract class EntityMapper<in M, out E>(
    protected val dateFormat: DateFormat,
    protected val noDataMessage: String
) {

    abstract fun map(model: M): E

    protected fun mapDate(date: Date?): String {
        return if (date == null) {
            noDataMessage
        }
        else {
            dateFormat.format(date)
        }
    }
}