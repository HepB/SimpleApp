package com.github.hepb.simpleapp.model.mapper

import com.github.hepb.simpleapp.model.data.Movie
import com.github.hepb.simpleapp.model.data.TimeInterval
import com.github.hepb.simpleapp.model.view.MovieUIModel
import java.text.DateFormat

class MovieMapper(
    dateFormat: DateFormat,
    noDataMessage: String
) : EntityMapper<Movie, MovieUIModel>(dateFormat, noDataMessage) {

    override fun map(model: Movie): MovieUIModel {
        with(model) {
            return MovieUIModel(
                fromPlace = fromPlace ?: noDataMessage,
                toPlace = toPlace ?: noDataMessage,
                timeInterval = mapTimeInterval(estimateTime)
            )
        }
    }

    private fun mapTimeInterval(timeInterval: TimeInterval?): String {
        return if (timeInterval == null) {
            noDataMessage
        } else {
            "${dateFormat.format(timeInterval.startDate)} - ${dateFormat.format(timeInterval.endDate)}"
        }
    }

}