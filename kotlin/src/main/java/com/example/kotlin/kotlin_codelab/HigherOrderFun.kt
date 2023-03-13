fun main() {

    cookies.forEach {
        println("Menu item : ${it.name}")
    }

    // Map
    println("Full Menu ->")
    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }.forEach { println(it) }


    //Filter
    println("Soft cookies ->")
    val softBakedMenu = cookies.filter {
        it.softBaked
    }.forEach {
        println("${it.name} - $${it.price}")
    }


    //GroupBy
    val groupedMenu = cookies.groupBy { it.softBaked }
    val softMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()

    println("Soft cookies:")
    softMenu.forEach { println("${it.name} - $${it.price}") }

    println("Crunchy cookies:")
    crunchyMenu.forEach { println("${it.name} - $${it.price}") }


    //Fold
    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }
    println("Total Price : $${totalPrice}")
    /*
    fold() is sometimes called reduce(). The fold() function in Kotlin
    works the same as the reduce() function found in JavaScript, Swift, Python, etc.
    Note that Kotlin also has its own function called reduce(),
    where the accumulator starts with the first element in the collection,
    rather than an initial value passed as an argument.
    Note: Kotlin collections also have a sum() function for numeric types,
       as well as a higher-order sumOf() function.
     */


    //SortBy
    println("Alphabetical menu:")
    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }.forEach {
        println(it.name)
    }

}


class Cookie(
    val name: String,
    val price: Double,
    val softBaked: Boolean,
    val hasFilling: Boolean
)

val cookies = listOf(
    Cookie(
        name = "Chocolate chip",
        price = 1.69,
        softBaked = false,
        hasFilling = false
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )

)