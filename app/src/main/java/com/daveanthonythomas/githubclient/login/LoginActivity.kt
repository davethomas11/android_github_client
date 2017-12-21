package com.daveanthonythomas.githubclient.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.ContributesAndroidInjector

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @dagger.Module abstract class Module {

        @ContributesAndroidInjector
        abstract fun contributeLoginActivity(): LoginActivity
    }
}