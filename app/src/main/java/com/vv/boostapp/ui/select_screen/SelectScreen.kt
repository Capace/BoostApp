package com.vv.boostapp.ui.select_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.vv.boostapp.R
import com.vv.boostapp.ui.navigation.NavRoutes
import com.vv.boostapp.ui.select_screen.components.Path
import com.vv.boostapp.ui.select_screen.components.StandardPath
import com.vv.boostapp.ui.theme.CardioColor
import com.vv.boostapp.ui.theme.NephroColor
import com.vv.boostapp.ui.theme.NeuroColor
import com.vv.boostapp.ui.theme.OrangeVariant

@Composable
fun SelectScreen(navController: NavController) {

    val paths: List<Path> = listOf(
        Path(
            title = "Basic",
            color = OrangeVariant,
            mainDescription = "bla bla",
            secondDescription = "dadada",
            image = painterResource(id = R.drawable.ic_basic),
            contentDescription = "Cardiology",
            route = "basic"
        ),
        Path(
            title = "Cardiology",
            color = CardioColor,
            mainDescription = "bla bla",
            secondDescription = "dadada",
            image = painterResource(id = R.drawable.ic_stethoscope),
            contentDescription = "Cardiology",
            route = "cardiology"
        ),
        Path(
            title = "Neurology",
            color = NeuroColor,
            mainDescription = "bla bla",
            secondDescription = "dadada",
            image = painterResource(id = R.drawable.ic_brain),
            contentDescription = "Nephrology",
            route = "neurology"
        ),
        Path(
            title = "Nephrology",
            color = NephroColor,
            mainDescription = "bla bla",
            secondDescription = "dadada",
            image = painterResource(id = R.drawable.ic_kidney),
            contentDescription = "Nephrology",
            route = "nephrology"
        )
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        items(paths) { path ->
            StandardPath(
                navController,
                title = path.title,
                titleColor = path.color,
                mainDescription = path.mainDescription,
                secondDescription = path.secondDescription,
                image = path.image,
                contentDescription = path.contentDescription,
                onClick = { navController.navigate(NavRoutes.PlayScreen.createPath(path.route)) }
            )
        }
    }
}