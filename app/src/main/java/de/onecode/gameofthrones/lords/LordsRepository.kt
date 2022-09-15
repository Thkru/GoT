package de.onecode.gameofthrones.lords

import de.onecode.gameofthrones.http.ApiService
import de.onecode.gameofthrones.model.LordModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LordsRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getLord(id: String): LordModel? {
        val lord = apiService.getLord(id)
        return lord
    }

}
