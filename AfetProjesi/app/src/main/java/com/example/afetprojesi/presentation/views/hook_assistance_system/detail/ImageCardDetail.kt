package com.example.afetprojesi.presentation.views.hook_assistance_system.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.afetprojesi.util.lerp
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageCardDetail(images: MutableList<Int>,modifier: Modifier) {

    val pagerState = rememberPagerState(pageCount = { images.size })

    OutlinedCard(
        modifier = modifier,
        colors = CardDefaults.cardColors(
        containerColor = Color.White),
        border = BorderStroke((0.5).dp, Color.LightGray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box {
            HorizontalPager(state = pagerState) { page ->
                AsyncImage(
                    model = images[page],
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
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
                                .size(20.dp)
                                .padding(5.dp)
                                .background(color = indicatorColor, shape = CircleShape)
                        )
                    }
                }
            }
        }
    }
}

