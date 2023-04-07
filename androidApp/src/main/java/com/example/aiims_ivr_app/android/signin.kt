package com.example.aiims_ivr_app.android

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Preview
@Composable
fun SignIn() {
    Surface(color = Color.White) {

        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Sign In", fontSize = 60.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(), style = TextStyle(fontFamily = FontFamily.Cursive, fontStyle = FontStyle.Normal, textAlign = TextAlign.Center))
            Spacer(modifier = Modifier.height(100.dp))
            Card(
                modifier = Modifier.fillMaxWidth(0.8f),shape = RoundedCornerShape(20.dp),
                backgroundColor = Color(0xFFFFC0CB),
                elevation = 8.dp,

            ) {
                var passwordVisible by remember { mutableStateOf(false) }

                Column(modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {

                    Spacer(modifier = Modifier.height(30.dp))
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text(text = "Email") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Black,
                            unfocusedBorderColor = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    var passwordVisibility by remember { mutableStateOf(false) }

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text(text = "Password") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Black,
                            unfocusedBorderColor = Color.Black
                        ),
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                                Icon(
                                    imageVector = if (passwordVisibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                    contentDescription = if (passwordVisibility) "Hide password" else "Show password"
                                )
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(50.dp))

                    Button(onClick = { /* Handle sign-in */ }, modifier = Modifier
                        .wrapContentWidth()

                        .padding(top = 16.dp),
                    ) {
                        Text(text = "Sign In")
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Not Registered Yet ? Sign up", color = Color.Blue, fontWeight = FontWeight.Bold)
        }
    }
}
