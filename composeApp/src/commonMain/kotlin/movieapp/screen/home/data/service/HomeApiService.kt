package movieapp.screen.home.data.service

import movieapp.application.AppConfig
import movieapp.core.network.NetworkDataSources
import io.ktor.client.statement.HttpResponse

class HomeApiService(
    private val appConfig: AppConfig
) : NetworkDataSources(appConfig.baseUrl) {
    suspend fun getListMovie(): HttpResponse {
        val endPoint = "movie/now_playing?api_key=${appConfig.apiKey}"
        return getHttpResponse(endPoint)
    }
}