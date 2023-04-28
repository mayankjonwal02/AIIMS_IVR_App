package com.example.aiims_ivr_app.android

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aiims_ivr_app.android.navigation.screen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*


@Composable
fun SignIn(navcontroller: NavController, user: String? = "Hospital", context: Context) {

    var scaffoldState = rememberScaffoldState()
    var auth: FirebaseAuth
    auth = FirebaseAuth.getInstance()
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Surface(color = Color.White) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Sign In",
                fontSize = 60.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    fontFamily = FontFamily.Cursive,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "as $user",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.height(70.dp))
            Card(
                modifier = Modifier.fillMaxWidth(0.8f), shape = RoundedCornerShape(20.dp),
                backgroundColor = Color(0xFFFFC0CB),
                elevation = 8.dp,

                ) {
                var passwordVisible by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(30.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
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
                        value = password,
                        onValueChange = { password = it },
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
                    var route: String? = screen.signin.route
                    Spacer(modifier = Modifier.height(50.dp))
                    if (user == "Organisation") {
                        route = screen.callsetup.route
                    } else if (user == "Nurse") {
                        route = screen.patientdata.route
                    } else if (user == "Audio App") {
                        route = screen.audiosetup.route
                    }

                    Button(
                        onClick = {
                            if (email.isNotBlank() && password.isNotBlank()) {
                                CoroutineScope(Dispatchers.IO).launch {
                                    firebasesignin(email, password, context,navcontroller,user)

                                }

                            } else {

                                Toast.makeText(context," Fields Empty",Toast.LENGTH_LONG).show()

                            }

//                                  auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { it -> if(it.isSuccessful)
//                                  {
//                                      Toast.makeText(context,"Logined Successfully",Toast.LENGTH_LONG).show()
//                                  }
//                                  else
//                                  {
//                                      Toast.makeText(context,"Error",Toast.LENGTH_LONG).show()
//                                  }}


                        },
                        modifier = Modifier
                            .wrapContentWidth()

                            .padding(top = 16.dp),
                    ) {
                        Text(text = "Sign In")
                    }
                }
            }

            if (user != "Nurse") {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Not Registered Yet ? Sign up",
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        navcontroller.navigate("${screen.signup.route}/$user")
                    })
            }
        }
    }
}
