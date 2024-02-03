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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomePage(onNavigateToHelpForm: () -> Unit,onNavigateToHelpList: () -> Unit,onNavigateToHangerForm: () -> Unit,onNavigateToHangerList: () -> Unit,onNavigateToReportWreckagePage: () -> Unit,onNavigateToWreckageListPage: () -> Unit){
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            OutlinedCard (modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 50.dp, bottomEnd = 50.dp)
            ){
                Row {
                    Column(modifier = Modifier.padding(top = 50.dp, start = 50.dp)) {
                        Text(text = "Welcome", fontSize = 20.sp)
                        Text(text = "İhsan", fontSize = 40.sp)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(imageVector = Icons.Default.Person, contentDescription = "", modifier = Modifier
                        .padding(50.dp)
                        .size(90.dp))
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
                            containerColor = MaterialTheme.colorScheme.primaryContainer),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Request", fontSize = 20.sp)
                                Text(text = "for", fontSize = 15.sp)
                                Text(text = "Help", fontSize = 20.sp)
                            }
                        }
                        OutlinedCard(modifier = Modifier
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable { onNavigateToHelpList() },
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Requirement", fontSize = 20.sp)
                                Text(text = "List", fontSize = 20.sp)
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
                                containerColor = MaterialTheme.colorScheme.primaryContainer),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Load Product", fontSize = 20.sp)
                                Text(text = "on", fontSize = 15.sp)
                                Text(text = "Hanger", fontSize = 20.sp)
                            }
                        }
                        OutlinedCard(modifier = Modifier
                            .width(120.dp)
                            .height(120.dp)
                            .weight(1f)
                            .padding(5.dp)
                            .clickable { onNavigateToHangerList() },
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Look", fontSize = 20.sp)
                                Text(text = "at the", fontSize = 15.sp)
                                Text(text = "Hanger", fontSize = 20.sp)
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
                                containerColor = MaterialTheme.colorScheme.primaryContainer),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Report", fontSize = 20.sp)
                                Text(text = "Wreckage", fontSize = 20.sp)
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
                                containerColor = MaterialTheme.colorScheme.primaryContainer),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Column (modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                                Text(text = "Look", fontSize = 20.sp)
                                Text(text = "at the", fontSize = 15.sp)
                                Text(text = "Wreckage", fontSize = 20.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}