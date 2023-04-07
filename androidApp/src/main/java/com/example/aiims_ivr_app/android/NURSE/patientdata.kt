package com.example.aiims_ivr_app.android.NURSE

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun patientdata() {
    
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White))
    {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
            
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
            Spacer(modifier = Modifier.height(20.dp))
            
            Text(text = "Patient Data",modifier = Modifier.fillMaxWidth(), style = TextStyle(fontStyle = FontStyle.Normal, fontFamily = FontFamily.Cursive, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center))
            Spacer(modifier = Modifier.height(60.dp))
            Card(
                Modifier
                    .fillMaxWidth()

                    .shadow(
                        10.dp,
                        RoundedCornerShape(20.dp), spotColor = Color(0xFFFFC0CB)
                    ),
            shape = RoundedCornerShape(20.dp),
                backgroundColor = Color(0xFFFFC0CB),
            ) {
                
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(30.dp))
                    OutlinedTextField(value = "", onValueChange = {},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                    label = {
                            Text(text = "Patient Name")
                    })

                    Spacer(modifier = Modifier.height(30.dp))
                    OutlinedTextField(value = "", onValueChange = {},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        label = {
                            Text(text = "Patient Age")
                        })

                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(value = "", onValueChange = {},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        label = {
                            Text(text = "Patient Contact no.")
                        })

                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(value = "", onValueChange = {},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        label = {
                            Text(text = "Operation Type ")
                        })

                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier.wrapContentSize(), colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color.Magenta,
                        contentColor = Color.White,
                    )) {
                        Text(text = "Submit")

                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    
                }
                
                
            }
            
        }
    }
}