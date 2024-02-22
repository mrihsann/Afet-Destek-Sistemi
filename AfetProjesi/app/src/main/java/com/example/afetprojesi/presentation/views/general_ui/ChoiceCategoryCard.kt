package com.example.afetprojesi.presentation.views.general_ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChoiceCategoryCard(text:String, selectedList: MutableList<String>){
    //seçili olup olmadığını kontrol ediyoruz
    var selected by remember{ mutableStateOf(false) }

    //Aşağıdaki satır, seçilen Liste değişkeninde geçerli kategoriyi arar ve varsa durumu true olarak ayarlar.
    selected = selectedList.contains(text)

    Surface(
        shape = MaterialTheme.shapes.small,
        color = if (selected) {
            Color(0, 0, 0, 25)
        } else {
            MaterialTheme.colorScheme.surface
        },
        border = BorderStroke(
            width = 1.dp,
            color = if (selected) {
                Color(0xFF282828)
            } else {
                MaterialTheme.colorScheme.outline
            }
        ),
        modifier = Modifier
            .clip(MaterialTheme.shapes.small)
            .padding(vertical = 5.dp )
            .clickable(onClick = {
                // Seçim durumunu tersine çevir.
                selected = !selected

                // Eğer seçili öğelerin listesi boş değilse, tüm seçili öğeleri kaldır ve yeni seçilen öğeyi ekle.
                if (selectedList.size > 0) {
                    selectedList.removeAll(selectedList)
                    selectedList.add(text)
                } else {
                    // Seçim durumuna göre işlem yapılır.
                    if (selected) {
                        // Eğer seçiliyse ve listede bulunmuyorsa, seçili öğeyi ekle.
                        if (!selectedList.contains(text)) {
                            selectedList.add(text)
                        }
                    } else {
                        // Eğer seçili değilse, öğeyi listeden kaldır.
                        selectedList.remove(text)
                    }
                }
            })
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text, Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
            Box(modifier = Modifier.padding(8.dp)) {
                Checkbox(
                    checked = selected,
                    onCheckedChange = { newCheckedState ->
                        selected=newCheckedState
                    }
                )
            }

        }
    }
}
