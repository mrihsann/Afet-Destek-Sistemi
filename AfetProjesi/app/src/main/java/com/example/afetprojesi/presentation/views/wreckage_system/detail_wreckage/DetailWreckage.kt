package com.example.afetprojesi.presentation.views.wreckage_system.detail_wreckage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afetprojesi.R
import com.example.afetprojesi.presentation.views.hanger_system.detail_hanger.ImageCardDetail
import com.example.afetprojesi.ui.theme.AfetProjesiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailWreckage(onNavigateToPopBack:() -> Unit,onNavigateToReportTeam:() -> Unit){

    //apiden çekilen resimler buraya eklenecek
    val images = remember { mutableListOf(
        R.drawable.a,
        R.drawable.b
    ) }
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
            .fillMaxWidth()
            .padding(it)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())){

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color(96, 108, 56))
                    )
                    Column(modifier=Modifier.padding(start=10.dp)) {
                        Text(
                            text = "Alexander Müller", fontSize = 20.sp)
                        Spacer(modifier = Modifier.padding(3.dp))
                        Text(
                            text = "+49 123 456789", fontSize = 15.sp)
                    }
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "After a very strong earthquake, the sounds of those trapped under the rubble can be heard. Emergency teams need to arrive quickly!",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(15.dp))
            ImageCardDetail(images, modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium))
            Spacer(modifier = Modifier.height(16.dp))
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text = "Kahramanmaraş", textDecoration = TextDecoration.Underline)

            }
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedButton(onClick = { onNavigateToReportTeam() }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(3.dp)) {
                Text(text = "Go Help", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(96,108,56))
            }
            CommentCard(
                name = "Sarah Johnson",
                number = "+1 (555) 123-4567",
                description = "We've set out for the rubble. We'll do our best to rescue those trapped inside. Hopefully, everyone comes out safe and sound.")
            Box(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.Gray))
            CommentCard(
                name = "Alejandro Martinez",
                number = "+34 123 456 789",
                description = "We're prepared to rescue those trapped under the rubble. We have an 8-person mining team and an excavator operator with us. We'll intervene quickly and effectively.")
            Box(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.Gray))
            CommentCard(
                name = "Anna Petrov",
                number = "+7 987 654-32-10",
                description = "We're on our way! We're eager to rescue those trapped inside. We'll work together as a team and try to bring hope to those under the rubble.")
            Box(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.Gray))
            CommentCard(
                name = "Emily Smith",
                number = "+44 20 1234 5678",
                description = "We've immediately set out for the rubble. With 8 miners and an excavator operator on the team, we'll strive to reach those trapped under the rubble. Keep us in your prayers.")

        }
    }
}

@Preview
@Composable
fun GreetingPrevieww() {
    AfetProjesiTheme {
        DetailWreckage({}){}
    }
}