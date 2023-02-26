package com.example.kotlin.kotlin_interview


fun main() {

    var car = Automobile("Car", 4, 5, "Petrol",true, )
    var person = Person("A", 20)
    println(person.name)
    println(person.age)

    var person2 = Person("B", 30)
    println(person2.name)
    println(person2.age)

    var car1 = Automobile("Bus","Diesel")


}


class Automobile(val name: String, val tyres: Int, val seat: Int,val engineType: String, hasAirBags: Boolean) {

    init {
        println("$name is created")
    }

    init {
        println("2nd Initializer Block")
    }

    constructor(namParam: String, engineParam: String) : this(namParam,4,5,engineParam,false)

    fun drive() {}
    fun appluBrakes() {}
}

class Empty {}

class Person(nameParam: String, ageParam: Int) {

    val name: String = "$nameParam - Clan"
    var age: Int = ageParam
    var canVote: Boolean = ageParam > 18
}