package com.example.kotlin
/*
Functions on all levels

Kotlin allows us to define functions on many levels, but this isn’t very obvious as
Java only allows functions inside classes. In Kotlin, we can define:

    functions in files outside any classes, called top-level functions,
    functions inside classes or objects, called member functions (they are also called methods),
    functions inside functions, called local functions or nested functions.
 */

// Top-level function
fun main() {

    println(square(10.0))    // 10.0 is an argument
    println(square2(9.0))    // 9.0 is an argument

    println(double(1))  // 2
    println(A().twelveTimes(2))  // 24

    val res: Unit = someFunction()
    println(res) // kotlin.Unit

    vararg()                // kotlin.Unit
    vararg(1)      // kotlin.Unit
    vararg(1, 2)   // kotlin.Unit
    vararg(1, 2,3,4,5,6,7,8,9,10)  // kotlin.Unit

    println(listOf(1, 3, 5, 6)) // [1, 3, 5, 6]
    println(listOf("A", "B", "C")) // [A, B, C]

    println(concatenate())
    println(concatenate("A", "B")) //  AB
    println(sums())  //  0
    println(sums(1,2,3))  //  6

//Named parameter syntax and default arguments
    val list = listOf(1, 2, 3, 4)
    println(list.joinToString()) // 1, 2, 3, 4
    println(list.joinToString(separator = "-")) //  1-2-3-4
    println(list.joinToString(limit = 2)) //  1, 2, ...


    cheer() // Hello, World
    cheer("Hi") // Hi World


    addOneAndPrint() // [1]
    addOneAndPrint() // [1]
    addOneAndPrint() // [1]

    println(g(1)) // Int
    println(h(18L)) // Long
    println(f("ABC")) // Any
}

// Top-level function
fun square(x: Double): Double {
    return x * x
}

// single expression function
fun square2(x: Double) = x * x   // x is a parameter



val a: Int = 123

val b = 123

fun add(a: Int, b: Int): Int = a + b

fun sum(a: Int, b: Int) = a + b


// Top-level function
fun double(i: Int) = i * 2

class A {
    // Member function (method)
    private fun triple(i: Int) = i * 3


    // Member function (method)
    fun twelveTimes(i: Int): Int {

        // Local function
        fun fourTimes() = double(double(i))
        return triple(fourTimes())
    }
}



// In Kotlin, parameters are read-only, so we cannot reassign their value.
fun a(i: Int) {

//    i = i + 10     // ERROR
    var i = i + 10   //Not a Good Practice

}

/*
Unit return type

In Kotlin, all functions have a result type, so every function call is an expression.
 When a type is not specified, the default result type is Unit, and
 the default result value is the Unit object.
 */


fun someFunction() { }

// the same as
fun c(): Unit {}

// the same as
fun d(): Unit {
    return
}

// the same as
fun e(): Unit {
    return Unit
}


// Vararg parameters
// Each parameter expects one argument,
// except for parameters marked with the vararg modifier.
// Such parameters accept any number of arguments.
fun vararg(vararg params: Int) { }



fun concatenate(vararg strings: String): String {
    // The type of `strings` is Array<String>
    var accumulator = ""
    for (s in strings) accumulator += s
    return accumulator
}

fun sums(vararg ints: Int): Int {
    // The type of `ints` is IntArray
    var accumulator = 0
    for (i in ints) accumulator += i
    return accumulator
}



fun cheer(how: String = "Hello,", who: String = "World") {
    println("$how $who")
}


fun addOneAndPrint(list: MutableList<Int> = mutableListOf()) {
    list.add(1)
    println(list)
}


// Function overloading
/*
In Kotlin, we can define functions with the same name in the same scope (file or class)
as long as they have different parameter types or a different number of parameters.
 This is known as function overloading. Kotlin decides which function to execute based
 on the types of the specified arguments.
 */
fun f(a: Any) = "Any"
fun g(i: Int) = "Int"
fun h(l: Long) = "Long"













