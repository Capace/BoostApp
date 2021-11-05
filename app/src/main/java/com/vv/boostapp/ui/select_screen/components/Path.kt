package com.vv.boostapp.ui.select_screen.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class Path(
    val title: String,
    val color: Color,
    val mainDescription: String,
    val secondDescription: String,
    val image : Painter,
    val contentDescription : String,
    val route : String
)
