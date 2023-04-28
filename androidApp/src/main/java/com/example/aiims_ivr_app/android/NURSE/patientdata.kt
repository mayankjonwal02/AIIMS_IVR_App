package com.example.aiims_ivr_app.android.NURSE

import addDaysToDate
import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.R
import androidx.compose.ui.graphics.painter.Painter

import androidx.navigation.NavHostController
import com.example.aiims_ivr_app.android.navigation.screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import getDaysSince
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import showdatepicker
import java.util.*



data class patientdatabase(  var name : String , var age :Int , var contact : String , var operationtype : String , var day : Int , var month : Int , var year: Int)
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun patientdata(navcontroller: NavHostController, context: Context) {



    var name by remember {
        mutableStateOf("")

    }

    var age by remember {
        mutableStateOf("")
    }

    var contact by remember {
        mutableStateOf("")
    }

    var operationtype by remember {
        mutableStateOf("")
    }
    var id by remember {
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
                    OutlinedTextField(value = id, onValueChange = {id = it},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        label = {
                            Text(text = "Patient UID")
                        })
                    Spacer(modifier = Modifier.height(30.dp))
                    OutlinedTextField(value = name, onValueChange = {name = it},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                    label = {
                            Text(text = "Patient Name")
                    })

                    Spacer(modifier = Modifier.height(30.dp))
                    OutlinedTextField(value = age, onValueChange = {age = it},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        label = {
                            Text(text = "Patient Age")
                        })

                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(value = contact, onValueChange = {contact = it},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        label = {
                            Text(text = "Patient Contact no.")
                        })

                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(value = operationtype, onValueChange = {operationtype = it},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        label = {
                            Text(text = "Operation Type ")
                        })
                    Spacer(modifier = Modifier.height(20.dp))
                    //==================

                    var year by remember {
                        mutableStateOf(2023)
                    }
                    var month by remember {
                        mutableStateOf(1)
                    }
                    var day by remember {
                        mutableStateOf(1)
                    }

                    var calendar = Calendar.getInstance()
//                    year = calendar.get(Calendar.YEAR)
//                    month = calendar.get(Calendar.MONTH)
//                    day= calendar.get(Calendar.DAY_OF_MONTH)
//                    calendar.time = Date()


                    val datepickerdialog = DatePickerDialog(
                        context, {_:DatePicker,year1:Int,month1:Int,dayofmonth:Int ->
                            year = year1
                            month = month1 + 1
                            day = dayofmonth
                        },year,month,day
                    )

                    var daystogo by remember {
                        mutableStateOf("")
                    }

                    //==============================
                    OutlinedTextField(value = "$day / $month / $year", onValueChange = {},
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        label = {
                            Text(text ="Operation Date ")
                        },
                    trailingIcon = {
                        IconButton(onClick = {
                            datepickerdialog.show()
                        }) {
                                Icon(Icons.Filled.DateRange, contentDescription = "")
                        }
                    })
                    var newdate : MutableList<Int> = mutableListOf(0,0,0)
                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(
                        value = daystogo,
                        onValueChange = {daystogo = it
                           },
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        label = {
                            Text(text = " Days to go ")
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    )

                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedButton(
                        onClick = {

                                  CoroutineScope(Dispatchers.IO).launch { newdate = addDaysToDate(day, month, year, daystogo.toInt())
                                      FirebaseDatabase.getInstance().getReference().child("Patients").child(id).setValue(patientdatabase(name,age.toInt(),contact,operationtype,newdate[0],newdate[1],newdate[2])) }
                            }, modifier = Modifier.wrapContentSize(), colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color.Magenta,
                        contentColor = Color.White,
                    )) {
                        Text(text = "Submit")

                    }
                    Spacer(modifier = Modifier.height(90.dp))
                    OutlinedButton(
                        onClick = {
                                    FirebaseAuth.getInstance().signOut()
                            navcontroller.navigate(screen.way.route)
                            }, modifier = Modifier.wrapContentSize(), colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = Color.Magenta,
                            contentColor = Color.White,
                        )) {
                        Text(text = "Sign out")

                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    
                }
                
                
            }
            
        }
    }
}