package com.example.kotlin

import java.util.*


fun main() {

//    arrayTest1()
//    arrayTest2()
    arrayTest3()

}

private fun arrayTest1() {
    val nums1 = intArrayOf(1, 2, 3, 4, 5)
    val nums2 = intArrayOf(1, 2, 3, 4, 5)

    println(nums1 == nums2)

    println(Arrays.equals(nums1, nums2))

    println(nums1.contentEquals(nums2))
}


private fun arrayTest2() {
    val nums1 = arrayOf(
        intArrayOf(1, 2),
        arrayOf(intArrayOf(3, 4, 5), intArrayOf(6, 7))
    )
    val nums2 = arrayOf(
        intArrayOf(1, 2),
        arrayOf(intArrayOf(3, 4, 5), intArrayOf(6, 7))
    )

    println(nums1 == nums2)

    println(Arrays.equals(nums1, nums2))

    println(nums1.contentEquals(nums2))

    println(nums1.contentDeepEquals(nums2))

}



data class Numbers(val name: String, val values: List<Int>)


private fun arrayTest3(){
    val l1 = listOf(1,2,3,4,5)
    val l2 = listOf(1,2,3,4,5)

    println(l1 == l2)

    val n1 = Numbers("Test", listOf(1,2,3,4,5))
    val n2 = Numbers("Test", listOf(1,2,3,4,5))

    println(n1 == n2)

}



























