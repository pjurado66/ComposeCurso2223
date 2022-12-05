package com.pjurado.composecurso2223.ui.screens.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pjurado.composecurso2223.model.getMedia
import com.pjurado.composecurso2223.ui.screens.common.Imagen

@Composable
fun DetailScreen(id: Int) {
    val item = getMedia().first{ it.id == id}

    Scaffold(topBar = {
        TopAppBar {
            Text(text = item.title)
        }
    }) { padding ->
        Imagen(item = item, Modifier.padding(padding))
    }
}