package com.example.kotlin.kotlin_interview


fun main(){

    val circle: Circle = Circle(4.0)
    val square: Square = Square(4.0)

    println(circle.area())
    println(square.area())

    val shapes : Array<Shape> = arrayOf(Circle(3.0), Square(4.0), Triangle(3.0, 4.0))
    calculateAreas(shapes)



}

fun calculateAreas(shapes: Array<Shape>){
    for (shape in shapes){
        println(shape.area())
    }
}


open class Shape{
    open fun area() : Double{
        return 0.0
    }
}

class Circle(val radius: Double) : Shape(){
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}


class Square(val sides: Double) : Shape(){
    override fun area(): Double {
        return sides * sides
    }
}


class Triangle(val base: Double, val height: Double) : Shape(){
    override fun area(): Double {
        return 0.5 * base * height
    }
}