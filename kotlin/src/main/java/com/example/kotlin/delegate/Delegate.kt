package com.example.kotlin.delegate

interface Base {
    fun printMessage()
    fun printNum()
}


class BaseImpl(val x: Int) : Base {
    override fun printMessage() = println(x)
    override fun printNum() = println(x)
}


class Derived(b: Base) : Base by b {
    override fun printMessage() {
        println("abc")
    }
}



fun main() {
    val b = BaseImpl(10)
    Derived(b).printMessage()
    Derived(b).printNum()

}