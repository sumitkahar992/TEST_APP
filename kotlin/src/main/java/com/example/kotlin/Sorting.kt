package com.example.kotlin

data class Cars(val model: String, val make: String, val speed: Int)

data class Player(val name: String, val age: Int, val score: Int)

fun sortingTest1() {
    println(listOf(4, 3, 1, 2, 8).sorted())
    println(listOf('b', 'A', 'c', 'a', 'd', 'B').sorted())

}


fun main() {
    sortingTest1()

    val cars = listOf(
        Cars("Toyota camry", "Toyota", 400),
        Cars("Ford F-150", "Ford", 100),
        Cars("A3", "Audi", 300),
    )

    println(cars.sortedBy { it.speed })

    val list1 = listOf(4, 1, 3, 2)
    val list2 = listOf(11, 33, 12, 21)
//    println(list1.zip(list2).sortedBy { it.second }.reversed())
//    println(list1.zip(list2).sortedBy { - it.second })
    println(list1.zip(list2).sortedByDescending { it.second })


    val player = listOf(
        Player("Ninja", 20, 90),
        Player("Preston", 21, 80),
        Player("Shroud", 21, 70),
        Player("DanTDM", 22, 80),
    )

    // more complex
    println(
        player.sortedWith(
            compareBy<Player> { it.score }
                .thenBy { it.age }
                .thenBy { it.name }
        )
    )

    println(player.sortedWith(compareBy({ it.score }, { it.age }, { it.name })))
    
    
    var fillClass = Cars(model = "", make = "", speed = 0)
    var fillClasss = Player(name = "", age = 0, score = 0)


}