package com.vv.boostapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.vv.boostapp.ui.theme.GrayOnBackground

@Composable
fun RowScope.StandardBottomNavItem(
    modifier : Modifier = Modifier,
    icon : ImageVector? = null,
    contentDescription : String? = null,
    selected: Boolean = true,
    enabled: Boolean = true,
    selectedColor : Color = MaterialTheme.colors.primary,
    unselectedColor: Color = GrayOnBackground,
    onclick: () -> Unit
) {

    BottomNavigationItem(
        selected = selected,
        onClick = onclick,
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedColor,
        unselectedContentColor = unselectedColor,
        icon = {
            Box(modifier = Modifier
                .fillMaxSize(0.5f))
            {
                if (icon != null){
                    Icon(
                        imageVector = icon,
                        contentDescription = contentDescription,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

            }
        }
    )
}