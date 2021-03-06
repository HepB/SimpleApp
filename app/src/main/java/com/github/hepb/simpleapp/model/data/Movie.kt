package com.github.hepb.simpleapp.model.data

data class Movie(
    var fromPlace: String?,
    var toPlace: String?,
    var estimateTime: TimeInterval
): DataModel {
    override fun getType(): Int = DataModel.MOVIE_TYPE
}