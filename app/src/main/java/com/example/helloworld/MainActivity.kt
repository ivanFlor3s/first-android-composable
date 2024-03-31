package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComponent()
        }
    }
}

@Composable
fun MyText(text: String){
    Text(text)
}

@Composable
fun MyTexts(){
    Column {
        MyText("Hola como andas?")
        MyText("Hello, World!")
    }
}

@Preview
@Composable
fun PreviewTexts() {
    MyComponent()
}

@Composable
fun MyComponent(){
    Row {
        MyImage()
        MyTexts()
    }
}

@Composable
fun MyImage(){
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Icon"
    )
}