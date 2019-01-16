package com.github.hepb.simpleapp.di

import android.app.Application
import android.content.Context
import com.github.hepb.simpleapp.R
import com.github.hepb.simpleapp.contract.model.ItemRepo
import com.github.hepb.simpleapp.model.mapper.EventMapper
import com.github.hepb.simpleapp.model.mapper.MovieMapper
import com.github.hepb.simpleapp.model.mapper.NoticeMapper
import com.github.hepb.simpleapp.repo.random.RandomItemRepo
import dagger.Module
import dagger.Provides
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = app

    @Provides
    fun repo(eventMapper: EventMapper, noticeMapper: NoticeMapper, movieMapper: MovieMapper): ItemRepo =
        RandomItemRepo(eventMapper, movieMapper, noticeMapper)

    @Provides
    fun eventMapper(context: Context): EventMapper =
        EventMapper(
            noDataMessage = context.resources.getString(R.string.text_no_data),
            dateFormat = SimpleDateFormat(context.resources.getString(R.string.format_time), Locale.getDefault())
        )

    @Provides
    fun movieMapper(context: Context): MovieMapper =
        MovieMapper(
            noDataMessage = context.resources.getString(R.string.text_no_data),
            dateFormat = SimpleDateFormat(context.resources.getString(R.string.format_time), Locale.getDefault())
        )

    @Provides
    fun noticeMapper(context: Context): NoticeMapper = NoticeMapper(
            noDataMessage = context.resources.getString(R.string.text_no_data),
            dateFormat = SimpleDateFormat(context.resources.getString(R.string.format_date_time), Locale.getDefault())
        )
}