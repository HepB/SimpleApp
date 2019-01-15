package com.github.hepb.simpleapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.github.hepb.simpleapp.R
import com.github.hepb.simpleapp.model.mapper.EventMapper
import com.github.hepb.simpleapp.model.mapper.MovieMapper
import com.github.hepb.simpleapp.model.mapper.NoticeMapper
import com.github.hepb.simpleapp.repo.random.RandomItemRepo
import com.github.hepb.simpleapp.ui.adapter.UIModelAdapter
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.detailsList
import timber.log.Timber
import java.text.SimpleDateFormat


class MainActivity : AppCompatActivity() {

    private lateinit var objectsRecycler: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        objectsRecycler = detailsList
        initRecycler()
    }

    private fun initRecycler() {
        val repo = RandomItemRepo(
            eventMapper = EventMapper(
                noDataMessage = getString(R.string.text_no_data),
                dateFormat = SimpleDateFormat(getString(R.string.format_time))
            ),
            movieMapper = MovieMapper(
                noDataMessage = getString(R.string.text_no_data),
                dateFormat = SimpleDateFormat(getString(R.string.format_time))
            ),
            noticeMapper = NoticeMapper(
                noDataMessage = getString(R.string.text_no_data),
                dateFormat = SimpleDateFormat(getString(R.string.format_time))
            )
        )
        repo.getItems().subscribeBy (
            onSuccess = {
                val adapter = UIModelAdapter().apply {
                    items.addAll(it)
                    notifyDataSetChanged()
                }
                objectsRecycler.adapter = adapter

            },
            onError = { Timber.e(it) }
        )
    }
}
