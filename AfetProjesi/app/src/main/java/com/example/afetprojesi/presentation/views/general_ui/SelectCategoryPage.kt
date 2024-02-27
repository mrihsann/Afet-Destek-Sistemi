package com.example.afetprojesi.presentation.views.general_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.afetprojesi.dtos.responses.categories.CategoryResponseDto

//kategori seçimi yapılan sayfa
@Composable
fun SelectCategoryPage(listCategory:List<CategoryResponseDto>?, selectedCategoryList:MutableList<String>, paddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(32.dp))
        QuestionTitle(title = "Select a Category")
        Spacer(Modifier.height(18.dp))
        listCategory?.forEach {
            ChoiceCategoryCard(it.name,selectedCategoryList)
        }
    }
}