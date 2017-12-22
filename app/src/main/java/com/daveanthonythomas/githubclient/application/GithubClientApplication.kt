package com.daveanthonythomas.githubclient.application

import dagger.android.DaggerApplication

class GithubClientApplication : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder().build()
}

