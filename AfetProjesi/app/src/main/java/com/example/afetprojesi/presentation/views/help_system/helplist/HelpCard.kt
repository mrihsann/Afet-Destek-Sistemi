package com.example.afetprojesi.presentation.views.help_system.helplist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.afetprojesi.R

@Composable
fun HelpCard(){
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)){

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                    Column {
                        Text(
                            text = "İhsan Arslan")
                        Text(
                            text = "0531 470 06 85")
                    }
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            Text(
                text = "Havalar çok soğuk battaniye ve kıyafet ihtiyacımız var. Toplam 5 kişiyiz. 5 kişilik tedarik lazım",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(color = Color.DarkGray))
            Spacer(modifier = Modifier.height(10.dp))
            Row (verticalAlignment = Alignment.CenterVertically){
                Text(text = "Malatya Battalgazi", textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.weight(1f))
                OutlinedCard(colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)) {
                    Text(text = "Giyim", modifier = Modifier.padding(5.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun prewiew(){
    HelpCard()
}