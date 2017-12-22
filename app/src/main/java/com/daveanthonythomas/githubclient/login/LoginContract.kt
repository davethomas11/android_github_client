package com.daveanthonythomas.githubclient.login

import com.daveanthonythomas.githubclient.mvp.ObservableProvider
import dagger.Binds
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Named

/**
 * Created by dave on 2017-12-21.
 */
interface LoginContract {

    interface View {
        fun render(viewState: LoginViewState)
    }

    interface Presenter {
        fun login(username: String, password: String)
        fun destroy()
    }

    interface Logic: ObservableProvider<Logic.LoginError> {
        fun login(username: String, password: String)

        data class LoginError(val message: String)
    }
}