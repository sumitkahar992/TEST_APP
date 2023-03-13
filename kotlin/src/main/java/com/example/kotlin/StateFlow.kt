package com.example.kotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

private val mutableStateFlow = MutableStateFlow<String>("a")
val stateFlow: StateFlow<String> = mutableStateFlow.asStateFlow()


suspend fun main() {


    GlobalScope.launch {
        stateFlow.collectLatest {
            println(it)
        }
    }

    GlobalScope.launch {
        delay(500)
        stateFlow.collectLatest {
            println("from 2 $it")
        }
    }

    getData()

    delay(3000)
println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    stateFlow()
println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    sharedFlow()


}

suspend fun getData() {
    delay(1000)
    mutableStateFlow.value = "b"
}


suspend fun stateFlow(){

    val stateFlow = MutableStateFlow(0)

    stateFlow.value = 1
    stateFlow.value = 2
    stateFlow.value = 2
    stateFlow.value = 1
    stateFlow.value = 3


    stateFlow.collect{
        println(it)
    }

}



suspend fun sharedFlow(){

    val sharedFlow = MutableSharedFlow<Int>()

    sharedFlow.emit(1)
    sharedFlow.emit(2)
    sharedFlow.emit(2)
    sharedFlow.emit(1)
    sharedFlow.emit(3)


    sharedFlow.collect {
        println(it)
    }










}




















