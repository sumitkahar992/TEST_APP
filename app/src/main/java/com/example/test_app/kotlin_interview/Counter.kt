package com.example.test_app.kotlin_interview

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.*

@Composable
fun Counter() {

    val count = rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("${count.value}", fontSize = 55.sp)

        Spacer(modifier = Modifier.padding(top = 20.dp))

        Button(onClick = {
            updateCounter(count)

        }) { Text(text = " BUTTON ") }


        Button(onClick = {
/*
            thread(start = true){
                executeLongRunningTask()
            }
*/
            CoroutineScope(Dispatchers.IO).launch {
                executeLongRunningTask()
                Log.d("COUNTER", "1 - ${Thread.currentThread().name} ")
            }

            GlobalScope.launch(Dispatchers.Main) {
                Log.d("COUNTER", "2 - ${Thread.currentThread().name} ")
            }

            MainScope().launch(Dispatchers.Default) {
                Log.d("COUNTER", "3 - ${Thread.currentThread().name} ")
            }


        }) { Text(text = "EXECUTE TASK") }


    }
}


private fun updateCounter(count: MutableState<Int>) {
    count.value++
    Log.d("COUNTER", " ${Thread.currentThread().name} ")
}


private fun executeLongRunningTask() {
    for (i in 1..10000) {
        println("HELL")
    }
}


 fun coroutineTasks() {

    CoroutineScope(Dispatchers.Main).launch {
        task1()
    }

    CoroutineScope(Dispatchers.Main).launch {
        task2()
    }
}

suspend fun task1() {
    Log.d("COROUTINE", " STARTING TASK - 1 ")
    delay(1000)
    Log.d("COROUTINE", " ENDING TASK - 1 ")
}

suspend fun task2() {
    Log.d("COROUTINE", " STARTING TASK - 2 ")
    yield()
    Log.d("COROUTINE", " ENDING TASK - 2 ")
}


 fun launchAsync() {
    CoroutineScope(Dispatchers.IO).launch {
        printFollowers()
        printFollowers1()
    }
}

/*
//  without using Async
private suspend fun printFollowers() {

    var fbFollowers = 0
    var instaFollowers = 0

    val job = CoroutineScope(Dispatchers.IO).launch {
        fbFollowers = getFbFollowers()
    }

    val job2 = CoroutineScope(Dispatchers.IO).launch {
        instaFollowers = getInstaFollowers()
    }

    job.join()
    job2.join()

    Log.d("TAG", "FB - $fbFollowers,  INSTA - $instaFollowers")
}

 */

// Using Async  much simple code
private suspend fun printFollowers() {

    val fb = CoroutineScope(Dispatchers.IO).async {
        getFbFollowers()
    }

    val insta = CoroutineScope(Dispatchers.IO).async {
        getInstaFollowers()
    }

    Log.d("TAG", "FB - ${fb.await()},  INSTA - ${insta.await()}")
}


// Another method
private suspend fun printFollowers1() {

    CoroutineScope(Dispatchers.IO).launch {
        val fb = async { getFbFollowers() }
        val insta = async { getInstaFollowers() }

        Log.d("TAG", "FB - ${fb.await()},  INSTA - ${insta.await()}")
    }

}


private suspend fun getFbFollowers(): Int {
    delay(1000)
    return 54
}

private suspend fun getInstaFollowers(): Int {
    delay(1000)
    return 113
}



