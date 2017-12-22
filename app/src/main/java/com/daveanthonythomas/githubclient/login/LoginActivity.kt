package com.daveanthonythomas.githubclient.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
    }

    override fun render(viewState: LoginViewState) = when(viewState) {
        is LoginViewState.LoggingIn -> Unit
        is LoginViewState.LoggedIn -> Unit
        is LoginViewState.LoginFailure -> Unit
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}