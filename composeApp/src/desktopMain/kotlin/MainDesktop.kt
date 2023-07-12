import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import dev.joseluisgs.filmapp.App
import dev.joseluisgs.filmapp.Res
import dev.joseluisgs.filmapp.utils.getPlatformName
import io.github.skeptick.libres.compose.painterResource

fun main() = application {
    Window(
        title = "FilmApp ${getPlatformName()}",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        icon = painterResource(Res.image.app_icon),
        onCloseRequest = ::exitApplication,
    ) { App() }
}