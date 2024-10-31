package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
                    DemoScreen()
                }
            }
        }
    }
}


@Composable
fun DemoScreen() {
    var sliderPosition by remember { mutableStateOf(20f) }
    var handlePositionChange = { position: Float -> sliderPosition = position }
    Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()) {
        DemoText(msg = "Welcome to Compose", fontSize = sliderPosition)
        Spacer(modifier = Modifier.height(150.dp))
        DemoSlider(position = sliderPosition, onPositionChange = handlePositionChange)
        Text(
            text = sliderPosition.toInt().toString() + "sp",
            style = MaterialTheme.typography.headlineMedium)
    }
}


@Preview(showSystemUi = true)
@Composable
fun DemoScreenPreview() {
    ComposeDemoTheme {
        DemoScreen()
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