package com.example.quotesapplication.screens.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapplication.DataManager
import com.example.quotesapplication.model.Quote

@Composable
fun QuoteDetail(quote: Quote){
        BackHandler() {
            DataManager.switchPages(null);
        }
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize(1f)
                .background(
                    Brush.sweepGradient(
                        colors = listOf(
                            Color(0xFF000000) ,
                            Color(0xFFE3E3E3)
                        )
                    )
                )
        ){
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.LightGray // Set your desired color here
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                modifier = Modifier
                    .padding(8.dp)
                    .width(300.dp)
                    .height(170.dp)
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        imageVector = Icons.Filled.CheckCircle,
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .padding(end = 5.dp)
                            .align(Alignment.Top)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            text = quote.text,
                            style = MaterialTheme.typography.titleMedium,
                            fontSize = 23.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .padding(bottom = 3.dp)
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Color.Magenta)
                                .height(1.dp)
                                .fillMaxWidth(0.4f)
                                .padding(top = 3.dp)
                        )
                        Text(
                            text = quote.author,
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top=3.dp)
                        )
                    }
                }
            }
        }
}