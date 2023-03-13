package com.example.kotlin.measure_time

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis
import kotlin.time.*

@OptIn(ExperimentalTime::class)
fun main() {

    val measuredTimeValue: TimedValue<List<Char>> = measureTimedValue {
        reverseTheAlphabet()
    }

    println(measuredTimeValue.value)
    println("Elapsed Time: ${measuredTimeValue.duration.inWholeMicroseconds}")

    val (reversedList: List<Char>, measureTime: Duration) = measureTimedValue {
        reverseTheAlphabet()
    }

    println(reversedList)
    println("Elapsed Time: ${measureTime.inWholeMicroseconds}")

    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

    // measureTimeInMillis
    val elapsedTime: Long = measureTimeMillis {
        reverseNimber()
    }
    println("Time in millis: $elapsedTime")


    // measureNanoTime
    val nanoTime: Long = measureNanoTime {
        reverseTheAlphabet()
    }
    println("Time in nano: $nanoTime")


    // measureTime
    val measureTimes: Duration = measureTime {
        reverseTheAlphabet()
    }
    println("Time in microSecinds: ${measureTimes.inWholeMicroseconds}")




}


private fun reverseTheAlphabet(): List<Char> = buildList {
    addAll('A'..'Z')
}.asReversed()


private fun reverseNimber(): List<Int> = buildList {
    addAll(1..10000)
}.asReversed()