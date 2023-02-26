package com.example.test_app

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SearchLists() {

    var search by remember { mutableStateOf("") }

    val lists = listOf(
        "Lion",
        "Tiger",
        "Apple",
        "Orange",
        "Apricot",
        "Monkey",
        "Cheetah",
        "Beer",
        "Apple",
        "Mango",
        "Money",
        "Banana"
    )

    LazyColumn(
        modifier = Modifier.padding(20.dp)
    ) {

        val filterList: List<String> = if (search.isEmpty()) {
            lists
        } else {
            val result = arrayListOf<String>()
            for (temp in lists) {
                if (temp.replaceFirstChar { it.lowercase() }.contains(
                        search.replaceFirstChar { it.lowercase() }
                    )
                ) {
                    result.add(temp)
                }
            }
            result
        }


        item {
            CustomSearchLists(text = search, onValueChange = { search = it })
        }

        items(filterList) { data ->
            Text(text = data, modifier = Modifier.padding(top = 10.dp))
        }

    }


}


@Composable
fun CustomSearchLists(
    text: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = text, onValueChange = { onValueChange(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Search ??") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "", tint = Color.Black) },
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
    )

}