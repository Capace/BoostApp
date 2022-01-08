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
import com.vv.boostapp.ui.theme.*
import com.vv.boostapp.util.QuestionState
import io.netty.channel.group.ChannelMatchers.compose
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun SelectScreen(navController: NavController) {

    var questionState = MutableStateFlow(QuestionState())

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
        ),
        Path(
            title = "Oncology",
            color = OncoColor,
            mainDescription = "bla bla",
            secondDescription = "dadada",
            image = painterResource(id = R.drawable.ic_cancer),
            contentDescription = "Oncology",
            route = "oncology"
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
                onClick = { navController.navigate(NavRoutes.PlayScreen.createPath(path.route, path.color)) }
            )
        }
    }
}