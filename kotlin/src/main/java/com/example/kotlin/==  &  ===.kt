package com.example.kotlin
/*
In Kotlin, we have two types of equality:

    Structural equality (==): It checks for equals().
    Referential equality (===): It checks whether the two references point to the same object.

 */

fun main() {

    // First, let's first compare Structural equality.

    val car1 = Car("RED")
    val car2 = Car("BLUE")
    println(car1 == car2)   // false

    val car3 = Car("RED")
    val car4 = Car("RED")
    println(car3 == car4)   // false


    // Now, compare Referential equality.

    val car5 = Car("RED")
    val car6 = Car("RED")
    println(car1 === car2)  // false

    val car7 = Car("RED")
    val car8 = car7
    println(car7 === car8)  // true
//It outputs true as the references to both objects are the same now.

    /*
     Till now, we have NOT implemented the equals() method, there are two ways to implement equals() method:

     Making the class a data class.
     Adding our own equals() method implementation.
     Both will behave the same. So, let's go with the data class.
     */

    val bike1 = Bike("RED")
    val bike2 = Bike("BLUE")
    println(bike1 == bike2)   // false

    val bike3 = Bike("BLUE")
    val bike4 = Bike("BLUE")
    println(bike3 == bike4)   // true

//Now, compare Referential equality. It has no impact due to the data class.
    val bike5 = Bike("BLUE")
    val bike6 = Bike("BLUE")
    println(bike5 === bike6)   // false

  val bike7 = Bike("BLUE")
    val bike8 = bike7
    println(bike7 === bike8)   // true






}


class Car(val color: String){

}

data class Bike(val color: String){

}

