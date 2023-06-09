package com.example.aiims_ivr_app.android.NURSE

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

//import com.google.firebase.database.ktx.database

data class nurseinfo(val name:String, val contact:String , val password:String)
@Composable
fun addnurse(navcontroller: NavHostController, context: Context) {

    var name by remember{
        mutableStateOf("")
    }

    var id by remember {
        mutableStateOf("")
    }

    var contact by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

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

            Text(text = "Add Nurse",modifier = Modifier.fillMaxWidth(), style = TextStyle(fontStyle = FontStyle.Normal, fontFamily = FontFamily.Cursive, fontSize = 40.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center))
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
                    OutlinedTextField(value = name, onValueChange = {name = it},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        label = {
                            Text(text = "Nurse Name")
                        })

                    Spacer(modifier = Modifier.height(30.dp))
                    OutlinedTextField(value = contact, onValueChange = {contact = it},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        label = {
                            Text(text = "Nurse Contact No.")
                        })

                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(value = id, onValueChange = {id = it},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        //keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        label = {
                            Text(text = "Nurse UID")
                        })

                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(value = password, onValueChange = {password = it},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        label = {
                            Text(text = "Password ")
                        })
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .horizontalScroll(
                            rememberScrollState()
                        ),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically) {

                        OutlinedButton(onClick = {
                            if ( name.isNotBlank() && contact.isNotBlank() && id.isNotBlank() && password.isNotBlank())
                            {
                                Toast.makeText(context,"Data Updated Successfully",Toast.LENGTH_LONG).show()
                                FirebaseDatabase.getInstance().getReference().child("nurses").child(id).setValue(nurseinfo(name,contact,password))
                                }
                            else
                            {
                                Toast.makeText(context,"Fields Empty",Toast.LENGTH_LONG).show()
                            }}, modifier = Modifier
                            .weight(1f)
                            .wrapContentSize(), colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = Color.Magenta,
                            contentColor = Color.White,
                        )) {
                            Text(text = "Add")

                        }
                        //Spacer(modifier = Modifier.width(20.dp))
//

                        //Spacer(modifier = Modifier.width(20.dp))
                        OutlinedButton(onClick = { if(id.isNotBlank())
                        {
                            FirebaseDatabase.getInstance().reference.child("nurses").child(id).removeValue().addOnCompleteListener { task
                                -> if(task.isSuccessful)
                            {
                                Toast.makeText(context,"Removed",Toast.LENGTH_LONG).show()
                            }
                            else
                            {
                                Toast.makeText(context,"Error",Toast.LENGTH_LONG).show()
                            }}
                        }
                            else
                        {
                            Toast.makeText(context,"Enter UID please",Toast.LENGTH_LONG).show()
                        }

                                                 }, modifier = Modifier
                            .weight(1f)
                            .wrapContentSize(), colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = Color.Magenta,
                            contentColor = Color.White,
                        )) {
                            Text(text = "Remove")

                        }
                        
                    }
                    Spacer(modifier = Modifier.height(20.dp))

                }


            }

        }
    }
}