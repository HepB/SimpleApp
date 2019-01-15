package com.github.hepb.simpleapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.hepb.simpleapp.R
import com.github.hepb.simpleapp.model.view.EventUIModel
import com.github.hepb.simpleapp.model.view.MovieUIModel
import com.github.hepb.simpleapp.model.view.NoticeUIModel
import com.github.hepb.simpleapp.model.view.UiModel
import android.view.LayoutInflater
import java.lang.IllegalArgumentException


class UIModelAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val items: MutableList<UiModel> = ArrayList()

    override fun getItemViewType(position: Int) = items[position].getType()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return when(type) {
            UiModel.EVENT_TYPE -> {
                val view = inflater.inflate(R.layout.item_event, viewGroup)
                EventViewHolder(view)
            }
            UiModel.NOTICE_TYPE -> {
                val view = inflater.inflate(R.layout.item_notification, viewGroup)
                NoticeViewHolder(view)
            }
            UiModel.MOVIE_TYPE -> {
                val view = inflater.inflate(R.layout.item_movie, viewGroup)
                MovieViewHolder(view)
            }
            else -> throw IllegalArgumentException("Unknown item type")
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when(viewHolder.itemViewType) {
            UiModel.EVENT_TYPE -> {
                val event = item as EventUIModel
                val eventViewHolder = viewHolder as EventViewHolder
                eventViewHolder.bind(event)
            }
            UiModel.NOTICE_TYPE -> {
                val notice = item as NoticeUIModel
                val noticeViewHolder = viewHolder as NoticeViewHolder
                noticeViewHolder.bind(notice)
            }
            UiModel.MOVIE_TYPE -> {
                val movie = item as MovieUIModel
                val movieViewHolder = viewHolder as MovieViewHolder
                movieViewHolder.bind(movie)
            }
            else -> throw IllegalArgumentException("Unknown viewHolder type")
        }
    }

    class EventViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(event: EventUIModel) {
            val mainProperty = itemView.findViewById<TextView>(R.id.eventName)
            mainProperty.text = event.name
        }
    }

    class NoticeViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(notice: NoticeUIModel) {
            val mainProperty = itemView.findViewById<TextView>(R.id.movieInterval)
            mainProperty.text = itemView.context.resources.getString(R.string.text_notice_flight_date, notice.flightDate)
        }
    }

    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(movie: MovieUIModel) {
            val mainProperty = itemView.findViewById<TextView>(R.id.movieInterval)
            mainProperty.text = itemView.context.resources.getString(R.string.text_notice_flight_date, movie.timeInterval)
        }
    }
}