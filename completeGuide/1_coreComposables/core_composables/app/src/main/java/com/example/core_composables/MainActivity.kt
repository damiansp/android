package com.example.core_composables

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core_composables.ui.theme.Core_composablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Core_composablesTheme {
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
fun SimpleText() {
    Text(text="Hello, Jetpack", fontSize=24.sp, fontWeight=FontWeight.Bold, color=Color.Blue)
}

@Preview(showBackground = true)
@Composable
fun SimpleTextPreview() {
    Core_composablesTheme {
        SimpleText()
    }
}


@Composable
fun StyledText() {
    val myStyle = TextStyle(
        fontFamily = FontFamily.Serif, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
    Text(
        text="Styled Text",
        style=myStyle,
        modifier = Modifier
            .padding(16.dp)
            .clickable { /* TODO */ })
}

@Preview(showBackground = true)
@Composable
fun StyledTextPreview() {
    Core_composablesTheme {
        StyledText()
    }
}


@Composable
fun Images() {
    //Image(painter = painterResource(id = R.drawable.my_image), contentDescription = "My Image")
    /*
    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.my_image)
    Image(bitmap = bitmap.asImageBitmap(), contentDescription = "My Image")
    */
    val imageUri = "https://www.example.com/my_image.jpg"
    // AsyncImage(model = imageUri, contentDescription = "My Image")
}


@Composable
fun MyButton() {
    Button(onClick = { /* TODO */ }) {
        Text("Click Me")
    }
}

@Preview(showBackground = true)
@Composable
fun MyButtonPreview() {
    Core_composablesTheme {
        MyButton()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Core_composablesTheme {
        Greeting("Android")
    }
}