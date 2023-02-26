package com.example.kotlin.kotlin_interview


fun main(){

                                     //Apply
    val emp = Employee()
    emp.age = 20
    emp.name = "John"

    emp.apply {
        age = 30
        name = "Sean"
    }

    println(emp)



                                       //Let
    val person : Employee? = null
    person?.name = "sumit"
    person?.age = 24

    emp?.let {
        it.name = "capricorn"
        it.age = 24
    }



                                       //With
    with(emp){
        age = 30
        name = "XYZ"
    }


                                       //Run
    emp.run {
        age = 35
        name = "PQR"
    }

}



data class Employee(
    var name: String = "",
    var age: Int = 18
)