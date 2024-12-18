package com.example.corecomposables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.corecomposables.ui.theme.CoreComposablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoreComposablesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SimpleText()
                }
            }
        }
    }
}


@Composable
fun MyBox() {
    Box {
        Button(onClick = { /*TODO*/ }) {
            Text("Click Me")
        }
        Text(text="Hello from in front of the button!", modifier = Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true)
@Composable
fun MyBoxPreview() {
    MyBox()
}

@Composable
fun MyRow() {
    Row {
        Text("Line 1")
        Button(onClick = { /*TODO*/ }) {
            Text("Click Me")
        }
        Text("Line 2")
    }
}

@Preview(showBackground = true)
@Composable
fun MyRowPreview() {
    MyRow()
}


@Composable
fun MyCol() {
    Column {
        Text("Line 1", modifier = Modifier.padding(8.dp).fillMaxWidth())
        Text("Line 2")
        Button(onClick = { /*TODO*/ }) {
            Text("Click Me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyColPreview() {
    MyCol()
}


@Composable
fun MyButton() {
    Button(onClick = { /*TODO*/ }) {
        Text("Click Me!")
    }
}

@Preview(showBackground = true)
@Composable
fun MyButtonPreview() {
    MyButton()
}


@Composable
fun SimpleText() {
    Text(
        text = "Hello, Jetpack Compose!",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue)
    val myStyle = TextStyle(
        fontFamily = FontFamily.Serif,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Magenta)
    Text(
        text = "\n\nOoo, such style",
        style=myStyle,
        modifier = Modifier
            .padding(16.dp)
            .clickable { /*TODO*/ })
}

@Preview(showBackground = true)
@Composable
fun SimpleTextPreview() {
    CoreComposablesTheme {
        SimpleText()
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
    CoreComposablesTheme {
        Greeting("Android")
    }
}