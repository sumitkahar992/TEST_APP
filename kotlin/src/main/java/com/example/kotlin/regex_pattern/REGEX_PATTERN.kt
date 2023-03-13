package com.example.kotlin.regex_pattern


fun main() {

    val pattern = Regex("[^abc]su[m-z]it", RegexOption.IGNORE_CASE)
    println(pattern.containsMatchIn("hello oSuzit You Are Awesome !"))



}