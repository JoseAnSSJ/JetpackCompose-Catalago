package com.example.jetpackcomposecatalago

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalago.ui.theme.JetpackComposeCatalagoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalagoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyStateExample()
                }
            }
        }
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState()), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Esto es un ejemplo de como se veria un texto grande...")
        }
    }
}

@Composable
fun MyRow() {
    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "ejemplo 1")
        Text(text = "ejemplo 2")
        Text(text = "ejemplo 3")
    }
}

@Composable
fun MyColum() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceAround) {
        Text(text = "Ejemplo1", Modifier.background(Color.Red))
        Text(text = "Ejemplo2", Modifier.background(Color.Cyan))
        Text(text = "Ejemplo3", Modifier.background(Color.Blue))
        Text(text = "Ejemplo4", Modifier.background(Color.Magenta))
    }
}

@Composable
fun MyStateExample(){

    var counter by rememberSaveable{mutableStateOf(0)}

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "Pulsado $counter veces")

    }

}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "prueba de text")

        }
        MySpacer(30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Magenta), contentAlignment = Alignment.Center
            ) {
                Text(text = "prueba de text")

            }
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text(text = "prueba de text")
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Gray), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "prueba de text")
        }

    }
}

@Composable
fun MySpacer(dp: Int){
    Spacer(modifier = Modifier.height(dp.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalagoTheme {
        MyStateExample()
    }
}