package ai.freeapp.api

import ai.freeapp.core.config.NetworkConfig
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

class ApiClient(private val httpClient: HttpClient = HttpClient {
    install(ContentNegotiation) {
        json()
    }
}) {
    suspend fun getGreeting(): String {
        return httpClient.get(NetworkConfig.BASE_URL).body()
    }

    companion object {
        val instance by lazy { ApiClient() }
    }
}
