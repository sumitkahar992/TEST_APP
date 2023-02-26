package com.example.kotlin.kotlin_interview

import kotlin.properties.Delegates


//  Kotlin Standard Delegates - Lazy, Observable and Vetoable

fun main() {

    val student = Student()
    student.heavy
    student.heavy
    student.heavy

//    student.marks = 70
//    student.marks = 80

    student.age = 13
    println(student.age)

    student.age = 12
    println(student.age)

    student.age = 15
    println(student.age)

    student.age = 18
    println(student.age)


}


class StudentHeavy {
    init {
        println("Student Heavy Initialized")
    }
}


class Student {
    val heavy by lazy { StudentHeavy() }         //Lazy

    // Observable
    var marks: Int by Delegates.observable(50) { property, oldValue, newValue ->
        println("old value = $oldValue")
        println("new value = $newValue")
    }

    // Vetoable
    var age: Int by Delegates.vetoable(14) { property, oldValue, newValue ->
        println("New Age = $newValue")
        println("Old Age = $oldValue")
        newValue >= 14
    }
}


























