package com.example.afetprojesi.presentation.views.general_ui

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipFun(filtername:String, selectedFilters: MutableList<String>) {
    //seçili olup olmadığını burada tutuyoruz
    val selected = remember { mutableStateOf(false) }
    //Aşağıdaki satır, seçilen Filtreler değişkeninde geçerli kategoriyi arar ve varsa durumu true olarak ayarlar.
    selected.value = selectedFilters.contains(filtername)

    FilterChip(
        onClick = {
            selected.value = !selected.value
            if (selected.value) {
                selectedFilters.add(filtername)
            } else {
                selectedFilters.remove(filtername)
            }
        },
        label = {
            Text(filtername)
        },
        selected = selected.value,
        leadingIcon = if (selected.value) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}