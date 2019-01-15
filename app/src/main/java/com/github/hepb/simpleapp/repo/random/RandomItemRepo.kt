package com.github.hepb.simpleapp.repo.random

import com.github.hepb.simpleapp.model.data.DataModel
import com.github.hepb.simpleapp.model.data.Event
import com.github.hepb.simpleapp.model.data.Movie
import com.github.hepb.simpleapp.model.data.Notice
import com.github.hepb.simpleapp.model.mapper.EventMapper
import com.github.hepb.simpleapp.model.mapper.MovieMapper
import com.github.hepb.simpleapp.model.mapper.NoticeMapper
import com.github.hepb.simpleapp.model.view.UiModel
import com.github.hepb.simpleapp.repo.ItemRepo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.IllegalArgumentException

class RandomItemRepo(
    private val eventMapper: EventMapper,
    private val movieMapper: MovieMapper,
    private val noticeMapper: NoticeMapper
): ItemRepo {

    override fun getItems(): Single<List<UiModel>> =
        Single.fromCallable{generateData()}
            .map {
                val result: MutableList<UiModel> = ArrayList<UiModel>()
                it.forEach { result.add(mapItem(it)) }
                return@map result as List<UiModel>
            }.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())

    private fun generateData(): List<DataModel> {
        val result: MutableList<DataModel> = ArrayList()
        result.addAll(getRandomEvents(3, 33))
        result.addAll(getRandomMovies(3, 33))
        result.addAll(getRandomNotices(4, 34))
        return result
    }

    private fun getRandomEvents(min: Int, max: Int): List<DataModel> {
        val eventGenerator = EventRandomGenerator()
        return eventGenerator.generateItems(min, max)
    }

    private fun getRandomMovies(min: Int, max: Int): List<DataModel> {
        val movieGenerator = MovieRandomGenerator()
        return movieGenerator.generateItems(min, max)
    }

    private fun getRandomNotices(min: Int, max: Int): List<DataModel> {
        val noticesGenerator = NoticeRandomGenerator()
        return noticesGenerator.generateItems(min, max)
    }

    private fun mapItem(item: DataModel): UiModel {
        return when(item.getType()) {
            DataModel.EVENT_TYPE -> {
                val event = item as Event
                eventMapper.map(event)
            }
            DataModel.MOVIE_TYPE -> {
                val movie = item as Movie
                movieMapper.map(movie)
            }
            DataModel.NOTICE_TYPE -> {
                val notice = item as Notice
                noticeMapper.map(notice)
            }
            else -> throw IllegalArgumentException("Unknown data item type.")
        }
    }
}