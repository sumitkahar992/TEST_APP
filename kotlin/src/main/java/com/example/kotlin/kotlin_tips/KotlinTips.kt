package com.example.kotlin.kotlin_tips

data class Fruit(val name: String, val sugar: Int)

fun main() {

    val fruits = listOf(
        Fruit("banana", 12),
        Fruit("apple", 10),
        Fruit("orange", 9),
        Fruit("pineapple", 10),
        Fruit("peach", 8),
        Fruit("lemon", 2),
        Fruit("mango", 13),
    ).sortedBy(Fruit::sugar)

    println(fruits.map { it.name })

    println(fruits.take(2).map { it.name })

    println(fruits.takeLast(3).map { it.name })


    println(fruits.drop(2).map { it.name })

    println(fruits.dropLast(3).map { it.name })



    val (sweet, superSweet) = fruits.partition { it.sugar < 10 }
    println(sweet.map { it.name })       // sweet = [ lemon, peach, orange ]
    println(superSweet.map { it.name })  // superSweet = [ apple, pineappple, banana, mango ]


    val f = fruits.reversed().joinToString(
        separator = " + ",
        prefix = " happy = [ ",
        postfix = " ] ",
        limit = 3,
        truncated = "MORE",
        transform = Fruit::name
    )

    println(f)

    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

    println("__MEO__".removeSurrounding("__"))

    val cats = listOf(
        Fruit("Milk.jpg", 9),
        Fruit("Meat", 2),
        Fruit("Egg", 0),
        Fruit("Fish.JPG", 1,),
        Fruit("", 5,),
    )

    println(cats.map { it.name.removeSuffix(".jpg") })

    println(cats.map { it.name.ifBlank { "The Cat" } })































}