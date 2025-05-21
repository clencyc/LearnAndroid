package com.example.composetutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation()
            MyCalculator()
        }
    }
}

// textview, edittext, Button, imageview
// text, fii

@Composable
fun MyCalculator(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var text1 by remember { mutableStateOf("0") }
        var text2 by remember { mutableStateOf("1") }
        val context = LocalContext.current

        Column {
            TextField(
                value = text1,
                onValueChange = {
                    text1 = it
                })
            TextField(
                value = text2,
                onValueChange = {
                    text2 = it
                })

            Row {
                Button(onClick = {
                    val result = text1.toInt() + text2.toInt()
                    Toast.makeText(context, "Result is $result", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Add")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = {
                    val result = text1.toInt() - text2.toInt()
                    Toast.makeText(context, "Result is $result", Toast.LENGTH_SHORT).show()
                } ) {
                    Text(text="Subtract")
                }

            }

            Column {
                Row {
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {
                        val result = text1.toInt() * text2.toInt()
                        Toast.makeText(context, "Result is $result", Toast.LENGTH_SHORT).show()
                    } ) {
                        Text(text="Multiply")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {
                        val result = text1.toInt() / text2.toInt()
                        Toast.makeText(context, "Result is $result", Toast.LENGTH_SHORT).show()
                    } ) {
                        Text(text="Divide")
                    }
                }
            }
        }
    }
}