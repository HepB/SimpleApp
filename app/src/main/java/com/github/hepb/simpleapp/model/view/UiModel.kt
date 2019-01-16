package com.github.hepb.simpleapp.model.view

import java.io.Serializable

interface UiModel: Serializable {
    fun getType(): Int

    companion object {
        const val EVENT_TYPE: Int = 0
        const val MOVIE_TYPE: Int = 1
        const val NOTICE_TYPE: Int = 2
    }
}