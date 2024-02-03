package com.example.afetprojesi.presentation.views.wreckage_system.list_wreckage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.afetprojesi.R
import com.example.afetprojesi.presentation.views.hanger_system.detail_hanger_form.ImageCardDetail

@Composable
fun SharingCard() {
    //like sayısı buraya
    var likeCount by remember { mutableIntStateOf(0) }

    //resimler buraya
    val images = remember { mutableListOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c
    ) }

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
                text = "5 Katlı bina çöktü, hala içeride sağ olanlar var acil yardım lazım.",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row (verticalAlignment = Alignment.CenterVertically){
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center, modifier = Modifier.padding(end = 16.dp)) {
                    IconButton(onClick = { likeCount++ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropUp,
                            contentDescription = null,
                            modifier = Modifier
                                .size(35.dp)
                        )
                    }
                    Text(text = "${if (likeCount<0){"-"} else if (likeCount>0){"+"} else {""}}$likeCount")
                    IconButton(onClick = { likeCount-- }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null,
                            modifier = Modifier
                                .size(35.dp)
                        )
                    }
                }
                ImageCardDetail(images, modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(MaterialTheme.shapes.medium))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Text(text = "Malatya Battalgazi", textDecoration = TextDecoration.Underline)
                Spacer(modifier = Modifier.weight(1f))
                OutlinedCard(colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)) {
                    Row(modifier = Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Go Help")
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(imageVector = Icons.Default.Send, contentDescription = "")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TweetCardPreview() {

    SharingCard()

}