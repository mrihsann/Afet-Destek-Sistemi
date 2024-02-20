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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afetprojesi.R
import com.example.afetprojesi.presentation.views.hanger_system.detail_hanger.ImageCardDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharingCard(onNavigateToDetail:() -> Unit,name:String,number:String,description:String,images:MutableList<Int>,location:String) {

    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(Color(40,54,24)),
        onClick = { onNavigateToDetail() }
    ) {
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)){

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
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color(96, 108, 56))
                    )
                    Column(modifier=Modifier.padding(start=10.dp)) {
                        Text(
                            text = name, fontSize = 20.sp, color = Color(254,250,224))
                        Spacer(modifier = Modifier.padding(3.dp))
                        Text(
                            text = number, fontSize = 15.sp, color = Color(254,250,224))
                    }
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint=Color(254,250,224)
                    )
                }

            }
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                color = Color(254,250,224)
            )
            Spacer(modifier = Modifier.height(20.dp))

            ImageCardDetail(images, modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium))
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = location, color = Color(254,250,224), textDecoration = TextDecoration.Underline)
        }
    }
}
