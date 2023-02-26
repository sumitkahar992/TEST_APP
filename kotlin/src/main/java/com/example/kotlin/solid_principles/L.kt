package com.example.kotlin.solid_principles

/*
[L] The Liskov Substitution Principle

(LSP) is the third principle of the SOLID design principles.
It states that subtypes should be substitutable for their base types,
meaning that objects of a superclass should be able to be replaced with
objects of a subclass without altering the correctness of the program.
 This principle helps to ensure that objects of a subclass can be used
 interchangeably with objects of the superclass, without introducing any unexpected behavior.

An example of a bad practice that violates the LSP is a class hierarchy where a
subclass overrides a method in a way that changes the method's contract.
 */

// Bad practice

open class Rectangle {
    open var width: Int = 0
    open var height: Int = 0

    open fun area(): Int {
        return width * height
    }
}

class Squarez : Rectangle() {

    override var height: Int
        get() = super.height
        set(value) {
            super.height = value
            super.width = value
        }


    override var width: Int
        get() = super.width
        set(value) {
            super.width = value
            super.height = value
        }

}

/*
In this example, the Square class is a subclass of the Rectangle class,
but the Square class overrides the width and height properties in a way
 that changes the contract of the class. Specifically, the Square class
  sets both the width and height properties to the same value, so that a
   square is always a square, but this is not an actual square, because
    a square is a rectangle and it should have different width and height values.
     This means that if an object of the Rectangle class is replaced with
      an object of the Square class, the behavior of the program may be unexpected.

A better practice would be to create a new class Square that has its own properties and methods,
 and also extends Rectangle class.
 */


class SquareL : Rectangle() {
    var side : Int = 0

    override var height: Int
        get() = side
        set(value) {
            side = value
        }


    override var width: Int
        get() = side
        set(value) {
            side = value
        }

    override fun area(): Int {
        return side * side
    }
}


//In this example, the Square class has its own properties and methods,
// so the Square class can be used interchangeably with the Rectangle class,
// without introducing any unexpected behavior. This adheres to the Liskov Substitution Principle,
// making the code more maintainable and predictable.



















