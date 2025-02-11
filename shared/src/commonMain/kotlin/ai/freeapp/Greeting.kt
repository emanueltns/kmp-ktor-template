package ai.freeapp

import ai.freeapp.api.ApiClient

class Greeting {
    private val platform = getPlatform()
    private val apiClient = ApiClient.instance

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    suspend fun greetFromServer(): String {
        return try {
            apiClient.getGreeting()
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
}