package com.example.afetprojesi.presentation.views.wreckage_system.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afetprojesi.R

@Composable
fun CommentCard(name:String,number:String,description:String) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)){

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
                    .background( Color(0xFF282828))
            )
            Column(modifier=Modifier.padding(start=10.dp)) {
                Text(
                    text = name, fontSize = 20.sp)
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    text = number, fontSize = 15.sp)
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = description, modifier = Modifier.padding(start=58.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.DarkGray
        )

    }
}
