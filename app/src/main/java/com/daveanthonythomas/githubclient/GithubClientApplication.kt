package com.daveanthonythomas.githubclient

import com.daveanthonythomas.githubclient.login.LoginActivity
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule

class GithubClientApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO()
    }

    @dagger.Component(modules = [
        AndroidSupportInjectionModule::class,
        LoginActivity.Module::class
    ])
    interface Component : AndroidInjector<GithubClientApplication> {
        @dagger.Component.Builder
        abstract class Builder : AndroidInjector.Builder<GithubClientApplication>()
    }
}