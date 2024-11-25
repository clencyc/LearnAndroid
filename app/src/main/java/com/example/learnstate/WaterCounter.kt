package com.example.learnstate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(device = "spec:width=411dp,height=891dp", showBackground = true, showSystemUi = true)
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    // var juice_count by rememberSaveable { mutableStateOf(0) }
   // -----
    StatelessCounter(count = count, onInceament = {count++}, modifier = modifier)
}

// stateless: a stateless component or function is one that does not store or manage any internal state
// stateless does not remember previous interactions or data

// stateful composables are created using remember/mutablestateof to store and manage state.
// they can update their UI based on changes in their internal state.
// they are more complex but allow for dynamic and interactive behaviour



@Composable
private fun StatelessCounter(count: Int,
                             onInceament: () -> Unit,
                             modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(26.dp)) {
        // value kept in remember is kept across recomposition
        // remember function helps state survive
        // rememberSaveable makes the state consistent -> to restore UI eg rotate / changetodark mode

        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(
            onClick = onInceament,
            // enable button as long as count is < 10
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add one")
        }
    }
}