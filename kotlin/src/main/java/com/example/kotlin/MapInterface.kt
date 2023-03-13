package com.example.kotlin

fun main() {

    val peopleToCarsOwned = mapOf(
        "Jack" to "Mercedes",
        "John" to "Audi",
        "Will" to "Jaguar"
    )

    println(peopleToCarsOwned)
    println(peopleToCarsOwned["John"])

    val cars = mapOf(
        "Aston Martin" to 2015,
        "Lamborghini" to 2000,
        "BMW" to 1990,
        "Mercedes Benz" to 1980
    )
//    val newCars = cars.filter {
//
//    }



}

class CarDetails(val name: String, manufacturedIn: Int){
    override fun toString(): String  = name
}

