package com.example.kotlin.coroutines

import kotlinx.coroutines.*
import java.util.concurrent.Executors

// coroutines = "thread"
// parallel + concurrent apps

suspend fun bathTime() {
    println("Going to the bathroom")
    delay(500)   // suspends /"blocks" the computation
    println("Bath done, exiting")
}


// structured concurrency
suspend fun boilingWater() {
    println("Boiling water")
    delay(1000)
    println("Water boiled")
}


suspend fun sequentialMorningRoutine() {
    coroutineScope {
        bathTime()
        // add more code, including suspend functions
        // parallel code here, all needs to finish before the scope is closed.
    }
    coroutineScope {
        boilingWater()
    }
}

suspend fun concurrentMorningRoutine() {
    coroutineScope {
        launch { bathTime() }   // CHILD coroutine of coroutineScope
        launch { boilingWater() }// runs in parallel
    }
}

suspend fun noStructConcurrencyMorningRoutine() {
    GlobalScope.launch { bathTime() }
    GlobalScope.launch { boilingWater() }
}


suspend fun makeCoffee() {
    println("Starting to make coffee")
    delay(500)
    println("Done with coffee")
}


suspend fun morningRoutineWithCoffee() {
    coroutineScope {
        val bathTimeJob: Job = launch { bathTime() }
        val boilingWaterJob: Job = launch { boilingWater() }
        bathTimeJob.join()
        boilingWaterJob.join()
        launch { makeCoffee() }
    }
}


// structured concurrency
suspend fun morningRoutineWithCoffeeStructured() {
    coroutineScope {  // Nested coroutine scope
        coroutineScope {
            // parallel jobs
            launch { bathTime() }
            launch { boilingWater() }
        }
        // both coroutines are done
        launch { makeCoffee() }
    }
}


// return values from concurrency
suspend fun preparingJavaCoffee(): String {
    println("Starting to make coffee")
    delay(500)
    println("Done with coffee")
    return "Java Coffee"
}

suspend fun toastingBread(): String {
    println("Starting to make breakfast")
    delay(500)
    println("Toast is out !")
    return "Toasted bread."
}

suspend fun prepareBreakfast() {
    coroutineScope {
        val coffee = async { preparingJavaCoffee() } // deferred = analogous to the Future[T]
        val toast = async { toastingBread() }
        // semantic blocking
        val finalCoffee = coffee.await()
        val finalToast = toast.await()
        println("I'm eating $finalToast and drinking $finalCoffee")
    }
}


// 1. cooperative scheduling - coroutines yield manually
suspend fun workingHard() {
    println("Working")
    // CPU-intensive computation
    while (true) {
        // do some hard code
    }
    delay(100)
    println("Work done")
}

suspend fun takeABreak() {
    println("Taking a break")
    delay(1000)
    println("Break done")
}

suspend fun workingNicely() {
    println("Working")
    // CPU-intensive computation
    while (true) {
        delay(100)  // give a chance for dispatcher to run another coroutine
    }
    delay(100)
    println("Work done")
}

suspend fun workHardCoroutine() {
    val dispatcher: CoroutineDispatcher =
        Dispatchers.Default.limitedParallelism(1) // force 1 thread
    coroutineScope {

        launch(dispatcher) {
            workingHard()
        }

        launch(dispatcher) {
            takeABreak()
        }
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun workNicelyRoutine() {
    val dispatcher: CoroutineDispatcher =
        Dispatchers.Default.limitedParallelism(1) // force 1 thread
    coroutineScope {

        launch(dispatcher) {
            workingNicely()
        }

        launch(dispatcher) {
            takeABreak()
        }
    }
}

val simpleDispatcher = Dispatchers.Default  // normal code, = short code / yielding coroutines

val blockingDispatcher =
    Dispatchers.IO    // blocking code [ DB connections, long running computations ]

val customDispatcher =
    Executors.newFixedThreadPool(8).asCoroutineDispatcher() // on top of your own thread pool


// cancellation
suspend fun forgettingFriendBirthDayRoutine() {
    coroutineScope {
        val workingJob = launch { workingNicely() }
        launch {
            delay(2000L)
            workingJob.cancel()
            workingJob.join()
            println("I forgot my friend's birthday! Buying a present Now!")
        }
    }
}

// if coroutine doesn't yield, it can't be cancelled
suspend fun forgettingFriendBirthDayRoutineUncancellable() {
    coroutineScope {
        val workingJob = launch { workingHard() }
        launch {
            delay(2000L)
            println("Trying to STOP working ...?")
            workingJob.cancel() // sends a SIGNAL to coroutine to cancel, cancellation happens at first yielding poing [NEVER]
            workingJob.join()   // you are sure that the coroutine has been cancelled
            println("I forgot my friend's birthday! Buying a present Now!")
        }
    }
}


// resources
class Desk : AutoCloseable {
    init {
        println("Starting to work in this desk")
    }

    override fun close() {
        println("Cleaning up the desk")
    }
}


suspend fun forgettingFriendBirthDayRoutineWithResource() {
    val desk = Desk()

    coroutineScope {
        val workingJob = launch {
        // use resource here
            desk.use { _ ->  // this resource will be closed upon completion of coroutine.
                workingNicely()
            }
        }
        // can also define your own "cleanup" code in case of completion
        workingJob.invokeOnCompletion {exception: Throwable? ->
            println("Make sure I talk to my colleagues that I'll be out for 30 mins")
        }

        launch {
            delay(2000L)
            workingJob.cancel()
            workingJob.join()
            println("I forgot my friend's birthday! Buying a present Now!")
        }
    }
}


// cancellation propagates to child coroutines
suspend fun drinkWater() {
    while (true) {
        println("Drinking Water")
        delay(1000)
    }
}

suspend fun forgettingFriendBirthDayRoutineStayHydrated() {
    coroutineScope {
        val workingJob = launch {
            launch { workingNicely()  }
            launch { drinkWater() }
        }
        launch {
            delay(2000L)
            workingJob.cancel()
            workingJob.join()
            println("I forgot my friend's birthday! Buying a present Now!")
        }
    }
}


// coroutine context
suspend fun asynchronousGreeting() {
    coroutineScope {
        launch(CoroutineName("Greeting Coroutine") + Dispatchers.Default) {
            println("Hello Everyone!")
        }
    }
}


suspend fun coroutineCtxInheritance() {
    coroutineScope {
        launch(CoroutineName("Greeting Coroutine")) {
            println("[ parent coroutine] Hello !")
            launch {
                println("Child greeting coroutine!")
            }
            delay(200L)
            println("Hello again from the outer coroutine!")
        }
    }
}


suspend fun main() {
//    sequentialMorningRoutine()
//    concurrentMorningRoutine()
//    noStructConcurrencyMorningRoutine()
//    Thread.sleep(2000)
//    morningRoutineWithCoffee()
//    morningRoutineWithCoffeeStructured()
//    prepareBreakfast()

//    workHardCoroutine()
//    workNicelyRoutine()
//    forgettingFriendBirthDayRoutineUncancellable()
//    forgettingFriendBirthDayRoutineWithResource()
//    forgettingFriendBirthDayRoutineStayHydrated()
//    asynchronousGreeting()
    coroutineCtxInheritance()
}







































