package com.daveanthonythomas.githubclient.login

/**
 * Created by dave on 2017-12-21.
 */
sealed class LoginViewState {
    class LoggingIn : LoginViewState()
    class LoggedIn : LoginViewState()
    class LoginFailure(message: String) : LoginViewState()
}