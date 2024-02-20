package com.example.afetprojesi.presentation.views.help_system.detail_request

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afetprojesi.ui.theme.AfetProjesiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailRequest(onNavigateToPopBack:() -> Unit){

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(96,108,56),
                    titleContentColor = Color(254,250,224),
                ),
                title = {
                    Text("Details", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                },
                navigationIcon = {
                    IconButton(onClick = { onNavigateToPopBack()}) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color(254,250,224))
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Surface(shadowElevation = 7.dp) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .windowInsetsPadding(WindowInsets.systemBars.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom))
                            .padding(horizontal = 16.dp, vertical = 20.dp)
                    ) {
                        OutlinedButton(
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            onClick ={},
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Default.Message, contentDescription ="" ,tint=Color(96,108,56))
                            }
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            onClick = {},
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(96,108,56))
                        ) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Default.Phone, contentDescription ="" )
                            }
                        }
                    }
                }
            }
        }
    ){
        Column (modifier = Modifier
            .padding(it)
            .padding(horizontal = 30.dp)
            .verticalScroll(rememberScrollState())) {

            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "Emily Johnson", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedCard {
                Text(
                    text ="Hello, our home was damaged due to the earthquake and we need diapers and milk for our children. Can you help?"
                    , fontSize = 20.sp, color = Color.DarkGray,modifier=Modifier.padding(10.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
            ){
                OutlinedCard {
                    Text(text = "Adana", fontSize = 15.sp, modifier = Modifier.padding(5.dp))
                }
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedCard {
                    Text(text = "Seyhan", fontSize = 15.sp,modifier = Modifier.padding(5.dp))
                }
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedCard {
                    Text(text = "Denizli", fontSize = 15.sp,modifier = Modifier.padding(5.dp))
                }
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedCard {
                    Text(text = "İsmetpaşa", fontSize = 15.sp,modifier = Modifier.padding(5.dp))
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedCard(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Location Not :", modifier = Modifier.padding(10.dp))
                Text(text = "We are staying in container tent number 8, located next to the children's playground.", modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp), fontSize = 18.sp, color = Color.DarkGray)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AfetProjesiTheme {
        DetailRequest({""})
    }
}