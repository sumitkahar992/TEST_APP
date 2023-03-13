/*
    Arrays store ordered data of the same type, and have a fixed size.
    Arrays are used to implement many of the other collection types.
    Lists are a resizable, ordered collection.
    Sets are unordered collections and cannot contain duplicates.
    Maps work similarly to sets and store pairs of keys and values of the specified type.

 */

fun main() {

    // Array

    val rockPlanets = arrayOf("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")

    val solarSystem = rockPlanets + gasPlanets
    println(solarSystem[0])
    println(solarSystem[1])
    println(solarSystem[2])
    println(solarSystem[3])
    println(solarSystem[4])
    println(solarSystem[5])
    println(solarSystem[6])
    println(solarSystem[7])

    solarSystem[2] = "Little Earth"
    println(solarSystem[2])


    //  Lists

    val planetList = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(planetList.size)
    println(planetList[2])
    println(planetList.get(3))

    println(planetList.indexOf("Earth"))
    println(planetList.indexOf("Pluto"))

    for (planet in planetList) {
        print(" $planet ")
    }

    planetList.add("Pluto")
    planetList.add(3, "Alpha Centurio")

    planetList[3] = "Future Moon"

    println()
    println(planetList[3])
    println(planetList[9])

    planetList.removeAt(9)
    planetList.remove("Future Moon")

    println(planetList.contains("Pluto"))
    println("Future Moon" in solarSystem)


    //  Sets -> A set is a collection that does not have a specific order and doesn't allow duplicate values.
    println("kotlin".hashCode())
    println("kotlin.".hashCode())

    val setOfPlanet = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    println(setOfPlanet.size)
    setOfPlanet.add("Pluto")
    println(setOfPlanet.size)

    println(setOfPlanet.contains("Pluto"))

    setOfPlanet.remove("Pluto")
    println(setOfPlanet.size)
    println(setOfPlanet.contains("Pluto"))


//  Map  collection -> A Map is a collection consisting of keys and values.
//  It's called a map because unique keys are mapped to other values.
//  A key and its accompanying value are often called a key-value pair.

    val mapSolarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )
    println(mapSolarSystem.size)

    mapSolarSystem["Pluto"] = 5
    println(mapSolarSystem.size)

    println(mapSolarSystem["Pluto"])
    println(mapSolarSystem["Theia"])

    mapSolarSystem.remove("Pluto")
    println(mapSolarSystem.size)

    mapSolarSystem["Jupiter"] = 78
    println(mapSolarSystem["Jupiter"])


}