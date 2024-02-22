package com.example.afetprojesi.presentation.views.hook_assistance_system.detail

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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPage(onNavigateToPopBack:() -> Unit){

    /*
    TODO(seçilen yardım kartının detayları burada görünecek, detayları ilgili değişkenlere ata)
     */
    val images = remember {
        mutableListOf<Int>()
    }
    val title=""
    val description=""
    val location=""
    val category=""


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor =  Color(0xFF282828),
                    titleContentColor = Color.White,
                ),
                title = {
                    Text("Details", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                },
                navigationIcon = {
                    IconButton(onClick = { onNavigateToPopBack()}) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
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
                            IconButton(onClick = { /*TODO(buraya tıklandığı zaman kişiye mesaj atma fonksiyonu çalışacak. Ve o kişiye sms atabilecek)*/ }) {
                                Icon(imageVector = Icons.Default.Message, contentDescription ="" ,tint= Color(0xFF282828))
                            }
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            onClick = {},
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFF282828))
                        ) {
                            IconButton(onClick = { /*TODO(buraya tıklandığı zaman kişiyi arama fonksiyonu çalışacak. Ve o kişiyi arayabilecek)*/ }) {
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
            .padding(20.dp)
            .verticalScroll(rememberScrollState())) {
            ImageCardDetail(
                images, modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .fillMaxWidth()
                    .height(400.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))
            Text(text = title, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text =description)
            Spacer(modifier = Modifier.height(15.dp))
            Row (modifier = Modifier.fillMaxWidth()){
                OutlinedCard {
                    Text(text = location, fontSize = 20.sp, modifier = Modifier.padding(5.dp))
                }
                Spacer(modifier = Modifier.width(10.dp))
                Spacer(modifier = Modifier.weight(1f))
                OutlinedCard (colors = CardDefaults.cardColors()){
                    Text(text = category, fontSize = 20.sp, modifier = Modifier.padding(5.dp))
                }
            }

        }
    }
}
