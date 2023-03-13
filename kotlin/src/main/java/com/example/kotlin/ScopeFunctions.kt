package com.example.kotlin

/*
 Scope Function
 Kotlin “scope functions” are functions that allow for changing the scope, or the range, of a variable.
 There are five such functions included in the Kotlin standard library:
 apply, run, with, let, and also.    */

fun main() {

    // run, apply, with use ‘this’ to access the context object.

    val user = User("Joe", "London")
    val username = with(user) {
        name = "Palani"
        address = "India"
        println("Name = ${this.name} , Address = $address")
        name
    }

    // ‘let’ and ‘also’ functions refer to the object’s context as a lambda argument.

    val student = User("Shubham", "Banarasi")
    student.let {
        println("Name : ${it.name}")
        println("Address : ${it.address}")
    }

/*
Lambda result

If we write any expression at the end of the code block, it becomes the return value for the scope function.
Return value for ‘let’, ‘run’, and ‘with’ functions is the lambda result. */
    val updatedUsername = user.let {
        it.name = "John"
        it.name
    }
    println("Updated Username : $updatedUsername")

/*
Context object

‘apply’ and ‘also’ functions return the context object itself. In this case,
 we don’t need to specify the return value. The context object is automatically returned.     */

    val updatedUser = user.apply {
        name = "Mike"
    }
    println("Updated Username : ${updatedUser.name}")
    println("_____________________________________________________________")



/*  Let

Mostly used for null checks, when applying ?.let on an object, we can rest safe that every time we access that object inside the scope function, the object will be not null. To reference the object inside the scope function, we use the keyword it.
    Context Object – it
    Returns – last statement
    Use case – let function is often used to provide null safety calls.
    Use safe call operator(?.) with ‘let’ for null safety.
    It executes the block only with the non-null value.
  */
    var personLet:User? = null
    personLet?.let {
        println("First Time : User $personLet")
    }
    personLet = User("John","India")
    personLet?.let {
        println("Second Time : User $personLet")
    }
    println("_____________________________________________________________")
/*
Run

The ‘run’ function can be said as the combination of ‘let’ and ‘with’ functions.
    Context Object – this
    Returns – last statement
    Use Case – Used when the object lambda contains both initialization and
    the computation of the return value.
    Using run we can perform null safety calls as well as other computations.

It is the only scope function that has two variants.
 */

//  run as an extension

    val people = User("mani","India")
    val peopleName = people?.run {
        name = generateFullName(name)
        name
    }
    println(peopleName)

//  run as function

    val women = User("vijay","Asia")

    val womenName = run {
        generateFullName(women.name)
    }
    println(womenName)
    println("_____________________________________________________________")

/*
With

Similar to apply function, with is also used to change properties of an instance
i.e. object configuration. The only difference is with is not an extension function.
The last expression of with function returns a result.
    Context Object – this
    Returns – last statement
    Use Case – Run multiple operations on an object
 */
    val boy = User("mani","India")

    val boyName = with(boy) {
        name = "Sathish"
        address = "USA"
        name
    }
    println(boyName)
    println("_____________________________________________________________")



/*
Apply

Basically, if you are initializing an object, and setting a bunch of properties like in this case,
you have a pretty solid candidate to apply this scope function.
    Context Object – this
    Returns – same object
    Use Case – Initialize and configure an object
 */
    val teacher = User("mani","India")

    val updatedTeacher = teacher.apply {
        name = "Siva"
        address = "London"
    }

    println(updatedTeacher)
    println("_____________________________________________________________")

/*
Also

A common use also is for side effects without modifying the object.
 We can use it for doing some operations on the intermediate results.
 also does not transform the object. It returns the same object.
    Context Object – it
    Returns – same object
    Use Case – It is used where we have to perform additional operations when we have initialized the object members.

 */
    val madam = User("mani","India")

    val updatedMadam = madam.apply {
        name = "Ashmita"
        address = "Berlin"
    }.also {
        println(it)
    }






















































}
fun generateFullName(name: String) : String {
    return name + " kandam"
}

data class User(var name: String, var address: String)




















































