package com.example.afetprojesi.presentation.views.home_page

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomePage(onNavigateToHelpForm: () -> Unit,onNavigateToHelpList: () -> Unit,onNavigateToHangerForm: () -> Unit,onNavigateToHangerList: () -> Unit,onNavigateToReportWreckagePage: () -> Unit,onNavigateToWreckageListPage: () -> Unit){
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            OutlinedCard (modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),colors = CardDefaults.cardColors(
                containerColor = Color(252, 163, 17)
            ),
                shape = RoundedCornerShape(0.dp)
            ){
                Row (modifier=Modifier.fillMaxSize()){
                    Column(modifier = Modifier.padding(top = 50.dp, start = 50.dp), verticalArrangement =Arrangement.Center) {
                        Text(text = "Welcome", fontSize = 24.sp, color = Color(229, 229, 229))
                        Text(text = "Ömer Gayi", fontSize = 32.sp, color = Color(229, 229, 229))
                    }
                }
            }
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column {
                    Row (modifier = Modifier
                        .padding(horizontal = 50.dp)
                        .fillMaxWidth()){
                        OutlinedCard(modifier = Modifier
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable { onNavigateToHelpForm() },
                            colors = CardDefaults.cardColors(
                            containerColor = Color(20, 33, 61)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Request", fontSize = 20.sp, color = Color(229, 229, 229))
                                Text(text = "for", fontSize = 15.sp, color = Color(229, 229, 229))
                                Text(text = "Help", fontSize = 20.sp, color = Color(229, 229, 229))
                            }
                        }
                        OutlinedCard(modifier = Modifier
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable { onNavigateToHelpList() },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(20, 33, 61)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Requirement", fontSize = 20.sp, color = Color(229, 229, 229))
                                Text(text = "List", fontSize = 20.sp, color = Color(229, 229, 229))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row (modifier = Modifier
                        .padding(horizontal = 50.dp)
                        .fillMaxWidth()){
                        OutlinedCard(modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable { onNavigateToHangerForm() },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(20, 33, 61)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Load Product", fontSize = 20.sp, color = Color(229, 229, 229))
                                Text(text = "on", fontSize = 15.sp, color = Color(229, 229, 229))
                                Text(text = "Hanger", fontSize = 20.sp, color = Color(229, 229, 229))
                            }
                        }
                        OutlinedCard(modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable { onNavigateToHangerList() },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(20, 33, 61)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Look", fontSize = 20.sp, color = Color(229, 229, 229))
                                Text(text = "at the", fontSize = 15.sp, color = Color(229, 229, 229))
                                Text(text = "Hanger", fontSize = 20.sp, color = Color(229, 229, 229))
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row (modifier = Modifier
                        .padding(horizontal = 50.dp)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly){
                        OutlinedCard(modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable {
                                onNavigateToReportWreckagePage()
                            },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(20, 33, 61)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Report", fontSize = 20.sp, color = Color(229, 229, 229))
                                Text(text = "Wreckage", fontSize = 20.sp, color = Color(229, 229, 229))
                            }
                        }
                        OutlinedCard(modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable {
                                onNavigateToWreckageListPage()
                            },
                            colors = CardDefaults.cardColors(
                                containerColor = Color(20, 33, 61)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Look", fontSize = 20.sp, color = Color(229, 229, 229))
                                Text(text = "at the", fontSize = 15.sp, color = Color(229, 229, 229))
                                Text(text = "Wreckage", fontSize = 20.sp, color = Color(229, 229, 229))
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun pre(){
    HomePage(
        onNavigateToHelpForm = { /*TODO*/ },
        onNavigateToHelpList = { /*TODO*/ },
        onNavigateToHangerForm = { /*TODO*/ },
        onNavigateToHangerList = { /*TODO*/ },
        onNavigateToReportWreckagePage = { /*TODO*/ }) {
        
    }
}

