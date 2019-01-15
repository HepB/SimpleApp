package com.github.hepb.simpleapp.model.data

interface DataModel {
    fun getType(): Int

    companion object {
        const val EVENT_TYPE = 0
        const val MOVIE_TYPE = 1
        const val NOTICE_TYPE = 2
    }
}