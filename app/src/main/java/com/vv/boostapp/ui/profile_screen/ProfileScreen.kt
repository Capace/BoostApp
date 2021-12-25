package com.vv.boostapp.ui.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vv.boostapp.R
import com.vv.boostapp.util.Constants

@Composable
fun ProfileScreen() {

    val listaOarecare = listOf<String>(
        "random",
        "random",
        "random",
        "random",
        "random",
        "random",
        "random",
        "random",
        "random",
        "random",
        "random",
        "random"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Constants.largePadding)
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .background(Color.Red),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile_pic),
                contentDescription = "profile picture",
                Modifier.size(130.dp)
            )

            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.Blue),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Name")
                Text(text = "Surname")
                Text(text = "Level: 0")
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (element in listaOarecare) {
                Text(text = element)
            }

        }
    }
}