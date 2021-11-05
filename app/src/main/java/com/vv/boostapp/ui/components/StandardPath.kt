package com.vv.boostapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vv.boostapp.util.Constants

@Composable
fun StandardPath(
    navController: NavController,
    title: String,
    titleColor: Color,
    mainDescription: String,
    secondDescription: String,
    image: Painter,
    contentDescription: String,
    onClick: () -> Unit,
    iconSize: Dp = 100.dp

) {
    androidx.compose.material.Surface(
        color = MaterialTheme.colors.background,
        elevation = Constants.smallElevation,
        modifier = Modifier
            .padding(Constants.mediumPadding)
            .clickable { onClick() }
            .clip(RoundedCornerShape(12.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h4,
                    color = titleColor
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = mainDescription,
                style = TextStyle(
                    color = MaterialTheme.colors.onBackground,
                    fontStyle = FontStyle.Italic
                ),
                modifier = androidx.compose.ui.Modifier.padding(Constants.smallPadding)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.fillMaxWidth(0.7f)) {
                    Text(
                        text = secondDescription,
                        style = MaterialTheme.typography.body1,
                        modifier = androidx.compose.ui.Modifier.padding(Constants.smallPadding)
                    )
                }
                Column(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = image,
                        contentDescription = contentDescription,
                        modifier = Modifier.size(iconSize)
                    )
                }

            }
        }
    }

}