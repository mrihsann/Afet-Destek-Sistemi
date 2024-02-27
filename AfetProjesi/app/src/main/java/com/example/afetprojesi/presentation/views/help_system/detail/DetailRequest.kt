package com.example.afetprojesi.presentation.views.help_system.detail

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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.afetprojesi.presentation.view_models.help_system.HelpSystemGetByIdViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailRequest(onNavigateToPopBack:() -> Unit,id:String?){

    /* TODO(viewmodelden veriyi çekemiyoruz hata veriyor) */
    val viewModel: HelpSystemGetByIdViewModel = viewModel()
    viewModel.getByRequestTc(id!!)
    val data=viewModel.data.observeAsState()
    val dataa=data.value?.data

    val name= dataa?.name+" "+dataa?.surname
    val description=dataa?.description
    val city=dataa?.city
    val district=dataa?.district
    val neighbourhood=dataa?.neighbourhood
    val street=dataa?.street
    val locationNot=dataa?.locationDescription


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF282828),
                    titleContentColor = Color.White,
                ),
                title = {
                    Text("Details", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                },
                navigationIcon = {
                    IconButton(onClick = { onNavigateToPopBack()}) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
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
                            IconButton(onClick = { /*TODO(buraya tıklandığı zaman kişiye mesaj atma fonksiyonu çalışacak. Ve o kişiye sms atabilecek)*/}) {
                                Icon(imageVector = Icons.AutoMirrored.Filled.Message, contentDescription ="" ,tint=Color(0xFF282828))
                            }
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            onClick = {},
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF282828))
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
            .padding(horizontal = 30.dp)
            .verticalScroll(rememberScrollState())) {

            Spacer(modifier = Modifier.height(15.dp))

            Text(text = name, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedCard {
                if (description != null) {
                    Text(
                        text = description, fontSize = 20.sp, color = Color.DarkGray,modifier=Modifier.padding(10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
            ){
                OutlinedCard {
                    if (city != null) {
                        Text(text = city, fontSize = 15.sp, modifier = Modifier.padding(5.dp))
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedCard {
                    if (district != null) {
                        Text(text = district, fontSize = 15.sp,modifier = Modifier.padding(5.dp))
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedCard {
                    if (neighbourhood != null) {
                        Text(text = neighbourhood, fontSize = 15.sp,modifier = Modifier.padding(5.dp))
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                OutlinedCard {
                    if (street != null) {
                        Text(text = street, fontSize = 15.sp,modifier = Modifier.padding(5.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedCard(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Location Not :", modifier = Modifier.padding(10.dp))
                if (locationNot != null) {
                    Text(text = locationNot, modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp), fontSize = 18.sp, color = Color.DarkGray)
                }
            }
        }

    }
}
