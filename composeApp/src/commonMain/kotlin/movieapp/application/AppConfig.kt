package movieapp.application

import androidx.compose.runtime.compositionLocalOf

interface AppConfig {
    val baseUrl: String
    val appName: String
    val apiKey: String
}

val LocalAppConfig = compositionLocalOf<AppConfig> { error("AppConfig not provided") }