package com.example.kotlin

fun main() {

    // Assosciate

    val numbers = listOf("one", "two", "three", "four")
    println(numbers.associateWith { it.length })

    println(numbers.associateBy { it.first().uppercaseChar() })
    println(numbers.associateBy(keySelector = { it.first().uppercaseChar() }, valueTransform = {it.length}))


    // Flatten

    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten())

    val containers = listOf(
        setOf("one", "two", "three"),
        setOf("four", "five", "six"),
        setOf("seven", "eight")
    )
    println(containers.flatten())


    // String Representation

    val strings = listOf("one", "two", "three", "four")
    println(strings)
    println(strings.joinToString())

    val listString = StringBuffer("The list of numbers: ")
    strings.joinTo(listString)
    println(listString)

    println(strings.joinToString( separator = " | ", prefix = "start: ", postfix = ": end" ))

    println(strings.joinToString { "Element: ${it.uppercase()}"})

}