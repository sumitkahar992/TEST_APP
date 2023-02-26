package com.example.kotlin.kotlin_interview


fun main(){

    println("Hello CheezyCode".formattedString())

    val number = 10
    number.arithmetic(10)

    "sumit[o]kahar".midValue()

}


fun String.formattedString(): String{
    return "----------------------\n$this\n----------------------"
}



fun Int.arithmetic(number:Int){

    println("Addition = ${this + number}")
    println("Subtraction = ${this - number}")
    println("Multiplication = ${this * number}")
    println("Divide = ${this/number}")
}



fun String.midValue(){
    if (this.length %2 == 0){
        println("It has no mid-value")
    }
    else{
        println(this[this.length / 2])
    }
}