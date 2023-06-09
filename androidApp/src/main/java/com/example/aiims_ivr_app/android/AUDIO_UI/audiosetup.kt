package com.example.aiims_ivr_app.android.AUDIO_UI

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun audiosetup(navcontroller: NavHostController) {
    
    Box(modifier = Modifier.fillMaxSize())
    {
        
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(40.dp))
            
            Text(text = "Audio Setup", modifier = Modifier
                .padding(30.dp)
                .fillMaxWidth(), style = TextStyle(textAlign = TextAlign.Center, fontWeight = FontWeight.ExtraBold, fontSize = 40.sp, fontFamily = FontFamily.Cursive, fontStyle = FontStyle.Normal),)
            Spacer(modifier = Modifier.height(90.dp))
            Card(modifier = Modifier
                .wrapContentSize()
                .shadow(10.dp, RoundedCornerShape(20.dp)), backgroundColor = Color.Green) {

                Text(text = "Start", style = TextStyle(fontSize = 50.sp), modifier = Modifier.padding(40.dp))
                
            }
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd)
            {
                OutlinedButton(onClick = { /*TODO*/ },modifier  = Modifier.padding(20.dp)) {
                    Text(text = "Add Audio")
                    
                }
            }
            
        }
        
    }
    
}