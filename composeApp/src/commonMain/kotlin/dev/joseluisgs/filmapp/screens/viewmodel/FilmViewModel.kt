package dev.joseluisgs.filmapp.screens.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.github.michaelbull.result.mapBoth
import dev.joseluisgs.filmapp.model.Film
import dev.joseluisgs.filmapp.repository.FilmRepository
import kotlinx.coroutines.launch
import org.lighthousegames.logging.logging

private val logger = logging()

class FilmViewModel(
    private val repository: FilmRepository
) : ScreenModel {
    var state by mutableStateOf(State())
        private set

    init {
        logger.info { "Inicializando FilmViewModel" }
        state = state.copy(isLoading = true)
        coroutineScope.launch {
            loadRemoteFilms()
        }
    }

    suspend fun loadRemoteFilms() {
        logger.debug { "Cargando películas remotas" }
        repository.getRemoteFilms().mapBoth(
            success = {
                logger.debug { "Películas remotas cargadas" }
                state = state.copy(isLoading = false, remoteFilms = it)
            },
            failure = {
                logger.error { "Error al cargar las películas remotas" }
                state = state.copy(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message
                )
            }
        )
    }


    // El estado de la vista
    data class State(
        val isLoading: Boolean = false,
        val remoteFilms: List<Film> = emptyList(),
        val favoriteFilms: List<Film> = emptyList(),
        val isError: Boolean = false,
        val errorMessage: String = ""
    )
}