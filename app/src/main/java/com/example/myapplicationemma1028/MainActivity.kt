package com.example.myapplicationemma1028

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    var Animals = arrayListOf(R.drawable.animal0, R.drawable.animal1,
        R.drawable.animal2, R.drawable.animal3,
        R.drawable.animal4, R.drawable.animal5,
        R.drawable.animal6, R.drawable.animal7,
        R.drawable.animal8, R.drawable.animal9)
    var AnimalsName = arrayListOf("鴨子","企鵝","青蛙","貓頭鷹","海豚", "牛",
        "無尾熊", "獅子", "狐狸", "小雞")
    val context = LocalContext.current

    var mper = MediaPlayer()

    Column {
        Row {
            Button(onClick = {
                mper.reset()
                mper = MediaPlayer.create(context, R.raw.tcyang)
                mper.start()
            }) {

                Text(text = "歡迎修課")
                Image(
                    painter = painterResource(id =R.drawable.teacher),
                    contentDescription = "老師",
                    Modifier.size(75.dp)
                    )
        }
            Button(onClick = {
                mper.reset()
                mper = MediaPlayer.create(context, R.raw.fly)
                mper.start()
            }) {
                Text(text = "展翅飛翔")
                Image(
                    painter = painterResource(id =R.drawable.fly),
                    contentDescription = "飛翔",
                    Modifier.size(75.dp)
                )
            }
        }
        LazyRow {
            items(50) { index ->
                Text(text = index.toString(),
                    modifier = modifier)
                Text(AnimalsName[index%10],
                    modifier = modifier)

                Image(painter = painterResource(id = Animals[index % 10]),
                    contentDescription = "可愛動物圖片",
                            modifier = Modifier.fillParentMaxWidth(1.0f)
                )
            }
        }
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
}
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyApplicationemma1028Theme {
            Greeting("Android")
        }
    }
