package com.daveanthonythomas.githubclient.application

import com.daveanthonythomas.githubclient.login.LoginModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by dave on 2017-12-21.
 */
@Component(modules = [
AndroidSupportInjectionModule::class,
AppModule::class,
LoginModule::class
])
interface AppComponent : AndroidInjector<GithubClientApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<GithubClientApplication>() {
        abstract fun appModule(module: AppModule): Builder
    }
}