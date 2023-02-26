package com.example.kotlin.kotlin_interview

/*  Aggregate operations

Kotlin collections contain functions for commonly used aggregate operations –
operations that return a single value based on the collection content.
Most of them are well known and work the same way as they do in other languages:

 minOrNull() and maxOrNull() return the smallest and the largest element respectively. On empty collections, they return null.

   average() returns the average value of elements in the collection of numbers.

   sum() returns the sum of elements in the collection of numbers.

   count() returns the number of elements in a collection.

 */

fun main(){
    val numbers = listOf(5, 42, 10, 4)

    println("Count :  ${numbers.count()}")
    println("Max :  ${numbers.maxOrNull()}")
    println("Min :  ${numbers.minOrNull()}")
    println("Average :  ${numbers.average()}")
    println("Sum :  ${numbers.sum()}")


    val min3Remainder = numbers.minByOrNull { it % 3 }
    println(min3Remainder)

    val strings = listOf("one", "two", "three", "four")
    val longestString = strings.maxWithOrNull(compareBy{ it.length })
    println(longestString)


    //Fold and reduce
/*
For more specific cases, there are the functions reduce() and fold() that apply the
provided operation to the collection elements sequentially and return the accumulated result.
The operation takes two arguments: the previously accumulated value and the collection element.

The difference between the two functions is that fold() takes an initial value and uses it as
the accumulated value on the first step, whereas the first step of reduce() uses the first
and the second elements as operation arguments on the first step.*/

    //Reduce
    val list: List<Int> = listOf(20, 40, 60, 100)

    println(list.reduce {sum, value ->
        sum + value
    })


    val num = listOf(0, 1, 2, 3, 4, 5)
    val runningReduceSum = num.runningReduce { sum, item -> sum + item }
    val runningFoldSum = num.runningFold(35) { sum, item -> sum + item }

    println(runningReduceSum)
    println(runningFoldSum)

    val list1 = listOf(1, 2, 3).fold(10) { sum, element -> sum + element }
    println(list1)
    val list2 = listOf(1, 2, 3).reduce { sum, element -> sum + element }
    println(list2)

}



























