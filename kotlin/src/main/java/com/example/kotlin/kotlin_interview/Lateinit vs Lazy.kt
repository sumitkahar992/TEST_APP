package com.example.kotlin.kotlin_interview

/*

Rules of LateInit
1.  lateinit used only with mutable data type [ var ]
2.  lateinit used only with non-nullable data type
3.  lateinit values must be initialised before you use it

Rules of Lazy
1.  The variable can be var or val
2.  The variable can be nullable or non-nullable
3.  [ Thread Safe ]
    It is initialized in the thread where it is used for the first time.
    Other threads can use the same value stored in the cache.

*/


val pi: Float = 3.14f     // Memory is Allocated whether you use pi or not
                          // Waste of Memory

val pie: Float? by lazy { 3.14f }      // Memory Not Allocated Until you use it

val pieee: Float by lazy { 3.14f }   //  Memory is Allocated as it is used in area

fun main() {


    val area = pieee * 4 *4         // Once variable is initialized it is saved in the Cache memory
    val perimeter = pieee * 4 *4    // and for second time value is loaded from cache memory[ Thread Safe ]

    val country = Country()
//    country.name = "India"
//    println(country.name)

    country.code()



}

class Country {

    //    var name: String = "Dummy"
    //    var name1: String? = null
          lateinit var name: String

          fun code() {
              name = "USA"
              println("The name of country is $name")
          }
}


/*

Lateinit is mainly used in the following cases:

 -> Android: variables that get initialized in lifecycle methods.
 -> Using Dagger for DI: injected class variables are initialized outside and independently from the constructor.
 -> Setup for unit tests: test environment variables are initialized in a @Before - annotated method.
 -> Spring Boot annotations (e.g., @Autowired).


 */