package dev.joseluisgs.filmapp.screens.favoritos

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.lighthousegames.logging.logging


private val logger = logging()

@Composable
fun FavoritosView() {

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Favoritos",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp)
        )

    }
}