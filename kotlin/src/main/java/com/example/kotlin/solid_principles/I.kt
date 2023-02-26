package com.example.kotlin.solid_principles

/*
[I] The Interface Segregation Principle

(ISP) is the fourth principle of the SOLID design principles.
It states that a class should not be forced to implement interfaces it does not use,
 meaning that a class should not be forced to implement methods it does not need.
 This principle encourages creating small, specific interfaces that are tailored
  to the needs of specific classes, rather than creating large, general interfaces
  that require classes to implement many methods they do not need.

An example of a bad practice that violates the ISP is a class that implements a large,
 general interface that contains many methods that the class does not need.
 */

interface ShapeI {
    fun calculateArea(): Double
    fun calculatePerimeter(): Double
    fun draw(): Unit
    fun resize(): Unit
}

class CircleI : ShapeI {
    var radius: Double = 0.0
    override fun calculateArea(): Double = 3.14 * (radius * radius)

    override fun calculatePerimeter(): Double = 2 * 3.14 * radius

    override fun draw() = println("Drawing circle")

    // resize iz not neede for circle
    override fun resize() {}

}

//In this example, the Circle class is forced to implement the resize() method,
// even though it is not needed. This violates the ISP principle because
// the class is being forced to implement methods that it does not need.
//
//A better practice would be to create small, specific interfaces that are tailored
// to the needs of specific classes, rather than creating large,
// general interfaces that require classes to implement many methods they do not need.

interface CalculateArea {
    fun calculateArea(): Double
}

interface CalculatePerimeter {
    fun calculatePerimeter(): Double
}

interface Drawable {
    fun draw(): Unit
}


class CircleZ : CalculateArea, CalculatePerimeter, Drawable {
    var radius: Double = 0.0

    override fun calculateArea(): Double = 3.14 * (radius * radius)

    override fun calculatePerimeter(): Double = 2 * 3.14 * radius

    override fun draw() = println("Drawing circle")

}



//In this example, the Circle class implements only the interfaces that it needs,
// adhering to the ISP principle,
// making the code more maintainable and flexible.






















