package com.example.kotlin.kotlin_interview

/*

Short Circuiting -
When using And [ && ]  and  Or [ || ]  Operator

In And Operator if first condition is false it will not check for another Condition.
In Or Operator if first condition is True it will not check for another Condition.
This process is called short circuiting.


*/
fun main() {

    val above70 = false
    val knowsProgramming = false

    var interviewCall = above70 && knowsProgramming      //And operator -  && T & T -> T
    println(interviewCall)                               //                   T & F -> F
    //                   F & T -> F
    //                   F & F -> F
    var i = 10
    var j = 11

    var result = i == 10 || j++ == 11      // OR operator - ||  T & F -> T
    //                   F & T -> T
    println("$i   &   $j")

    var results = i == 11 || j++ == 11
    println("$i   &   $j")


    val answer = false                     // Not Operator - !  T -> F
    val question = !answer                 //                   F -> T
    println(question)


    val name = "      "
    val nam1 = "No Trailing Or Leading White SPaces"
    val r = println(!name.trim().isNullOrEmpty())
    val s = println(!nam1.trim().isNullOrEmpty())


}