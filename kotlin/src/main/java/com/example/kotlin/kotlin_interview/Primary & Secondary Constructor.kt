package com.example.kotlin.kotlin_interview


fun main(){

    val box1 = Box()
    val box2 = Box(10,10,10)



}



class Box(
    var length: Int,        // Primary constructor
    var width: Int,
    var height: Int
){

    init {
        println("Init Block Called")
    }


    // Secondary constructor
    constructor(color: String = "Red") : this(0,0,0){
        println("Secondary constructor called")
    }


}