package com.github.hepb.simpleapp.model.data

import java.util.Date

data class Notice(
    var flightDate: Date? = null,
    var gate: String? = null
): DataModel {
    override fun getType(): Int = DataModel.NOTICE_TYPE
}