package com.example.kotlin


fun main() {

    val a = 12
    val b = 5

    println("Enter operator either +, -, *, or /")
    val operator = readLine()

    val result = when(operator) {
        "+" -> println("$a + $b = ${a + b}")
        "-" -> println("$a - $b = ${a - b}")
        "*" -> println("$a * $b = ${a * b}")
        "/" -> println("$a / $b = ${a / b}")
        else -> "$operator operator is invalid operator. "
    }

//    println("result = $result")

    val n = -1

    when(n) {
        1,2,3 -> println("n is a positive integer less than 4 ")
        0     -> println("n is zero")
        -1, -2-> println("n is a negative integer greater than 3.")
    }

    val c = 100

    when(c) {
        in 1..10 -> println("A positive integer less than 11")
        in 10..100 -> println("A positive number between 10 and 100 (inclusive)")
    }












}