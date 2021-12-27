package com.vv.boostapp.ui.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
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
fun ProfileScreen(
    color: Color = MaterialTheme.colors.primary
) {

    val listaOarecare = listOf<String>(
        "#Days Streak: ",
        "Paths Completed: ",
        "Best Score: ",
        "Friends: ",
        "Answered Questions: ",
        "Account power: ",
        "World rank: "
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Constants.largePadding)
    ) {

        Row(
            Modifier
                .fillMaxWidth(),
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
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Name", color = color)
                Text(text = "Surname", color = color)
                Text(text = "Level: 0", color = color)
            }
        }


        Spacer(modifier = Modifier.height(12.dp))
        Divider(color = color, thickness = 2.dp)
        Spacer(modifier = Modifier.height(12.dp))


        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (element in listaOarecare) {
                Text(text = element, color = MaterialTheme.colors.onBackground)
            }

        }
    }
}