package io.miran.counterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import io.miran.counterapp.ui.CounterAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CounterApp()
}

@Composable
fun CounterApp() {
    CounterAppTheme {
        val counter = mutableStateOf(0)
        Scaffold(
                topBar = {
                    TopAppBar(
                            title = {
                                Text(text = "Jetpack Compose Counter app")
                            },
                            contentColor = Color.White,
                            elevation = 12.dp
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(
                            icon = { Icon(asset = Icons.Filled.Add) },
                            onClick = {
                                counter.value++
                            }
                    )
                },
        ) {
            Surface(color = MaterialTheme.colors.background) {
                Column(
                        modifier = Modifier.padding(16.dp).fillMaxWidth().fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {

                    Text("You have pushed the button this many times")
                    Text("${counter.value}", style = TextStyle(fontSize = 30.sp))
                }
            }
        }
    }

}