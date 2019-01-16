package com.github.hepb.simpleapp.utils

import com.github.hepb.simpleapp.model.data.Event
import com.github.hepb.simpleapp.model.data.Movie
import com.github.hepb.simpleapp.model.data.Notice
import com.github.hepb.simpleapp.model.data.TimeInterval
import com.github.hepb.simpleapp.utils.RandomValues.GATES
import com.github.hepb.simpleapp.utils.RandomValues.NAMES
import com.github.hepb.simpleapp.utils.RandomValues.PLACES
import java.util.*

//Конечно, можно было бы сделать более сложный рандомизатор, по аналогии с https://github.com/benas/random-beans, но в тестовом задании это немного перебор
fun Random.nextInt(range: IntRange): Int {
    return range.start + nextInt(range.last - range.start)
}

fun nextGate(): String = GATES.random()
fun nextName(): String = NAMES.random()
fun nextPlace(): String = PLACES.random()
fun Random.nextDate(): Date {
    val calendar: Calendar = Calendar.getInstance()
    val day = nextInt(0 until 31)
    val hour = nextInt(0 until 24)
    val minute = nextInt(0 until 60)
    calendar.set(2018, Calendar.DECEMBER, day, hour, minute)
    return calendar.time
}

fun Random.nextTimeInterval(): TimeInterval {
    val firstDate = nextDate()
    val secondDate = nextDate()
    return TimeInterval(
        if (firstDate.time > secondDate.time) secondDate else firstDate,
        if (firstDate.time < secondDate.time) secondDate else firstDate
    )
}

fun Random.nextEvent(): Event {
    val firstDate = nextDate()
    val secondDate = nextDate()
    return Event(
        startTime = if (firstDate.time > secondDate.time) secondDate else firstDate,
        endTime = if (firstDate.time < secondDate.time) secondDate else firstDate,
        name = nextName()
    )
}

fun Random.nextMovie(): Movie {
    return Movie(
        fromPlace = nextPlace(),
        toPlace = nextPlace(),
        estimateTime = nextTimeInterval()
    )
}

fun Random.nextNotice(): Notice {
    return Notice(
        flightDate = nextDate(),
        gate = nextGate()
    )
}

private object RandomValues {
    val GATES = listOf("A", "B", "C", "D", "E", "F", "G", "H")
    val NAMES = listOf(
        "First random event",
        "Second random event",
        "Third random event",
        "Fourth random event",
        "Just random event"
    )
    val PLACES = listOf("Moscow", "London", "Paris", "Rome", "Budapest", "Amsterdam", "New York", "Boston")
}