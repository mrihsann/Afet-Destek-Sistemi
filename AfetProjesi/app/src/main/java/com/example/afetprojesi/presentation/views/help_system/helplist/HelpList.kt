package com.example.afetprojesi.presentation.views.help_system.helplist

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.FilterAltOff
import androidx.compose.material3.Icon
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.afetprojesi.presentation.views.general_ui.FilterChipFun

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpList(onNavigateToHomePage: () -> Unit,onNavigateToDetail: () -> Unit) {

    //filtreler kısmını açan butonunu aktifliği burada kontrol ediliyor.
    val selectedFilter = remember { mutableStateOf(false) }

    //seçili filtreler burada tutuluyor, seçilen filtrelere göre listeleme yapacağız.
    val selectedFilters = remember { mutableListOf<String>() }

    //filtre listesini api ile çekip buraya yazdıracağız. Burası sahte veri şuanlık
    val listFilter = remember{ mutableListOf(
        "Giyim",
        "Yiyecek",
        "İçecek",
        "Ekip",
        "Aksesuar",
) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(96,108,56),
                    titleContentColor = Color(254,250,224),
                ),
                title = {
                    Text("Help List")
                },
                navigationIcon = {
                    IconButton(onClick = { onNavigateToHomePage()}) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color(254,250,224))
                    }
                },
                actions = {

                    IconButton(onClick = { selectedFilter.value = !selectedFilter.value }) {
                        if (selectedFilter.value) {
                            Icon(Icons.Filled.FilterAltOff, contentDescription = "More Vert", tint = Color(254,250,224))
                        } else {
                            Icon(Icons.Filled.FilterAlt, contentDescription = "More Vert", tint = Color(254,250,224))
                        }
                    }
                },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(Color(254, 250, 224))
                .padding(innerPadding)
                .padding(start = 15.dp, end = 15.dp, top = 15.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            //filtreler kısmını animasyonlu şekilde açıp kapatıyoruz
            AnimatedVisibility(
                visible = selectedFilter.value,
                enter = fadeIn(
                    animationSpec = tween(durationMillis = 500, delayMillis = 250)
                ),
                exit = fadeOut(
                    animationSpec = tween(durationMillis = 500, delayMillis = 250)
                )
            ) {
                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState())
                ) {
                    listFilter.forEach {
                        FilterChipFun(it,selectedFilters)
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(20.dp)){
                Spacer(modifier = Modifier.height(15.dp))
                HelpCard(
                    onNavigateToDetail=onNavigateToDetail,
                    name="Emily Johnson",
                    number="+1 (555) 123-4567",
                    description = "Hello, our home was damaged due to the earthquake and we need diapers and milk for our children. Can you help?",
                    location = "Adana")
                HelpCard(
                    onNavigateToDetail=onNavigateToDetail,
                    name="Lucas Martinez",
                    number="+44 1234 567890",
                    description = "Hi, our water supply has been cut off due to the earthquake and we need water. Please help.",
                    location = "Hatay")
                HelpCard(
                    onNavigateToDetail=onNavigateToDetail,
                    name="Sophia Müller",
                    number="+49 123 4567890",
                    description = "Hello, there is a power outage in our home after the earthquake and we can't buy baby formula. We need urgent assistance.",
                    location = "Adıyaman")
                HelpCard(
                    onNavigateToDetail=onNavigateToDetail,
                    name="Alexander Petrov",
                    number="+7 123 456-78-90",
                    description = "Hi, our food stock in the house has run out due to the earthquake and we are hungry. Can you provide food aid?",
                    location = "Malatya")

            }
        }
    }
}

@Preview
@Composable
fun prw(){
    HelpList({}) {

    }
}