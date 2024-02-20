package com.example.afetprojesi.presentation.views.wreckage_system.list_wreckage

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.FilterAltOff
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import com.example.afetprojesi.R
import com.example.afetprojesi.presentation.views.general_ui.FilterChipFun

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOfWreckages(onNavigateToHomePage: () -> Unit,onNavigateToReportWreckagePage: () -> Unit,onNavigateToDetail:() -> Unit) {

    //filtre butonu aktifliği buradan ayarlanıyor
    val selectedFilter = remember { mutableStateOf(false) }
    //apiden gelen filtreler buraya eklenecek
    val namesFilter = remember { mutableListOf("Barınma","Giysi","Para","Ömer","Buğra") }
    //seçilen filtreler buraya geliyor
    val selectedFilters = remember { mutableListOf<String>() }

    //resimler buraya
    val images = remember { mutableListOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d,
        R.drawable.e,
        R.drawable.f,
        R.drawable.g,
        R.drawable.h,
        R.drawable.i
    ) }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(96,108,56),
                    titleContentColor = Color(254,250,224),
                ),
                title = {
                    Text("Wreckages")
                },
                navigationIcon = {
                    IconButton(onClick = { onNavigateToHomePage()}) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color(254,250,224))
                    }
                },
                actions = {

                    IconButton(onClick = { selectedFilter.value = !selectedFilter.value }) { // Tersine çevirme işlemi
                        if (selectedFilter.value) {
                            Icon(Icons.Filled.FilterAltOff, contentDescription = "More Vert", tint = Color(254,250,224))
                        } else {
                            Icon(Icons.Filled.FilterAlt, contentDescription = "More Vert", tint = Color(254,250,224))
                        }
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onNavigateToReportWreckagePage()
                },
                content = {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                },
                shape = RoundedCornerShape(20.dp),
                containerColor = Color(254,250,224),
                contentColor = Color(40,54,24)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color(254, 250, 224))
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxSize()
        ) {
            //filtreler animasyon ile açılıp kapanıyor
            AnimatedVisibility(
                visible = selectedFilter.value,
                enter = fadeIn(
                    animationSpec = tween(durationMillis = 500, delayMillis = 250)
                ),
                exit = fadeOut(
                    animationSpec = tween(durationMillis = 500, delayMillis = 250)
                )
            ) {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState())
                    ) {
                        namesFilter.forEach {
                            FilterChipFun(it,selectedFilters)
                            Spacer(modifier = Modifier.width(5.dp))
                        }
                    }
                }

            }
            Column(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(20.dp))
            {
                Spacer(modifier = Modifier.height(10.dp))
                SharingCard({ onNavigateToDetail() },
                    name="Emily Johnson",
                    number="+1 (555) 123-4567",
                    description="A building collapsed in the middle of our neighborhood, there are people trapped under the rubble! Please send emergency rescue teams!",
                    images=images.subList(0,3),
                    location="Malatya")
                SharingCard({ onNavigateToDetail() },
                    name="Alexander Müller",
                    number="+49 123 456789",
                    description="After a very strong earthquake, the sounds of those trapped under the rubble can be heard. Emergency teams need to arrive quickly!",
                    images=images.subList(3,6),
                    location="Kahramanmaraş")
                SharingCard({ onNavigateToDetail() },
                    name="Sophie Dubois ",
                    number="+33 612 3456 78",
                    description="The streets are filled with rubble, we can hear voices but there are also those who cannot be rescued. Please, we are waiting for urgent assistance!",
                    images=images.subList(6,9),
                    location="Adana")
                SharingCard({ onNavigateToDetail() },
                    name="David Smith",
                    number="+44 20 1234 5678",
                    description="The cries of people trapped under the building can be heard. Please, rescue teams, come quickly!",
                    images=images.subList(3,5),
                    location="Hatay")
                SharingCard({ onNavigateToDetail() },
                    name="Maria García",
                    number="+34 612 34 56 78",
                    description="After the earthquake, a building collapsed, the voices of those trapped under the rubble haven't stopped. Emergency teams need to come!",
                    images=images.subList(4,7),
                    location="Adıyaman")
                SharingCard({ onNavigateToDetail() },
                    name="Marco Rossi",
                    number="+39 02 1234567",
                    description="A building collapsed, there are people trapped under the rubble! Please, rescue teams, intervene immediately!",
                    images=images.subList(5,8),
                    location="Malatya")
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun TweetCardPrevieww() {
    ListOfWreckages({},{},{})
}