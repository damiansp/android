package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeDemoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                }
            }
        }
    }
}


@Composable
fun DemoText(msg: String, fontSize: Float) {
    Text(text = msg, fontSize = fontSize.sp, fontWeight = FontWeight.Bold)
}

@Preview
@Composable
fun DemoTextPreview() {
    ComposeDemoTheme {
        DemoText(msg = "Welcome to Android", fontSize = 12f)
    }
}


@Composable
fun DemoSlider(position: Float, onPositionChange: (Float) -> Unit) {
    Slider(
        modifier = Modifier.padding(10.dp),
        valueRange = 20f..38f,
        value = position,
        onValueChange = { onPositionChange(it) })
}