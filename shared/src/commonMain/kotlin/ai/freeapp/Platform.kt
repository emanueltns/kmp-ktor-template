package ai.freeapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform