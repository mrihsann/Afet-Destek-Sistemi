package com.example.afetprojesi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.afetprojesi.presentation.views.help_system.list.HelpList
import com.example.afetprojesi.ui.theme.AfetProjesiTheme
import com.example.afetprojesi.viewModels.category.CategoryByIdViewModel
import com.example.afetprojesi.viewModels.category.CategoryListViewModel
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AfetProjesiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Sayfa()

           /*         HelpList(
                        onNavigateToHomePage = { *//*TODO*//* },
                        onNavigateToDetail = { *//*TODO*//* }) {
                    }*/
                }
            }
        }
    }



}
@Composable
fun Sayfa(){
    val viewModel : CategoryByIdViewModel = viewModel()

    val result = viewModel.data.observeAsState()

    val  error = viewModel.error.observeAsState()

    viewModel.getById(1)

    Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "${result.value?.data?.name}")
        Text(text = "${result.value?.success}")
        Text(text = "${result.value?.message}")

        if (error.value != null){
            Text(text = "${error.value?.message}")
            Text(text = "${error.value?.success}")
        }

    }

}


