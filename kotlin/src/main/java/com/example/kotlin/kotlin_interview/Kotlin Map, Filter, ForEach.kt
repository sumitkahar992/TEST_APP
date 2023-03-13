package com.example.kotlin.kotlin_interview

//Kotlin Map, Filter, ForEach

fun main(){


    val nums: List<Int> = listOf(1, 2, 3, 4, 5, 7, 9)

    println(isOdd(2))
    println(isOdd(3))

    val oddList = nums.filter(::isOdd)                //Filter
    println(oddList)

    val evenList = nums.filter(fun(a: Int): Boolean{
        return a % 2 == 0
    })
    println(evenList)

    val evenList2 = nums.filter { it % 2 == 0 }      // simplify using Lambda
    println(evenList2)



    val userList = listOf<User>(
        User(1, "A"),
        User(2, "B"),
        User(3, "C"),
    )
    println(userList.filter { it.id == 2 })


    val list = nums.map { it * it }                   // Maps
    println(list)

    val paidUserList = userList.map {
        PaidUser(it.id, it.name, "Paid")
    }
    println(paidUserList)


    for (i in nums){                                 //Foreach
        println(i)
    }

    nums.forEach { println(it) }



}


fun isOdd(a: Int): Boolean{
    return a % 2 != 0
}

data class User(val id: Int, val name: String)
data class PaidUser(val id: Int, val name: String, val type: String)