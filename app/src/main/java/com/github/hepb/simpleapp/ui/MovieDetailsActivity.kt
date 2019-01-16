package com.github.hepb.simpleapp.ui

import android.os.Bundle
import com.github.hepb.simpleapp.R
import com.github.hepb.simpleapp.model.view.MovieUIModel
import com.github.hepb.simpleapp.model.view.UiModel
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity: BaseDetailsActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
    }

    override fun setUiModel(uiModel: UiModel?) {
        if(uiModel != null) {
            val movie = uiModel as MovieUIModel
            from.text = getString(R.string.text_from, movie.fromPlace)
            to.text = getString(R.string.text_to, movie.toPlace)
            timeInterval.text = getString(R.string.text_time_interval, movie.timeInterval)
        }
    }
}