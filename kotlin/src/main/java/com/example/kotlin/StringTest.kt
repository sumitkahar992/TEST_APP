package com.example.kotlin


fun main() {


    // remove prefix
    println("**hello world".removePrefix("**"))

    // remove suffix
    println("hello kotlin++".removeSuffix("++"))


    // remove surrounding
    println("##Jetpack Compose 1.3.2 ##".removeSurrounding("##"))

    println("__kotlin 1.8.0 ||".removeSurrounding(prefix = "__", suffix = "||"))


    // general pattern of ignoreCase
    val name1 = "Pattern"
    val name2 = "PatterN"

//    println(name1.lowercase() == name2.lowercase())
    println(name1.equals(name2, ignoreCase = true))


    println("Hello World".contains("wO"))
    println("Hello World".contains("WO", ignoreCase = true))


    println("com.example.feature".endsWith(".featURE", ignoreCase = true))
    println("com.example.feature".startsWith("COM.", ignoreCase = true))



    val groceries = listOf("One Egg", "Two bottle of water", "3 onions", "4 tomatoes")
    println(groceries.joinToString(limit = 2, truncated = " and MORE...", prefix = "< ", postfix = " >"))
    println(groceries.joinToString(limit = 2, truncated = " ....etc", separator = "_"))




























}