package com.example.advancedlayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PageSize.Fill.calculateMainAxisPageSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.advancedlayouts.ui.theme.AdvancedLayoutsTheme
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdvancedLayoutsTheme {
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
fun MyConstraintLayout() {
    ConstraintLayout {
        val (button, text) = createRefs()
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        ) {
            Text("Button")
        }
        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)
            start.linkTo(parent.start, margin = 16.dp)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun MyConstraintLayoutPreview() {
    AdvancedLayoutsTheme {
        MyConstraintLayout()
    }
}

/*
@Composable
fun CircularLayout(modifier: Modifier = Modifier, content: @Composable() -> Unit) {
    Layout(modifier = modifier, content = content) { measurables, constraints ->
        // measure children
        val placeables = measurables.map { maeasurable -> measurable.measure(constraints) }
        // determine layout dims
        val radius = max(constraints.maxWidth, constraints.maxHeight) / 2
        // Arrange children in circle
        layout(2 * radius, 2 * radius) {
            val angleIncr = 360f / placeables.size
            var currentAngle = 0f
            placeables.forEach { placeable ->
                val x = (
                    radius
                    + radius * cos(Math.toRadians(currentAngle.toDouble())).toFloat()
                    - placeable.width / 2)
                val y = (
                    radius
                    + radius * sin(Math.toRadians(currentAngle.toDouble())).toFloat()
                    - placeable.width / 2)
                placeable.placeRelative(x.toInt(), y.toInt())
                currentAngle += angleIncr
            }
        }
    }
}

// ex:
CircularLayout {
    Image(...)
    Image(...)
}
*/


@Composable
fun ModifierExamples() {
    Text("Offset Text", modifier = Modifier.offset(x = 10.dp, y = 20.dp))
    /*
    Image(
        painter = painterResource(id = R.drawable.myImage),
        contentDescription = "My Image",
        modifier = Modifier.size(width = 100.dp, height = 150.dp))
     */
    Button(onClick = { /* TODO */ }, modifier = Modifier.fillMaxWidth()) {
        Text("Full Width")
    }
    Row {
        Text("Item 1", modifier = Modifier.weight(1f))
        Text("Item 2", modifier = Modifier.weight(2f))
    }
    Text("Padded Text", modifier = Modifier.padding(25.dp))
}

@Preview(showBackground = true)
@Composable
fun ModifierExamplePreview() {
    AdvancedLayoutsTheme {
        ModifierExamples()
    }
}


fun Modifier.borderWithPadding(width: Dp, color: Color, padding: Dp) = this
    .border(width, color)
    .padding(padding)


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        //modifier = modifier
        modifier = Modifier.borderWithPadding(2.dp, Color.Red, 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdvancedLayoutsTheme {
        Greeting("Android")
    }
}