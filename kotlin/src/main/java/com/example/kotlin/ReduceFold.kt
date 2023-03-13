package com.example.kotlin

data class Book(val title: String, val price: Double)

fun main() {

    // reduce
    val numbers = listOf(5,2,3,10)

    val product = numbers.reduce { acc, value -> acc * value }
    println(product)


    val books = listOf(Book("Title 1", 14.5), Book("Title 2", 16.99))
    println(books.sumOf { it.price })
    println(books.map { it.price }.reduce { acc, value -> acc + value })


    val numbers2 = listOf<Int>()
//    println(numbers2.reduce { acc, i -> acc * i })
    println(numbers2.reduceOrNull { acc, i -> acc * i })


    // reduce applies accumulator left to right
    // for applying left to right
    val labels  = listOf("1", "2", "3", "4", "5", "6")
    println(labels.reduce { acc, value -> acc + value })

    // for applying right to left
    println(labels.reduceRight { value, acc -> acc + value })


    val numbers3 = listOf(0,1,2,3,4,5)
    println(numbers3.runningReduce { acc, value -> acc + value })


    println("____________")



    // fold
    val num = listOf(5,2,3,10)

    val products = num.fold(-1) { prod, element -> prod * element }
    println(products)

    val numbers8 = listOf<Int>()
    println(numbers8.fold(-1) { acc, i -> acc * i })

























}