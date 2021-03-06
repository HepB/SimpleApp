package com.github.hepb.simpleapp.ui.adapter

import android.content.Intent
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
import com.github.hepb.simpleapp.ui.BaseDetailsActivity
import com.github.hepb.simpleapp.ui.EventDetailsActivity
import com.github.hepb.simpleapp.ui.MovieDetailsActivity
import com.github.hepb.simpleapp.ui.NotificationActivity
import java.lang.IllegalArgumentException

class UIModelAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val items: MutableList<UiModel> = ArrayList()

    override fun getItemViewType(position: Int) = items[position].getType()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return when (type) {
            UiModel.EVENT_TYPE -> {
                val view = inflater.inflate(R.layout.item_event, viewGroup, false)
                EventViewHolder(view)
            }
            UiModel.NOTICE_TYPE -> {
                val view = inflater.inflate(R.layout.item_notification, viewGroup, false)
                NoticeViewHolder(view)
            }
            UiModel.MOVIE_TYPE -> {
                val view = inflater.inflate(R.layout.item_movie, viewGroup, false)
                MovieViewHolder(view)
            }
            else -> throw IllegalArgumentException("Unknown item type")
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (viewHolder.itemViewType) {
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

    abstract class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        protected var item: UiModel? = null

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            when (item!!.getType()) {
                UiModel.EVENT_TYPE -> {
                    val context = v.context
                    val intent = Intent(context, EventDetailsActivity::class.java)
                    intent.putExtra(BaseDetailsActivity.EXTRA_UI_MODEL, item)
                    context.startActivity(intent)
                }
                UiModel.MOVIE_TYPE -> {
                    val context = v.context
                    val intent = Intent(context, MovieDetailsActivity::class.java)
                    intent.putExtra(BaseDetailsActivity.EXTRA_UI_MODEL, item)
                    context.startActivity(intent)
                }
                UiModel.NOTICE_TYPE -> {
                    val context = v.context
                    val intent = Intent(context, NotificationActivity::class.java)
                    intent.putExtra(BaseDetailsActivity.EXTRA_UI_MODEL, item)
                    context.startActivity(intent)
                }
            }
        }
    }

    class EventViewHolder(view: View) : ItemViewHolder(view) {
        fun bind(event: EventUIModel) {
            item = event
            val mainProperty = itemView.findViewById<TextView>(R.id.eventName)
            mainProperty.text = event.name
        }
    }

    class NoticeViewHolder(view: View) : ItemViewHolder(view) {
        fun bind(notice: NoticeUIModel) {
            item = notice
            val mainProperty = itemView.findViewById<TextView>(R.id.flightDate)
            mainProperty.text =
                    itemView.context.resources.getString(R.string.text_notice_flight_date, notice.flightDate)
        }
    }

    class MovieViewHolder(view: View) : ItemViewHolder(view) {
        fun bind(movie: MovieUIModel) {
            item = movie
            val mainProperty = itemView.findViewById<TextView>(R.id.movieInterval)
            mainProperty.text =
                    itemView.context.resources.getString(R.string.text_movie_time_interval, movie.timeInterval)
        }
    }
}