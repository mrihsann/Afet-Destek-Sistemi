package com.example.afetprojesi.presentation.views.hanger_system.list_hanger

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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.FilterAltOff
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.afetprojesi.presentation.views.help_system.helplist.HelpList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HangerList(onNavigateToHomePage: () -> Unit,onNavigateToDetail:() -> Unit) {

    val images=remember{ mutableListOf<Int>(
        R.drawable.aa,
        R.drawable.bb,
        R.drawable.cc,
        R.drawable.dd,
        R.drawable.ee,
        R.drawable.z,
        R.drawable.x,
        R.drawable.v,
        R.drawable.n
        ) }

    //filtreler kısmını açan butonunu aktifliği burada kontrol ediliyor.
    val selectedFilter = remember { mutableStateOf(false) }
    //seçili filtreler burada tutuluyor
    val namesFilter = remember { mutableListOf("Barınma","Giysi","Para","Ömer","Buğra") }
    //filtre listesini api ile çekip buraya yazdıracağız. Burası sahte veri şuanlık
    val selectedFilters = remember { mutableListOf<String>() }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(96,108,56),
                    titleContentColor = Color(254,250,224),
                ),
                title = {
                    Text("Hook Assistance")
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
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            //filtre sayfasının açılışını animasyonlu yapıyoruz
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
                    namesFilter.forEach {
                        FilterChipFun(it,selectedFilters)
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }
            }

            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    SupportHelpCard(
                        onNavigateToDetail = { onNavigateToDetail() },
                        images = images.subList(5,6) ,
                        location="Kahramanaraş",
                        type="Scarf",
                        Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(10.dp))
                    SupportHelpCard(
                        onNavigateToDetail = { onNavigateToDetail() },
                        images = images.subList(0,1),
                        location="Hatay",
                        type="Hat",
                        Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(10.dp))
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    SupportHelpCard(
                        onNavigateToDetail = { onNavigateToDetail() },
                        images = images.subList(1,2) ,
                        location="Adana",
                        type="Glove",
                        Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(10.dp))
                    SupportHelpCard(
                        onNavigateToDetail = { onNavigateToDetail() },
                        images = images.subList(2,3),
                        location="Malatya",
                        type="Coat",
                        Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(10.dp))
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    SupportHelpCard(
                        onNavigateToDetail = { onNavigateToDetail() },
                        images = images.subList(3,4) ,
                        location="Adıyaman",
                        type="Shoe",
                        Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(10.dp))
                    SupportHelpCard(
                        onNavigateToDetail = { onNavigateToDetail() },
                        images = images.subList(4,5),
                        location="Hatay",
                        type="Duvet",
                        Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(10.dp))
                }
            }

        }
    }
}


@Preview
@Composable
fun prw(){
    HangerList({}) {
    }
}