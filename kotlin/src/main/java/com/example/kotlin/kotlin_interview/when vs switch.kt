package com.example.kotlin.kotlin_interview

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.chrono.ChronoLocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun main(){

    val number = 2


    // Two or more choices
    when(number) {
        1 -> println("One")
        2, 3 -> println("Two or Three")
        4 -> println("Four")
        else -> println("Number is not between 1 and 4")
    }



    // "when" without arguments
    when {
        number < 1 -> println("Number is less than 1")
        number > 1 -> println("Number is greater than 1")
    }



    // Any type passed in "when"
    fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }
    println(describe(1))



    //Smart casting
    val date: ChronoLocalDate? = LocalDate.now()    // 1

    if (date != null) {
        println(date.isLeapYear)                    // 2
    }

    if (date != null && date.isLeapYear) {          // 3
        println("It's a leap year!")
    }

    if (date == null || !date.isLeapYear) {         // 4
        println("There's no Feb 29 this year...")
    }

    if (date is LocalDate) {
        val month = date.monthValue                 // 5
        println(month)
    }



    //Ranges
    when(10) {
        1 -> println("One") //statement 1
        2 -> println("Two") //statement 2
        3 -> println("Three") //statement 3
        in 4..8 -> println("Number between 4 and 8") //statement 4
        !in 9..12 -> println("Number not in between 9 and 12") //statement 5
        else -> println("Number is not between 1 and 8") //statement 6
    }






}


















