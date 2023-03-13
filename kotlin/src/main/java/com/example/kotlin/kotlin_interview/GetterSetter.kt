package com.example.kotlin.kotlin_interview


fun main(){

    val ob = Calculator()            //parameterless constructor . it takes Default constructor
    println( ob.add(2,3))

    val p1 = Persons("A",21)
    p1.name = "Aliens"
    println("${p1.name} & ${p1.age}")// Setter Method
    p1.age = -12
    println(p1.name)





}


class Calculator{                  //No constructor is defined so it will take Default constructor

    lateinit var message: String            // lateinit is used when initial value is given later. only for String .val cannot be used.

    fun add(a: Int, b: Int): Int{
        return a+b
    }

    fun multiply(a: Int, b: Int): Int{
        return a*b
    }
}


class Persons(nameParam: String, ageParam: Int){

    var name: String = nameParam
    get() {
        return field.uppercase()
    }

    var age: Int = ageParam
    set(value) {
        if (value > 0){ field = value }
        else{ println("Age can't be Negative") }
    }


    var email: String = ""            // Default way to provide  Getter  & Setter
    get() = field
    set(value)  {
        field = value
    }
}


















