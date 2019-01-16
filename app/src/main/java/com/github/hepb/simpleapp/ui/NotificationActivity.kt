package com.github.hepb.simpleapp.ui

import android.os.Bundle
import com.github.hepb.simpleapp.R
import com.github.hepb.simpleapp.model.view.NoticeUIModel
import com.github.hepb.simpleapp.model.view.UiModel
import kotlinx.android.synthetic.main.activity_notification_details.*

class NotificationActivity : BaseDetailsActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_details)
    }

    override fun setUiModel(uiModel: UiModel?) {
        if(uiModel != null) {
            val notice = uiModel as NoticeUIModel
            flightDate.text = getString(R.string.text_flight_date, notice.flightDate)
            gate.text = getString(R.string.text_gate, notice.gate)
        }
    }
}