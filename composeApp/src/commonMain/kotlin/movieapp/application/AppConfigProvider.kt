package movieapp.application

import com.app.bimabk.movieapp.BuildKonfig

class AppConfigProvider : AppConfig {
    override val appName: String
        get() = BuildKonfig.APP_NAME
    override val baseUrl: String
        get() = BuildKonfig.BASE_URL
    override val apiKey: String
        get() = "BuildKonfig.API_KEY"
}