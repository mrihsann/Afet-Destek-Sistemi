package com.example.afetprojesi.presentation.views.wreckage_system.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afetprojesi.R
import com.example.afetprojesi.presentation.views.hook_assistance_system.detail.ImageCardDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailWreckage(onNavigateToPopBack:() -> Unit,onNavigateToReportTeam:() -> Unit){

    /*
    TODO(seçilen yardım kartının detayları burada görünecek, detayları ilgili değişkenlere ata)
     */
    val images = remember {
        mutableListOf<Int>()
    }
    val name=""
    val number=""
    val descripton=""
    val location=""

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
                            IconButton(onClick = { /*TODO(buraya tıklandığı zaman kişiyi arama fonksiyonu çalışacak. Ve o kişiyi arayabilecek)*/}) {
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
                            .background(Color(0xFF282828))
                    )
                    Column(modifier=Modifier.padding(start=10.dp)) {
                        Text(
                            text = name, fontSize = 20.sp)
                        Spacer(modifier = Modifier.padding(3.dp))
                        Text(
                            text = number, fontSize = 15.sp)
                    }
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = descripton,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(15.dp))
            ImageCardDetail(images, modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium))
            Spacer(modifier = Modifier.height(16.dp))
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text = location, textDecoration = TextDecoration.Underline)

            }
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedButton(onClick = { onNavigateToReportTeam() }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(3.dp)) {
                Text(text = "Go Help", fontWeight = FontWeight.Bold, fontSize = 20.sp, color =  Color(0xFF282828))
            }
            /*
            TODO(enkaza giden yardımlar yorum kartı şeklinde gösterilecek burada, kart tasarımı olarak CommentCard kullanılacak)
             */

        }
    }
}
