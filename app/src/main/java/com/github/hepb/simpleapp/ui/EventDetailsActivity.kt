package com.github.hepb.simpleapp.ui

import android.os.Bundle
import com.github.hepb.simpleapp.R
import com.github.hepb.simpleapp.model.view.EventUIModel
import com.github.hepb.simpleapp.model.view.UiModel
import kotlinx.android.synthetic.main.activity_event_details.*

class EventDetailsActivity: BaseDetailsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)
    }

    override fun setUiModel(uiModel: UiModel?) {
        if(uiModel != null) {
            val event = uiModel as EventUIModel
            eventName.text = getString(R.string.text_event_name, event.name)
            startTime.text = getString(R.string.text_start_date, event.startTime)
            endTime.text = getString(R.string.text_finish_date, event.endTime)
        }
    }
}