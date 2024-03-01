package com.example.myhelloapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myhelloapp.ui.theme.MyHelloAppTheme

// This app holds the main container
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun MyHelloApp() {
    // make the state variable myname
    var myName by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var messageMode by remember { mutableStateOf(MESSAGE_MODE_INACTIVE) }
    var keyboardController = LocalSoftwareKeyboardController.current

    fun pressGoodByeButton() {
        message = "Good Bye, ${myName}"
        messageMode = MESSAGE_MODE_BYE
    }

    fun pressHiButton() {
        message = "Hi, ${myName}"
        messageMode = MESSAGE_MODE_HI
    }

    fun pressRestartButton() {
        message = ""
        myName = ""
        messageMode = MESSAGE_MODE_INACTIVE
    }

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource( id = R.string.app_name )) },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
            )
        },
        
    ) {innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp, 8.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // new name form ------------------------------
                Text(
                    text = stringResource(
                        id = R.string.insert_name_message
                    ),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(0.dp, 8.dp)
                )

                TextField(
                    modifier = Modifier

                        .padding(0.dp, 8.dp),
                    value = myName,
                    onValueChange = { newName ->
                            myName = newName
                    },

                )

                // message widget ------------------------------
                Button(onClick = {
                    pressHiButton()
                }) {
                    Text(
                        text = "Say Hi",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxSize(0.6F),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    Image(
                        painter = painterResource(
                            id = R.drawable.person_saying_hi_nobg
                        ),
                        contentDescription = "Person Saying Hi",
                        modifier = Modifier
                            .fillMaxSize(0.55F)
                    )

                    Text(
                        text = message
                    )

                    // message button, can either be "say goodbye" or "restart"
                    // depending on the message mode
                    if (messageMode == MESSAGE_MODE_HI) {
                        Button(onClick = {
                            pressGoodByeButton()
                        }) {
                            Text(
                                text = "Say Goodbye",
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }

                    } else {
                        Button(onClick = {
                            pressRestartButton()
                        }) {
                            Text(
                                text = "Restart",
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }
                }
            }
        }
    }
}



// the constants
const val MESSAGE_MODE_INACTIVE: Int = 0
const val MESSAGE_MODE_HI: Int = 1
const val MESSAGE_MODE_BYE: Int = 2

@Preview(showBackground = true)
@Composable
fun MyHelloAppPreview() {
    MyHelloAppTheme {
        MyHelloApp()
    }
}