package com.daveanthonythomas.githubclient.login

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import javax.inject.Named

/**
 * Created by dave on 2017-12-21.
 */
@Module(includes = [LoginModule.Bindings::class])
class LoginModule {

    @Provides
    fun loginApi(@Named("GitHub") retrofit: Retrofit) = retrofit.create(LoginApi::class.java)

    @Module
    abstract class Bindings {
        @Binds
        abstract fun view(view: LoginActivity): LoginContract.View

        @Binds
        abstract fun presenter(presenter: LoginPresenter): LoginContract.Presenter

        @Binds
        abstract fun logic(loginLogic: LoginLogic): LoginContract.Logic

        @ContributesAndroidInjector
        abstract fun contributeLoginActivity(): LoginActivity
    }
}