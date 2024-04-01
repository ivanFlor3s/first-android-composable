package com.example.helloworld

import android.content.res.Configuration
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworld.models.MyMessage
import com.example.helloworld.ui.theme.HelloWorldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldTheme {
                MyMessages(messages = messages  )
            }
        }
    }
}

private val messages = listOf(
    MyMessage("Title lorem ipsum 1", "Body 1"),
    MyMessage("Title lorem ipsum 2", "Body 2"),
    MyMessage("Title lorem ipsum 3", "Body 3"),
    MyMessage("Title lorem ipsum 4", "Body 4"),
    MyMessage("Title lorem ipsum 5", "Body 5"),
    MyMessage("Title lorem ipsum 6", "Body 6"),
    MyMessage("Title lorem ipsum 7", "Body 7"),
    MyMessage("Title lorem ipsum 8", "Body 8"),
    MyMessage("Title lorem ipsum 9", "Body 9"),
    MyMessage("Title lorem ipsum 10", "Body 10"),
    MyMessage("Title lorem ipsum 11", "Body 11"),
    MyMessage("Title lorem ipsum 12", "Body 12"),
    MyMessage("Title lorem ipsum 13", "Body 13"),
    MyMessage("Title lorem ipsum 14", "Body 14"),

)
@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
    Text(text, color = color, style = style)
}

@Composable
fun MyTexts(message: MyMessage) {
    Column(modifier = Modifier.padding(start = 8.dp).width(IntrinsicSize.Max)) {
        MyText(
            message.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(message.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleSmall)
    }
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewTexts() {
    HelloWorldTheme {
        MyMessages(messages = messages)
    }
}

@Composable
fun MyComponent(message: MyMessage) {
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(all = 8.dp)) {
        MyImage()
        MyTexts(message)
    }
}

@Composable
fun MyMessages(messages: List<MyMessage>){
    LazyColumn {
        items(messages) { message ->
            MyComponent(message)
        }
    }

}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Icon",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .size(64.dp)
    )
}