package com.example.myapplicationemma1028

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplicationemma1028.ui.theme.MyApplicationemma1028Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationemma1028Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    LazyColumn {
        item {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }
        item {
            Text("hi")
        }
        /*item {
        for (i in 0..50) {
            Text(text = i.toString())
        }
        }
        */
        items(51) { index ->

            Text(index.toString())

        }
    }
}
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyApplicationemma1028Theme {
            Greeting("Android")
        }
    }
