package com.example.kotlin.kotlin_interview


fun main(){

    elvisOperator()
    stringConcatenation()


}


private fun elvisOperator() {
    var st: String? = null
    var st1: String? = "Geeks Of geeks"

    var len1: Int = st?.length ?: -1           //Elvis Operator
    var len2: Int = st1?.length ?: 5

//    var len1 : Int = if (st != null) st.length else -1
//    var len2 : Int = if (st1 != null) st1.length else 5

    println("Length of st is $len1")
    println("Length of st1 is $len2")
}



private fun stringConcatenation(){

    val s1 = "Interview"
    val s2 = "Bit"
    val s3 = "$s1 $s2"      // String Interpolation
    println(s3)

    val s4 = s1 + s2
    val s5 = s1.plus(s2)     // Using the + or plus() operator
    println("$s4  &   $s5")

    val s6 = StringBuilder()
    s6.append(s2).append(s1)   // Using StringBuilder
    println(s6)
}

