package com.example.afetprojesi

import android.os.Bundle
import android.util.Log
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
import com.example.afetprojesi.dtos.requests.help_system.HelpRequestDto
import com.example.afetprojesi.dtos.enum_class.Status
import com.example.afetprojesi.ui.theme.AfetProjesiTheme
import com.example.afetprojesi.view_models.category.CategoryByIdViewModel
import com.example.afetprojesi.view_models.help_request.HelpRequestAddViewModel


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

                    AddRequest()

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
fun AddRequest(){

    val vm : HelpRequestAddViewModel = viewModel()
    val data = vm.data.observeAsState()
    val error = vm.error.observeAsState()


    Log.e("request_add_main",data.value.toString())
    Log.e("request_error_main",error.value?.data.toString())

    vm.addRequest(HelpRequestDto(
        tc = "40514455928",
        name = "ihsan",
        surname = "arslan",
        description = "Çok yakışıklıyım başım belada mı",
        birthDay = 2000,
        categoryId = 2,
        city = "Malatya",
        district = "Battalgazi",
        locationDescription = "beni soracak olursanız şinelin yanındayım",
        neighbourhood = "Şinel mahallesi",
        phone = "05314576531",
        status = Status.SUCCESS,
        street = "Şinel caddesi"

    ))

    Text(text = "${data.value?.message}")
    Text(text = "${error.value?.data.toString()}")

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


