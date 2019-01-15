package com.github.hepb.simpleapp.model.view

class MovieUIModel(
    val fromPlace: String,
    val toPlace: String,
    val timeInterval: String
): UiModel {
    override fun getType() = UiModel.MOVIE_TYPE
}