package com.github.hepb.simpleapp.model.view

class EventUIModel(
    val startTime: String,
    val endTime: String,
    val name: String
): UiModel {
    override fun getType() = UiModel.EVENT_TYPE
}