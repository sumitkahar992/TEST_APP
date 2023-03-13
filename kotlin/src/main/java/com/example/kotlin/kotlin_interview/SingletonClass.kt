package com.example.kotlin.kotlin_interview


fun main(){

    val obj1 = GeekForGeeks()
    val obj2 = GeekForGeeks()

    println(obj1.toString())
    println(obj2.toString())

    val obj3 = Geeks
    val obj4 = Geeks

    println(obj3.toString())
    println(obj4.toString())

// In the above example, we can see that both the objects have a different address, thus it is a wastage of memory.
// In the below program, we have done the same thing, but we have used the singleton class.
// So when we use an object instead of a class, Kotlin actually uses the Singelton and allocates the single memory.

    println(GFG.name)
    println("Addition is ${GFG.add(2,3)}")
    println(" sum =  ${GFG.add(10,10)}")

}

class GeekForGeeks{

}

// Geeks is the singleton class here
object Geeks {
    
}


object GFG {
    init {
        println("Singleton class invoked")
    }

    var name = "GFG is Best"

    fun add(num1: Int, num2: Int): Int{
        return num1.plus(num2)
    }
}



/*

Properties of Singleton Class

The following are the properties of a typical singleton class:

    Only one instance: The singleton class has only one instance and this is done by providing an instance of the class, within the class.
    Globally accessible: The instance of the singleton class should be globally accessible so that each class can use it.
    Constructor not allowed: We can use the init method to initialize our member variables.

Importance of Singleton Objects In Android

Below are some points which explain the importance of singleton objects in android along with some examples, where it must be used,
 and reasons for why android developers should learn about singleton objects.

   1.  As we know that when we want a single instance of a particular object for the entire application, then we use Singleton.
    Common use-cases when you use the singleton is when you use Retrofit for every single request that you make throughout the app, in that case,
    you only need the single instance of the retrofit, as that instance of the retrofit contains some properties attached to it,
    like Gson Converter(which is used for conversion of JSON response to Java Objects) and Moshy Converter,
    so you want to reuse that instance and creating a new instance again and again would be a waste of space and time,
    so in this case, we have to use singleton objects.

   2.  Consider the case when you are working with the repository in MVVM architecture,
   so in that case, you should only create only 1 instance of the repository, as repositories are not going to change,
   and creating different instances would result in space increment and time wastage.



   3.  Suppose you have an app, and users can Login to it after undergoing user authentication, so if at the same time two user
    with same name and password tries to Login to the account, the app should not permit as due to concern of security issues.
    So singleton objects help us here to create only one instance of the object, i.e user here so that multiple logins can’t be possible.
    Hope these examples are sufficient to satisfy the reader to explore more about singleton objects in Kotlin so that they can use singleton object in their android projects.





const val  BASE_URL = "https://newsapi.org/"
const val API_KEY = "ff30357667f94aca9793cc35b9e447c1"

interface NewsInterface
{
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getheadlines(@Query("country")country:String,@Query("page")page:Int):Call<News>
    // function used to get the headlines of the country according to the query
    // written by developer
}

// NewsService is the instance of retrofit made by using Singleton object
object  NewsService
{
    val newsInstance:NewsInterface
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(NewsInterface::class.java)
    }
}




 */


