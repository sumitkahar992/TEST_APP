package com.example.kotlin

fun main() {

    // Map

    val numbers = setOf(1,2,3)
    println(numbers.map { it * 3 })
    println(numbers.mapIndexed{ idx, value -> value * idx })

    println(numbers.mapNotNull { if (it == 2) null else it * 3 })
    println(numbers.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx })

    val numbersMap = mapOf("key1" to 1,"key2" to 2,"key3" to 3,"key11" to 11)
    println(numbersMap.mapKeys { it.key.uppercase() })
    println(numbersMap.mapValues { it.value + it.key.length })


    // Zip

    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)
    println(colors.zip(animals){ color, animal -> "The ${animal.replaceFirstChar { it.uppercase() }} is $color" })

    val twoAnimals = listOf("fox","bear")
    println(colors.zip(twoAnimals))


    // Unzip

    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs.unzip())


    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")


    val alphabet = listOf(
        listOf("A","B","C"),
        listOf("D","E","F"),
        listOf("G","H","Z"),
    )

     // Map
    val withMap = alphabet.map { it }
    println(withMap)

    // FlatMap
    val withFlatMap = alphabet.flatMap { it }
    println(withFlatMap)





















}