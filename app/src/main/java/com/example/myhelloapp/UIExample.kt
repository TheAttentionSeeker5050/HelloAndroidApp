package com.example.myhelloapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

// how to create a custom composable
@Composable
fun MyComponent(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier.fillMaxSize()
    ) {
        Text("Hello Jupiter!")
    }
}

// we preview our component on Android Studio
// without having to run the app
@Preview(showBackground = true)
@Composable
fun MyComponentPreview() {
    MyComponent()
}
