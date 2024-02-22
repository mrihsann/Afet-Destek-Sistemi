package com.example.afetprojesi.presentation.views.hook_assistance_system.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afetprojesi.util.lerp
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SupportHelpCard(onNavigateToDetail:() -> Unit,images:MutableList<Int>,location:String,type:String,modifier: Modifier) {
    val pagerState = rememberPagerState(pageCount = { images.size })

    Column(modifier){
        OutlinedCard(
            modifier = Modifier
                .clip(RoundedCornerShape(2.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White),
            border = BorderStroke((0.5).dp, Color.LightGray),
            shape = RoundedCornerShape(20.dp),
            onClick = onNavigateToDetail
        ) {
            Box {
                HorizontalPager(state = pagerState) { page ->
                    Image(
                        painter = painterResource(id = images[page]),
                        contentDescription = "Image for support help",
                        modifier = Modifier
                            .height(250.dp)
                            .fillMaxWidth()
                            .graphicsLayer {
                                val pageOffset = (
                                        (pagerState.currentPage - page) + pagerState
                                            .currentPageOffsetFraction
                                        ).absoluteValue

                                alpha = lerp(
                                    start = 0.5f,
                                    stop = 1f,
                                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                )
                            },
                        contentScale = ContentScale.Crop
                    )
                }
                //location card
                ElevatedCard (modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 10.dp, top = 10.dp)){
                    Text(text = location, modifier = Modifier.padding(horizontal = 8.dp), fontSize = 13.sp)
                }


                // Add sliding indicators
                Box(modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 5.dp)
                    .background(
                        color = Color(
                            0x54000000
                        ), shape = RoundedCornerShape(16.dp)
                    )){
                    Row (modifier = Modifier.padding(horizontal = 6.dp)){
                        for (i in 0 until pagerState.pageCount) {
                            val indicatorColor = if (i == pagerState.currentPage) Color.Black else Color.White

                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .padding(2.dp)
                                    .background(color = indicatorColor, shape = CircleShape)
                            )
                        }
                    }
                }
            }
        }
        Text(text = type, modifier = Modifier.fillMaxWidth().padding(10.dp), textAlign = TextAlign.Center, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.DarkGray)
    }
}