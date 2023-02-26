package com.example.kotlin.kotlin_interview


fun main() {

    calculateTimeAndRun {
        loop(1000)
    }

    calculateTimeAndRun {
        loop(1000)
    }

    calculateTimeAndRun {
        loop(1000)
    }

    // primitive example
    val int1 = 10
    val int2 = 10
    println(int1 == int2) // true
    println(int1 === int2) // true
// wrapper example
    val num1 = Integer(10)
    val num2 = Integer(10)
    println(num1 == num2) // true
    println(num1 === num2) //false



}


inline fun calculateTimeAndRun(fn: () -> Unit) {

    val start = System.currentTimeMillis()
    fn()
    val end = System.currentTimeMillis()
    println("Time taken ${end - start} ms")
}


fun loop(n: Long) {
    for (i in 1..n) {
        println("$i")
    }
}