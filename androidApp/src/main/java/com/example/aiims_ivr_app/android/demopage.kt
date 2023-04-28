package com.example.aiims_ivr_app.android

import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
//import androidx.compose.foundation.layout.RowScopeInstance.align
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val scaffoldState = rememberScaffoldState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email
            ),
            modifier = Modifier.padding(16.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        Button(
            onClick = {
                if (email.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank()) {
                    if (password == confirmPassword) {
                        isLoading = true
                       CoroutineScope(Dispatchers.IO).launch {
                            registerUser(email, password, scaffoldState)
                        }
                    } else {
//                        scaffoldState.snackbarHostState.showSnackbar(
//                            "Passwords do not match"
//                        )
                    }
                } else {
//                    scaffoldState.snackbarHostState.showSnackbar(
//                        "Please fill all fields"
//                    )
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Register")
        }
    }

    if (isLoading) {
        CircularProgressIndicator(modifier = Modifier
            .size(48.dp)
            )
    }


}

private suspend fun registerUser(
    email: String,
    password: String,
    scaffoldState: ScaffoldState
) {
    Firebase.auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
//            if (task.isSuccessful) {
//                scaffoldState.snackbarHostState.showSnackbar(
//                    "Registration successful"
//                )
//            } else {
//                scaffoldState.snackbarHostState.showSnackbar(
//                    "Registration failed: ${task.exception?.message}"
//                )
//            }
        }
}
