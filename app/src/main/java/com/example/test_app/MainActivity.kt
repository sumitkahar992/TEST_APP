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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ExampleScreen()
            SearchLists()
        }
    }
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