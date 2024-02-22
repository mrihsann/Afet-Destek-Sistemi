package com.example.afetprojesi.presentation.views.hook_assistance_system.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.afetprojesi.presentation.views.general_ui.QuestionTitle

@Composable
fun AboutItem(title: MutableState<String>, description: MutableState<String>,paddingValues:PaddingValues){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(32.dp))
        QuestionTitle(title = "Write Details About the Product")
        Spacer(Modifier.height(18.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title.value,
            onValueChange = { title.value = it },
            label = { Text("Title") }

        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = description.value,
            onValueChange = { description.value = it },
            label = { Text("Description") },
        )
    }
}