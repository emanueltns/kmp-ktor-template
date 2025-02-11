package ai.freeapp.core.data

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual fun getEngine(): HttpClientEngine {
    return OkHttp.create()
}