package com.example.kotlin


fun main() {

    for (i in 0 until 10){
        println(i)
    }

    repeat(10) {
        print(" $it")
    }

    var list = listOf(1,2,3,4,5,6,7)
    list.forEach {
        println(" $it")
    }

    var newList = list.map { it * it }

    print("new list = $newList ")
}