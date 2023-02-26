package com.example.test_app.dictionary

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DictionaryScreen() {

    var name by remember { mutableStateOf("") }
    var names by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text(text = "Groceries is empty ??") }
            )

            Spacer(modifier = Modifier.width(17.dp))

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                
                if (name.isNotBlank()) {
                    names = names + name
                    name = ""
                }
                
            }) {
                Text(text = "Add")
            }

        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {

            items(names) {
                Text(text = it, fontSize = 14.sp, fontFamily = FontFamily.Monospace)
                Spacer(modifier = Modifier.height(5.dp))
                Divider()
            }

        }

    }


}