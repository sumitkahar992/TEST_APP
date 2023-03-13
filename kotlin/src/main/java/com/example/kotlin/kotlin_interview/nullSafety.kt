package com.example.kotlin.kotlin_interview


fun main(){

    var a: String = "abc"
    a = "null"        // Compile Time Error


    var b: String? = "123"
    b = null





    var name: String? = "Code Unwrapped"
    println(name)

    var company: String? = "null"   // Compile Time Error
    println(company?.length)

    println(company!!.length)

    var age: Int? = null
    println(age ?: "Invalid Age")   // Elvis Operator , Null Coalescing Operator






}
/*


In JAVA

public class Singleton {
    private static Singleton instance = null;
    private Singleton(){
    }
    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
    }
    public static Singleton getInstance() {
        if (instance == null) createInstance();
        return instance;
    }


In KOTLIN

object Singleton


 */

