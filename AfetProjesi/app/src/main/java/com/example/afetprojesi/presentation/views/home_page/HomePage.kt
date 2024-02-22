package com.example.afetprojesi.presentation.views.home_page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afetprojesi.presentation.views.general_ui.AlertDialog


@Composable
fun HomePage(onNavigateToHelpForm: () -> Unit, onNavigateToHelpList: () -> Unit, onNavigateToHookAssistanceForm: () -> Unit, onNavigateToHookAssistance: () -> Unit, onNavigateToReportWreckage: () -> Unit, onNavigateToWreckageList: () -> Unit){
    val openAlertDialog = remember { mutableStateOf(false) }

    Surface {
        when {
            openAlertDialog.value -> {
                AlertDialog( openAlertDialog )
            }
        }
        Column(modifier = Modifier.fillMaxSize()) {

            OutlinedCard (modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),colors = CardDefaults.cardColors(
                containerColor = Color(0xFF282828),
                    contentColor = Color.White
            ),
                shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)
            ){
                Row (modifier=Modifier.fillMaxSize()){
                    Column(modifier = Modifier.padding(top = 50.dp, start = 50.dp), verticalArrangement =Arrangement.Center) {
                        Text(text = "Welcome To", fontSize = 20.sp)
                        Text(text = "Disaster Support System", fontSize = 25.sp)
                    }
                }
            }
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column {
                    Row (modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()){
                        OutlinedCard(modifier = Modifier
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable { onNavigateToHelpForm() },
                            colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF282828)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Request", fontSize = 20.sp, color = Color.White)
                                Text(text = "for", fontSize = 15.sp, color = Color.White)
                                Text(text = "Help", fontSize = 20.sp, color = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        OutlinedCard(modifier = Modifier
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable { onNavigateToHelpList() },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF282828)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Requirement", fontSize = 20.sp, color = Color.White)
                                Text(text = "List", fontSize = 20.sp, color = Color.White)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()){
                        OutlinedCard(modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable { onNavigateToHookAssistanceForm() },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF282828)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Hook", fontSize = 18.sp, color = Color.White)
                                Text(text = "Assistance", fontSize = 18.sp, color = Color.White)
                                Text(text = "for", fontSize = 15.sp, color = Color.White)
                                Text(text = "Helper", fontSize = 18.sp, color = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))

                        OutlinedCard(modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable { onNavigateToHookAssistance() },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF282828)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Hook", fontSize = 18.sp, color = Color.White)
                                Text(text = "Assistance", fontSize = 18.sp, color = Color.White)
                                Text(text = "Disasters", fontSize = 18.sp, color = Color.White)
                                Text(text = "Victim", fontSize = 18.sp, color = Color.White)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()){
                        OutlinedCard(modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable {
                                onNavigateToReportWreckage()
                            },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF282828)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Report", fontSize = 20.sp, color = Color.White)
                                Text(text = "Wreckage", fontSize = 20.sp, color = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))

                        OutlinedCard(modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable {
                                onNavigateToWreckageList()
                            },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF282828)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Wreckage", fontSize = 20.sp, color = Color.White)
                                Text(text = "List", fontSize = 20.sp, color = Color.White)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()){
                        OutlinedCard(modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable {
                                openAlertDialog.value=true
                            },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF282828)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Icon(imageVector = Icons.Default.AddAlert, contentDescription = "",Modifier.size(40.dp), tint = Color.White)
                                Text(text = "S.O.S", fontSize = 20.sp, color = Color.White)

                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))

                        OutlinedCard(modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable {

                            },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFF282828)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Icon(imageVector = Icons.Default.Mail, contentDescription = "",Modifier.size(40.dp), tint = Color.White)
                                Text(text = "Send FeedBack", fontSize = 20.sp, color = Color.White)
                            }
                        }
                    }
                }
            }
        }
    }
}