package com.example.kotlin

class Circle(val radius: Int){

    fun area(): Double{
        return Math.PI * radius * radius
    }
}

fun Circle.perimeter(): Double {
    return 2 * Math.PI * radius
}




fun String.findChar(index: Int): Char = this[index - 1]

fun main() {

    val circle = Circle(4)
    println(circle.perimeter())

    println("sumit".findChar(3))

    val list = mutableListOf(12,34,55,66,77)

    println(list)
    println(list.swap(3,4))


    SomeExample.Companion.someExample()

}


fun MutableList<Int>?.swap(first: Int, second: Int): Any {
    if (this == null) return "null"
    else{
        var tmp = this[first]
        this[first] = this[second]
        this[second] = tmp
        return this
    }
}


class SomeExample {
    companion object {

    }
}

fun SomeExample.Companion.someExample(){
    println("Extension Function")
}