package com.example.kotlin.kotlin_interview.InterOperability

import java.util.*


class KotlinClass {

    val result = Utils.doSomething()

    val eventOne = Events(name = "MindOrks")
    private val yesterdayDate = Date(Date().time.minus(24 * 60 * 60 * 1000L))
    val eventTwo = Events(name = "MindOrks", date = yesterdayDate)


    val date = eventOne.date

}