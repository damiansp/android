package com.example.core_composables

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    val buttonColors = ButtonDefaults.buttonColors(Color.Blue, Color.White)
    Button(
        onClick = { /* Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() */ },
        modifier = Modifier.padding(8.dp),
        colors = buttonColors
    ) {
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
fun MyCol() {
    Column {
        Text("Item 1", modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth())
        Text("Item 2")
        // Image(painter = painterResource(id = R.drawable.my_image), contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun MyColPreview() {
    MyCol()
}


@Composable
fun MyRow() {
    Row {
        Text("Item 1")
        Button(onClick = { /* ... */ }) { Text("Click!") }
        Text("Item 2")
        // Image(painter = painterResource(id = R.drawable.my_image), contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun MyRowPreview() {
    MyRow()
}


@Composable
fun MyBox() {
    Box {
        // Image(painter = painterResource(id = R.drawable.my_image), contentDescription = null)
        Button(onClick = { /* ... */ }) { Text("Click!") }
        Text("Item 1", modifier = Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true)
@Composable
fun MyBoxPreview() {
    MyBox()
}


@Composable
fun ProductCard(/* product: Product */) {
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .border(1.dp, Color.Gray)) {
        // Image...
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Campy Derailleur", fontWeight = FontWeight.Bold)
            Text(text = "A high-precision rear derailleur")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { /* Handle Purchase */}) { Text("Buy Now")}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    Core_composablesTheme {
        ProductCard()
    }
}


@Composable
fun UserProfileHeader(/* user: User */) {
    Row(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {
        // Image()
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = "Bob Dobolina", fontWeight = FontWeight.Bold)
            Text(text = "bob@bobdob.com")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfileHeaderPreview() {
    Core_composablesTheme {
        UserProfileHeader()
    }
}


@Composable
fun MyComposable() {
    var showText by remember { mutableStateOf(false) }
    Column {
        Button(onClick = {showText = !showText}) {
            Text(if(showText) "Hide Text" else "Show Text")
        }
        if (showText) {
            Text("The Mystery Toggleable Text")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyComposablePreview() {
    Core_composablesTheme {
        MyComposable()
    }
}


@Composable
fun ShowText() {
    var text by remember { mutableStateOf("Hello") }
    Column {
        TextField(value = text, onValueChange = { text = it })
        Text("Voila: $text")
    }
}

@Preview(showBackground = true)
@Composable
fun ShowTextPreview() {
    Core_composablesTheme {
        ShowText()
    }
}


@Composable
fun ToggleColor() {
    var isRed by remember { mutableStateOf(false) }
    val buttonColor = if (isRed) Color.Red else Color.Blue
    Button(onClick = { isRed = !isRed }, colors = ButtonDefaults.buttonColors(buttonColor)) {
        Text("Change Color")
    }
}

@Preview(showBackground = true)
@Composable
fun ToggleColorPreview() {
    Core_composablesTheme {
        ToggleColor()
    }
}


@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Column {
        Text(text = "Count: $count")
        Button(onClick = { count++ }) { Text("Increment") }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    Core_composablesTheme {
        Counter()
    }
}


@Composable
fun ParentComposable() {
    val sharedState = remember { mutableStateOf(0) } // hoisted state
    Column {
        ChildComposable1(sharedState)
        ChildComposable2(sharedState)
    }
}

@Composable
fun ChildComposable1(sharedState: MutableState<Int>) {
    Button(onClick = { sharedState.value++ }) { // modify shared state
        Text("Increment from Child 1")
    }
}

@Composable
fun ChildComposable2(sharedState: MutableState<Int>) {
    Text("Count: ${sharedState.value}")
}

@Preview(showBackground = true)
@Composable
fun ParentComposablePreview() {
    Core_composablesTheme {
        ParentComposable()
    }
}


@Composable
fun MyTextField() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        label = { Text("Enter text") })
}

@Preview(showBackground = true)
@Composable
fun MyTextFieldPreview() {
    Core_composablesTheme {
        MyTextField()
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