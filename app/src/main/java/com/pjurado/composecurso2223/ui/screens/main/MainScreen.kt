package com.pjurado.composecurso2223.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.pjurado.composecurso2223.ui.MediaList

@Composable
fun MainScreen(navControler: NavHostController) {
    Scaffold(
        topBar = { MainAppBar() }
    ) { padding ->
        MediaList(navControler, modifier = Modifier.padding(padding))
    }
}