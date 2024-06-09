package com.example.quotesapplication.screens.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.lazy.items
import com.example.quotesapplication.model.Quote

@Composable
fun QuoteList(data:Array<Quote>, onClick:(quote:Quote)->Unit){
    LazyColumn(
        content = {
            items(data) { item ->
                QuoteListItem(quote = item,onClick)
            }
        },
        horizontalAlignment = Alignment.CenterHorizontally
    )
}