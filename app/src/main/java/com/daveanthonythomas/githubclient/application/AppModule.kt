package com.daveanthonythomas.githubclient.application

import android.content.Context
import android.content.SharedPreferences
import com.daveanthonythomas.githubclient.application.model.User
import com.daveanthonythomas.githubclient.application.model.UserState
import com.daveanthonythomas.githubclient.application.model.UserTokenProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

/**
 * Created by dave on 2017-12-21.
 */
@Module (includes = [AppModule.Bindings::class])
class AppModule(val user: User) {

    val sharedPreferencesName = "GitHubClientPrefs"

    @Provides
    fun sharedPreferences(context: Context) =
            context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)

    @Provides
    @Named("GitHub")
    fun githubRetrofit() = Retrofit.Builder().baseUrl("https://api.github.com").build()

    @Provides
    fun userState(): UserState = user

    @Provides
    fun userTokenProvider(): UserTokenProvider = user

    @Provides
    fun user() = user

    @Module
    abstract class Bindings {

        @Binds
        abstract fun context(app: GithubClientApplication): Context
    }
}

