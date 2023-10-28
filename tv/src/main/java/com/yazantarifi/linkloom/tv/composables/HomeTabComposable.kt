package com.yazantarifi.linkloom.tv.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.TvLazyRow
import com.yazantarifi.linkloom.tv.models.HomeSection
import com.yazantarifi.linkloom.tv.content.HomeScreenSectionsBuilder
import androidx.tv.foundation.lazy.list.items
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.yazantarifi.linkloom.tv.LinkLoomApplication
import com.yazantarifi.linkloom.tv.R
import com.yazantarifi.linkloom.tv.models.HomeSectionItem
import com.yazantarifi.linkloom.tv.screens.WebsiteScreen
import com.yazantarifi.linkloom.tv.utils.RedPrimary
import com.yazantarifi.linkloom.tv.utils.White

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeTabComposable() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .padding(end = 20.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = context.getString(R.string.link_loom_title),
            fontSize = TextUnit(18f, TextUnitType.Sp),
            color = RedPrimary
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = context.getString(R.string.link_loom_message),
            fontSize = TextUnit(18f, TextUnitType.Sp),
            color = White
        )

        Spacer(modifier = Modifier.height(20.dp))

        TvLazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            items(HomeScreenSectionsBuilder.getSections(context)) { section ->
                Section(section) {
                    LinkLoomApplication.onSendEvent("HomeScreenSectionItem_${section.title}", context)
                    WebsiteScreen.startScreen(context, it.url, it.name)
                }
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun Section(
    section: HomeSection,
    modifier: Modifier = Modifier,
    onItemSelected: (HomeSectionItem) -> Unit = {},
) {
    Text(
        text = section.title,
        style = MaterialTheme.typography.headlineSmall,
        color = White,
        modifier = Modifier.padding(10.dp)
    )

    TvLazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(section.items) { item ->
            Box(modifier = Modifier.padding(10.dp)) {
                WebsiteCard(
                    item = item,
                    onClick = { onItemSelected(item) }
                )
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun WebsiteCard(
    item: HomeSectionItem,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(modifier = modifier, onClick = onClick){
       Box(modifier = Modifier
           .width(210.dp)
           .height(150.dp)) {
           GlideImage(
               model = item.banner,
               contentDescription = item.name,
               modifier = Modifier
                   .size(210.dp, 140.dp),
               contentScale = ContentScale.Crop,
           )

           Column(
               modifier = Modifier
                   .fillMaxSize()
                   .height(150.dp)
                   .background(
                       brush = Brush.verticalGradient(
                           colors = listOf(
                               Color.Transparent,
                               Color.Black
                           )
                       )
                   )
                   .padding(10.dp),
               verticalArrangement = Arrangement.Bottom
           ) {
               Text(
                   text = item.name,
                   fontSize = TextUnit(14f, TextUnitType.Sp),
                   color = White
               )
               Spacer(modifier = Modifier.height(5.dp))
               Text(
                   text = item.url,
                   fontSize = TextUnit(12f, TextUnitType.Sp),
                   color = White
               )
           }
       }
    }
}