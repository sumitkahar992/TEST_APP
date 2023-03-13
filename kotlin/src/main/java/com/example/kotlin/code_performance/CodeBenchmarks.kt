package com.example.kotlin.code_performance

import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

@OptIn(ExperimentalTime::class)
fun main() {

    val (value: String, time: Duration) = measureTimedValue { longOperation() }
    println("It took $time to calculate = $value.")


}

fun longOperation(): String {
    repeat(2_000_000) {
        print(".")
    }
    return "Done"
}