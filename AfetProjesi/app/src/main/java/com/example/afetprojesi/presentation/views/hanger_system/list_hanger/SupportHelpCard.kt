package com.example.afetprojesi.presentation.views.hanger_system.list_hanger

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afetprojesi.util.lerp
import kotlin.math.absoluteValue




@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SupportHelpCard() {
    //ilanın resimleri apiden çekilip buraya eklenecek.
    val images = remember { mutableListOf<Int>(
        android.R.drawable.ic_delete,
        android.R.drawable.btn_star_big_on
    ) }
    val pagerState = rememberPagerState(pageCount = { images.size })

    //resmin altında bulunan renk çizgileri bu listede
    val renkler=remember{ mutableListOf(Color.Red, Color.Green, Color.Blue, Color.Yellow,Color.Cyan,Color.Black,Color.Gray,Color.Magenta) }

    OutlinedCard(
        modifier = Modifier
            .clip(RoundedCornerShape(2.dp))
            .size(330.dp),
        colors = CardDefaults.cardColors(
        containerColor = Color.White),
        border = BorderStroke((0.5).dp, Color.LightGray),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box {
            HorizontalPager(state = pagerState) { page ->
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = "Image for support help",
                    modifier = Modifier
                        .height(200.dp)
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
                Text(text = "Adana", modifier = Modifier.padding(horizontal = 8.dp), fontSize = 13.sp)
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
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            .background(renkler.random()))

        Text(text = "İhsan Başgan", modifier = Modifier.padding(10.dp), fontSize = 15.sp)
        Text(text = "DenemeYazı  DenemeYazı  DenemeY askfuasgyusvtg awfyaugfvag7gawgayh8hags ",
            maxLines = 3,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
            fontSize = 12.sp,
            color = Color.DarkGray,
            overflow = TextOverflow.Ellipsis,
            )

    }
}