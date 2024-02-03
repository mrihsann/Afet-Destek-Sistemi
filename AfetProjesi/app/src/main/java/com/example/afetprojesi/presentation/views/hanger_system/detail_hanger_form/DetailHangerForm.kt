package com.example.afetprojesi.presentation.views.hanger_system.detail_hanger_form

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afetprojesi.ui.theme.AfetProjesiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailHangerForm(id:String){

    //apiden çekilen resimler buraya eklenecek
    val images = remember { mutableListOf(
        android.R.drawable.ic_delete,
        android.R.drawable.btn_star_big_on
    ) }
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
            .padding(15.dp)
            .verticalScroll(rememberScrollState())){
            ImageCardDetail(images, modifier = Modifier
                .clip(RoundedCornerShape(2.dp))
                .fillMaxWidth()
                .height(400.dp))

            Spacer(modifier = Modifier.height(15.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .height(2.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))

            Text(text = "Phone Number")
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text = "05314700685", fontSize = 20.sp)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /*TODO*/ }) {
                    Image(imageVector = Icons.Default.Message, contentDescription = "Message Button")

                }
                IconButton(onClick = { /*TODO*/ }) {
                    Image(imageVector = Icons.Default.Call, contentDescription = "Calling Button")
                }
            }

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

            Text(text = "Title")
            Text(text = "Darbuka", fontSize = 20.sp)
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
        DetailHangerForm("id")
    }
}