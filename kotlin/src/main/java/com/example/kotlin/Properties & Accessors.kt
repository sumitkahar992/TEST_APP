package com.example.kotlin


class Employee {
    val name : String = "Employee"  // Read only properties: generates a getter and setter
    var isManager : Boolean = false // Writable property: a field, a getter and a setter
}


class Person {
    var firstName: String = ""
    // redundant getter and setter
    get() = field
    set(value) {
        field = value
    }
}

//  custom getter example
class Person2 {
    var name: String = ""
    get() = field.uppercase()
}

//  custom setter example
class Person3 {
    var name: String = ""
    set(value) { field = value.lowercase() }
}


class Rectangle(val height: Int,val width: Int) {
    val isSquare : Boolean
    get() = height == width
}


class Address {
    var name : String = "sumit kahar"
    var street : String = "Hatbazzar - 13"
    var city : String = "Bhairahawa"

    // custom getter
    val fullAddress : String  // np backing field
    get() = "$name, $street, $city"
}


fun main() {
    val p = Person()
    p.firstName = "A"      // calls setter
    println(p.firstName)   // calls getter

    val p2 = Person2()
    p2.name = "anita"
    println(p2.name)

    val p3 = Person3()
    p3.name = "REDBULL"
    println(p3.name)

    val rect = Rectangle(100, 99)
    println(rect.isSquare)

    val squa = Rectangle(50, 50)
    println(squa.isSquare)


    val a = Address()
    println(a.fullAddress)

}





















