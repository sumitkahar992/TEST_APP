package com.example.kotlin

data class Language(val id: Int, val name: String)

fun main() {


    val language = listOf(
        Language(1, "Java"),
        Language(2, "Kotlin"),
        Language(3, "Python"),
        Language(1, "Java")
    )

    var toSet = language.toSet()
    println(toSet)

    var toMutableSet = language.toMutableSet()
    println(toMutableSet)

    var toHashSet = language.toHashSet()
    println(toHashSet)










}