package com.pjurado.composecurso2223.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import com.pjurado.composecurso2223.R
import com.pjurado.composecurso2223.model.MediaItem
import com.pjurado.composecurso2223.model.getMedia
import com.pjurado.composecurso2223.ui.screens.common.Imagen

@Composable
fun MediaList(navControler: NavHostController, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_xsmall)),
        columns = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_width)),
        modifier = modifier
    ) {
        items(getMedia()){ item->
            MediaListItem(item, navControler, Modifier.padding(dimensionResource(id = R.dimen.padding_xsmall)))
        }
    }
}

@Composable
fun MediaListItem(item: MediaItem, navControler: NavHostController, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .clickable { navControler.navigate("detail/${item.id}") }
    ) {
        Imagen(item)
        Title(item)
    }
}

@Composable
private fun Title(item: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Text(
            text = item.title,
            style = MaterialTheme.typography.h4
        )
    }
}

