package com.example.afetprojesi.presentation.views.help_system.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.afetprojesi.presentation.views.general_ui.QuestionTitle

@Composable
fun PersonalInfoHelpPage(tc: MutableState<String>, name: MutableState<String>, surname: MutableState<String>, number: MutableState<String>,paddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(32.dp))
        QuestionTitle(title = "Personal Info")
        Spacer(Modifier.height(18.dp))
        Column(modifier = Modifier.fillMaxWidth()){
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = tc.value,
                onValueChange = {
                    if (it.length <= 11 && it.all { char -> char.isDigit() }) {
                        tc.value = it
                    }
                },
                label = { Text("ID") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = name.value,
                onValueChange = { name.value = it },
                label = { Text("Name") }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = surname.value,
                onValueChange = { surname.value = it },
                label = { Text("Surname") }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = number.value,
                onValueChange = { number.value = it },
                label = { Text("Phone Number") }
            )

        }
    }

}
