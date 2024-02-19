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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.afetprojesi.presentation.views.general_ui.FilterChipFun
import com.example.afetprojesi.presentation.views.help_system.helplist.HelpList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HangerList(onNavigateToHomePage: () -> Unit) {

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
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Hanger Help")
                },
                navigationIcon = {
                    IconButton(onClick = { onNavigateToHomePage()}) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {

                    IconButton(onClick = { selectedFilter.value = !selectedFilter.value }) { // Tersine çevirme işlemi
                        if (selectedFilter.value) {
                            Icon(Icons.Filled.FilterAltOff, contentDescription = "More Vert")
                        } else {
                            Icon(Icons.Filled.FilterAlt, contentDescription = "More Vert")
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

            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                //apiden çekilecek veriye göre burası yeniden yazılacak
                items(50) {
                    SupportHelpCard()
                }
            }
        }
    }
}


@Preview
@Composable
fun prw(){
    HangerList {

    }
}