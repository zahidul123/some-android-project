package com.example.composecleanarchitecture.ui.features.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composecleanarchitecture.R
import com.example.composecleanarchitecture.models.dashboard.previous_year.PreviousYearQuestion
import com.example.composecleanarchitecture.ui.common_components.CardWithImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CaouselPager(onItemClicked: (String) -> Unit) {
    // Display 10 items
    val pagerState = rememberPagerState(pageCount = {
        10
    })
    Column(Modifier.padding(start = 20.dp)) {
        HorizontalPager(
            state = pagerState, pageSize = PageSize.Fixed(135.dp)
        ) { page ->
            Box(modifier = Modifier.clickable {
                onItemClicked.invoke("BCS")
            }) {
                CardWithImage(
                    previousYearQuestion = PreviousYearQuestion(
                        false,
                        "New",
                        "বিসিএস",
                        R.drawable.ic_trace_disable
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(11.dp))
        DotsIndicator(totalDots = 10, pagerState = pagerState)
    }

}