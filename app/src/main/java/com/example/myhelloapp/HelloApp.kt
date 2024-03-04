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
    // --------------------------------------------
    // state variables and keyboard controller ------------------------------
    // --------------------------------------------

    var myName by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var messageMode by remember { mutableStateOf(MESSAGE_MODE_INACTIVE) }
    var keyboardController = LocalSoftwareKeyboardController.current

    // end of state variables and the keyboard controller


    // --------------------------------------------
    // function handlers ------------------------------
    // --------------------------------------------
    fun pressGoodByeButton() {
        // change the state variables when pressing the "say good bye" button

    }

    fun pressHiButton() {
        // change the state variables when pressing the "say hi" button

    }

    fun pressRestartButton() {
        // change the state variables when pressing the "restart" button

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

                // --------------------------------------------
                // new name form ------------------------------
                // --------------------------------------------


                // the text label ---------------
                // containing the "insert name" guide message



                // the text field ---------------
                // here the user inserts its name


                // the button to say hi -----------
                // when pressed, you will receive a response back
                // saying hi, {your name}



                // end of new name form ---------------------------------

                // --------------------------------------------
                // message widget ------------------------------
                // --------------------------------------------
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxSize(0.6F),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {

                    // image composable ---------



                    // the message content -----------
                    // we use text components here to display the message
                    // the content will be updated as we update our app state



                    // message button, can either be "say goodbye" or "restart"
                    // depending on the message mode
                    if (messageMode == MESSAGE_MODE_HI) {
                        // say goodbye button -------------

                    } else {
                        // restart button ---------------

                    }
                }
                // end of message widget ---------------------------------

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