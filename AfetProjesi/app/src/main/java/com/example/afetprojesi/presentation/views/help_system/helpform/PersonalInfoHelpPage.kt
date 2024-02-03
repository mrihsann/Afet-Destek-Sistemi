package com.example.afetprojesi.presentation.views.help_system.helpform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.afetprojesi.presentation.views.general_ui.QuestionTitle
import com.loftymr.countrycp.CountryCP

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
                label = { Text("TC") },
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

            val showError = remember { mutableStateOf(false) }

            CountryCP(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                text = number.value,
                shape = RoundedCornerShape(5.dp),
                showError = showError.value,
                errorText = "Enter correct phone number",
                onValueChange = { number.value = it },
                phonePlaceholder = {
                    Text(text = "xxx xxx xx xx")
                }
                ,
                errorTextPaddings = PaddingValues(vertical = 2.dp, horizontal = 16.dp),
                phoneFieldColors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor =MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = Color.Gray,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    errorContainerColor = if (showError.value) Color(0xFFFFE5E5) else Color.Transparent
                )
            )

        }
    }

}
