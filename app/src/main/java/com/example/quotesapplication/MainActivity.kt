package com.example.quotesapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.quotesapplication.screens.screens.QuoteDetail
import com.example.quotesapplication.screens.screens.QuoteList
import com.example.quotesapplication.screens.screens.QuoteListItem
import com.example.quotesapplication.screens.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch{
            DataManager.loadAssetsFromFile(applicationContext);
        }
        DataManager.loadAssetsFromFile(this)
        setContent {
            App();
        }
    }
}

@Composable
fun App() {
    if(DataManager.isDataLoaded.value){
        if(DataManager.currentPage.value == Pages.LISTING){
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it);
            }
        }
        else{
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }
    }
}

enum class Pages{
    LISTING,
    DETAIL
}