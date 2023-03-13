package com.example.kotlin

fun main() {

    var a = 1
    var b = 2
    val temp = a
    a = b
    b = temp
    println("a = $a , b = $b")


    var c = 88
    var d = 55

    c = d.also { d = c }
    println("c = $c , d = $d")


    var x = 8888
    var y = 5555
    x = y.apply { y = x }
    println("x = $x , y = $y")




}