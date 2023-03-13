package com.example.test_app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.test_app.dictionary.DictionaryScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            /*    Counter()
                coroutineTasks()
                launchAsync()

                */


//            ExampleScreen()
//            SearchLists()
            DictionaryScreen()

            /*    Log.d("MainActivity", "Start - Main")

                LaunchedEffect(key1 = true) {
                    printAllNames()
                    Log.d("MainActivity", "End - Scope")
                }

                Log.d("MainActivity", "End - Main")

                */
        }

        //  GlobalScope.launch
        lifecycleScope.launch {
            Log.d("Inside Global Scope", Thread.currentThread().name.toString())
        }
        Log.d("Outside Global Scope", Thread.currentThread().name.toString())
    }
}

private suspend fun printAllNames() {
    delay(2000)
}


@Composable
fun ExampleScreen() {

    var count by remember { mutableStateOf(0) }

    val calculation by remember {
        derivedStateOf {
            Log.d("LOG", "Calculated")
            count > 3
        }
    }

    Log.d("LOG", "READ: $calculation")
//    Log.d("LOG", "READ: ${count > 3} ")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            Log.d("LOG", "Clicked")
            count += 1
        }) {
            Text(text = "Increment")
        }

    }
}