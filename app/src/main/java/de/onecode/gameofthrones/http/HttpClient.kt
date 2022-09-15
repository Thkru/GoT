package de.onecode.gameofthrones.http

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.onecode.gameofthrones.model.LordModel
import de.onecode.gameofthrones.model.HouseModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val BASE_URL = "https://www.anapioficeandfire.com/api/"

    @Provides
    @Singleton
    fun provideRetrofit(): ApiService = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(getMoshi()))
        .baseUrl(BASE_URL)
        .client(getHttpClient())
        .build()
        .create(ApiService::class.java)

    private fun getMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    private fun getHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(getLoggingInterceptor()).build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }
}

interface ApiService {
    @GET("houses")
    suspend fun getHouses(@Query("page") page: Int = 1, @Query("pageSize") pageSize: Int = 30): List<HouseModel>

    @GET("characters/{id}")
    suspend fun getLord(@Path("id") id: String): LordModel?

    @GET("houses/{id}")
    suspend fun getHouse(@Path("id") id: String): HouseModel?
}
