package com.example.kotlin.solid_principles

/*
[O] The Open-Closed Principle

(OCP) is the second principle of the SOLID design principles.
 It states that a class should be open for extension but closed for modification,
 meaning that a class should be designed in such a way that
 new behavior can be added through inheritance or composition,
 but existing behavior should not be modified. This promotes a design where
 the behavior of a class can be extended without changing the class itself,
 making the code more flexible and maintainable.

An example of a bad practice that violates the OCP is a class that contains a hard-coded
list of shapes and a method to calculate the area of each shape.
 */

// Bad practice

class AreaCalculator {
    private val shapes = listOf("circle", "square", "triangle")

    fun calculateArea(shapes: String): Double {
        return when (shapes) {
            "circle" -> 3.14 * (5 * 5)
            "square" -> 5 * 5.0
            "triangle" -> 0.5 * (5 * 5)
            else -> 0.0
        }
    }
}
//In this example, the AreaCalculator class is responsible for calculating the area of different shapes.
// If we want to add new shapes or change the calculation of area for any shape, we need to modify the class,
// this violates the OCP principle.
//A better practice would be to create an interface Shape that defines a method to calculate the area,
// and then create separate classes for each shape that implement the Shape interface.

interface Shape {
    fun calculateArea(): Double
}

class Circle(private val radius: Double) : Shape {
    override fun calculateArea(): Double = 3.14 * (radius * radius)

}

class Square(private val side: Double) : Shape {
    override fun calculateArea(): Double = side * side

}

class Triangle(private val base: Double, private val height: Double) : Shape {
    override fun calculateArea(): Double = 0.5 * (base * height)

}




//In this example, the behavior of the class can be extended by creating new classes
// that implement the Shape interface, without modifying the existing class,
// this adheres to the OCP principle, making the code more flexible and maintainable.
















