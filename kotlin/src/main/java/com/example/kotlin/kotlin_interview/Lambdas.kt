package com.example.kotlin.kotlin_interview
/*


Lambda is a function which has na name. Lambda is defined with a curly braces {}
which takes variable as a parameter (if any) and body of function.
The body of function is written after variable (if any) followed by -> operator.


 */
fun main(){

    val modOperation = { a: Int -> a % 2 == 0 }
    println( modOperation(4) )

    val output = higherOrderFun(2.0, 3.0, ::add)

    val output1 = higherOrderFun(2.0, 3.0) { a: Double, b: Double -> a + b }

    println("Final Output = $output")
    println("Final Output = $output1")

}


fun add( a: Double, b: Double): Double{
    return a + b
}


fun higherOrderFun(a: Double, b: Double, fn: (Double, Double) -> Double): Double{
    println(fn(a,b))
    return fn(a,b)
}