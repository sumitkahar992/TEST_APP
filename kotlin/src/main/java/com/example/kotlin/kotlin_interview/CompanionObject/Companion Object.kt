package com.example.kotlin.kotlin_interview.CompanionObject


fun main(){

    MyClass.f()
    MyClass.f()
    MyClass.companion()

    MyClass.AnotherObject.g()



}


class MyClass {

    companion object MyObject {                  // One class can have only companion & Used in Factory patter.
        @JvmStatic                               // This method will works as a static method in java with this class.
        fun f(){
            println("Hello I am F from object")
        }

        fun companion() {
            println("The value of PI is ${ImportantNumbers.PI}")
            println("The value of PI is ${ImportantNumbers.pie}")
            println("The value of PI is ${ImportantNumbers.function()}")
        }
    }

    object AnotherObject {
        fun g(){
            println("Hello I am G from Another object")
        }
    }

}