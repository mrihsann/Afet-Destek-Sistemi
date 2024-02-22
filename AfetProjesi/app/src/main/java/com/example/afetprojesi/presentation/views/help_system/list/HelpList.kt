package com.example.afetprojesi.presentation.views.help_system.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.FilterAltOff
import androidx.compose.material3.Icon
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
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
fun HelpList(onNavigateToHomePage: () -> Unit,onNavigateToDetail: () -> Unit,onNavigateToHelpForm: () -> Unit) {

    //filtreler kısmını açan butonunu aktifliği burada kontrol ediliyor.
    val selectedFilter = remember { mutableStateOf(false) }

    //seçili filtreler burada tutuluyor, seçilen filtrelere göre listeleme yapacağız.
    val selectedFilters = remember { mutableListOf<String>() }

    /*TODO(buraya apiden kategoriler gelecek ve buraya eklenecek.)*/
    val listFilter = remember{ mutableListOf("") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF282828),
                    titleContentColor = Color.White,
                ),
                title = {
                    Text("Help List")
                },
                navigationIcon = {
                    IconButton(onClick = { onNavigateToHomePage()}) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {

                    IconButton(onClick = { selectedFilter.value = !selectedFilter.value }) {
                        if (selectedFilter.value) {
                            Icon(Icons.Filled.FilterAltOff, contentDescription = "More Vert", tint = Color.White)
                        } else {
                            Icon(Icons.Filled.FilterAlt, contentDescription = "More Vert", tint = Color.White)
                        }
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { onNavigateToHelpForm() }, containerColor = Color(0xFF282828), contentColor = Color.White) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 15.dp, end = 15.dp),
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

            /*
            TODO(apiden çekilecek olan yardım talep verileri burada gösyterilecek.)
             */

        }
    }
}