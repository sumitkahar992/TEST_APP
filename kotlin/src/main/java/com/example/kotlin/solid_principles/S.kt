package com.example.kotlin.solid_principles

/*
SOLID is an acronym for five design principles used while writing software using OOP paradigm
to make software designs more understandable, flexible, and maintainable. The SOLID principles are:

    Single responsibility principle (SRP): A class should have one and only one reason to change.
    Open-closed principle (OCP): A class should be open for extension but closed for modification.
    Liskov substitution principle (LSP): Subtypes should be substitutable for their base types.
    Interface segregation principle (ISP): A class should not be forced to implement interfaces it does not use.
    Dependency inversion principle (DIP): High-level modules should not depend on low-level modules, but both should depend on abstractions.

[S] The Single Responsibility Principle

(SRP) is the first principle of the SOLID design principles.
 It states that a class should have one and only one reason to change,
  meaning that a class should have only one job. A class that has
  multiple responsibilities is often referred to as a "Blob class" and
  can be difficult to understand,modify and test.

  An example of a bad practice that violates the SRP is a class
  that is responsible for both calculating and printing the results of a calculation.
 */

// Bad practice

class Calculator {
    fun calculateSum(a: Int, b: Int): Int {
        return a + b
    }

    fun printSum(a: Int, b: Int) {
        val sum = calculateSum(a,b)
        println("The sum is : $sum")
    }
}




//Good practice

class CalculatorS {
    fun calculateSum(a: Int, b: Int): Int {
        return a + b
    }
}

class Printer {
    fun printSum(sum: Int) {
        println("The sum is : $sum")
    }
}


//In this example, the Calculator class is responsible only for the calculation of the sum,
// and the Printer class is responsible only for printing the results.
// This adheres to the SRP because each class has only one reason to change,
// making the code more maintainable.




























