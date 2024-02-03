package com.example.afetprojesi.presentation.views.help_system.detail_request

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afetprojesi.ui.theme.AfetProjesiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailRequest(id:String){
    //viewmodel ile ilgili ilanın detaylarını burada çekip göstereceğiz.
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Details")
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ){
        Column (modifier = Modifier
            .padding(it)
            .padding(15.dp)){
            Text(text = "Name")
            Text(text = "İhsan", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(2.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(text = "Surname")
            Text(text = "Arslan", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(5.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(2.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(text = "Category")
            Text(text = "Love", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(5.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(2.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Description")
            Text(text =
            """Burada ihtiyaç detayları yazacak not gibi Burada ihtiyaç detayları yazacak not gibiBurada ihtiyaç detayları yazacak not gibiBurada ihtiyaç detayları yazacak not gibiBurada ihtiyaç detayları yazacak not gibi
            """.trimMargin(), fontSize = 20.sp)
            Spacer(modifier = Modifier.height(5.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(2.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Location")
            Text(text = "City : Adana", fontSize = 20.sp)
            Text(text = "District : Seyhan", fontSize = 20.sp)
            Text(text = "Neighbourhood : Denizli", fontSize = 20.sp)
            Text(text = "Street : İsmetpaşa", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(5.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(2.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Location Note")
            Text(text = "Barbara Palvinin üst katı", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(5.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(2.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Phone Number")
            Text(text = "05314700685", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(5.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(2.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPrevieww() {
    AfetProjesiTheme {
        DetailRequest("id")
    }
}