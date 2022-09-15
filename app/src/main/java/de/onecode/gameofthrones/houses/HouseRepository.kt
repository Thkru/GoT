package de.onecode.gameofthrones.houses

import de.onecode.gameofthrones.http.ApiService
import de.onecode.gameofthrones.model.HouseModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class HouseRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getHouses(): List<HouseModel> {
        val houses = apiService.getHouses(1, 30)
        return houses
    }

    suspend fun getHouse(id: String): HouseModel? {
        val house = apiService.getHouse(id)
        return house
    }

}
