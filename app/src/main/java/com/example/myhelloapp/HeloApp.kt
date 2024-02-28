package com.example.myhelloapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myhelloapp.ui.theme.MyHelloAppTheme

// This app holds the main container
@Composable
fun MyHelloApp() {
    Text(text = "MyHelloApp")
}

@Preview(showBackground = true)
@Composable
fun MyHelloAppPreview() {
    MyHelloAppTheme {
        MyHelloApp()
    }
}