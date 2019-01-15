package com.github.hepb.simpleapp.model.view

class NoticeUIModel(
    val flightDate: String,
    val gate: String
): UiModel {
    override fun getType() = UiModel.NOTICE_TYPE
}