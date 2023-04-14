package com.example.aiims_ivr_app.android

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aiims_ivr_app.android.navigation.screen


@Composable
fun signinas(navController: NavController,heading:String = "Using App as") {
    
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.TopCenter
    )
    {
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = heading, modifier =Modifier.fillMaxWidth(), style = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily.Cursive, fontStyle = FontStyle.Normal, textAlign = TextAlign.Center))
            Spacer(modifier = Modifier.height(90.dp))
            Card(modifier = Modifier
                .wrapContentSize()
                .padding(20.dp)
                .shadow(
                    40.dp,
                    RoundedCornerShape(20.dp), spotColor = Color.Red
                )
                , shape = RoundedCornerShape(20.dp)
            ) {
                
                Text(text = "Organisation", modifier = Modifier.padding(30.dp).clickable{
                    navController.navigate("${screen.signin.route}/${"Organisation"}")
                }, style = TextStyle(fontStyle = FontStyle.Normal, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center))
                
            }
            Spacer(modifier = Modifier.height(30.dp))
            Card(modifier = Modifier
                .wrapContentSize()
                .padding(20.dp)
                .shadow(
                    40.dp,
                    RoundedCornerShape(20.dp), spotColor = Color.Red
                ), shape = RoundedCornerShape(20.dp)
            ) {

                Text(text = "Nurse", modifier = Modifier.padding(30.dp).clickable{
                    navController.navigate("${screen.signin.route}/${"Nurse"}")
                }, style = TextStyle(fontStyle = FontStyle.Normal, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center))

            }
            Spacer(modifier = Modifier.height(30.dp))
            Card(modifier = Modifier
                .wrapContentSize()
                .padding(40.dp)
                .shadow(
                    40.dp,
                    RoundedCornerShape(20.dp), spotColor = Color.Red
                ), shape = RoundedCornerShape(20.dp)
            ) {

                Text(text = "Audio App", modifier = Modifier.padding(30.dp).clickable{
                    navController.navigate("${screen.signin.route}/${"Audio App"}")
                }, style = TextStyle(fontStyle = FontStyle.Normal, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Center))

            }
            
        }
        
    }
    
}