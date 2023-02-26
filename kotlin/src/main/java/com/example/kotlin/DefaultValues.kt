package com.example.kotlin

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
fun main() {

    // Array

    val values0 = DoubleArray(5).asList()
    println(values0)

    val values1 = DoubleArray(5) { 1.0 }.asList()
    println(values1)


    val values2 = Array<List<Int>>(5) { mutableListOf(1, 2) }.asList()
    println(values2)
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

    // Maps

    val fruitsCount = mapOf(
        "Strawberry" to 2,
        "Banana" to 4,
        "Orange" to 5
    ).withDefault {
        "?"
    }

    val s = fruitsCount.getValue("Strawberry") //  2
    val p = fruitsCount.getValue("Pineapple")  //  ?
    val r = fruitsCount["Raspberry"]               //  null
    val r2 = fruitsCount.get("Raspberry")          //  null

    println(s)
    println(p)
    println(r)
    println(r2)


    val fruitWithKiwi = fruitsCount + mapOf("Kiwi" to 6)

    val p2 = fruitsCount.getValue("PineApple")   //  ?
    println(p2)
//    val p3 = fruitWithKiwi.getValue("PineApple") //  throws exception
//    println(p3)


    val p4 = fruitWithKiwi.getOrDefault("Pineapple", "?")
    println(p4)







































}