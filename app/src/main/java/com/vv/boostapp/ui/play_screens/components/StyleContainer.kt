package com.vv.boostapp.ui.play_screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.vv.boostapp.util.Constants

@Composable
fun StyleContainer(
    onClick: () -> Unit,
    styleName: String,
    styleColor: androidx.compose.ui.graphics.Color
) {

    androidx.compose.material.Surface(
        color = MaterialTheme.colors.background,
        elevation = Constants.smallElevation,
        modifier = Modifier
            .padding(Constants.mediumPadding)
            .clickable { onClick() }
            .clip(RoundedCornerShape(12.dp))
    ) {

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = styleName, color = styleColor, style = MaterialTheme.typography.h4)
        }

    }

}