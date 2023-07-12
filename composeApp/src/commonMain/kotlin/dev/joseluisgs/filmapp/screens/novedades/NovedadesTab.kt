package dev.joseluisgs.filmapp.screens.novedades

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import compose.icons.FeatherIcons
import compose.icons.feathericons.Film
import dev.joseluisgs.filmapp.Res
import dev.joseluisgs.filmapp.screens.detail.DetailView
import org.lighthousegames.logging.logging

private val logger = logging()

object NovedadesTab : Tab {

    init {
        logger.debug { "Inicializando NovedadesTab" }
    }

    override val options: TabOptions
        @Composable
        get() {
            val title = Res.string.tab_novedades
            val icon = rememberVectorPainter(FeatherIcons.Film)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        var screen by remember { mutableStateOf(Screen.NOVEDADES) }
        if (screen == Screen.NOVEDADES) {
            NovedadesView(onItemClick = {
                logger.debug { "Click en Detalle" }
                screen = Screen.DETALLE
            })
        } else {
            DetailView {
                logger.debug { "Click en Cerrar" }
                screen = Screen.NOVEDADES
            }
        }
    }


    enum class Screen {
        NOVEDADES, DETALLE
    }


}