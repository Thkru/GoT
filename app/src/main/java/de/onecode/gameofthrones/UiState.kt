package de.onecode.gameofthrones

class UiState<T>(
    val data: T? = null,
    val loading: Boolean = false,
    val exception: Exception? = null
)
