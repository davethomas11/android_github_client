package com.daveanthonythomas.githubclient.login

import com.daveanthonythomas.githubclient.application.model.UserState
import com.daveanthonythomas.githubclient.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by dave on 2017-12-21.
 */
class LoginPresenter @Inject constructor(val view: LoginContract.View,
                                         val logic: LoginContract.Logic,
                                         userState: UserState) :
        LoginContract.Presenter, BasePresenter() {

    init {
        observe(userState) {
            if (it.loggedIn) view.render(LoginViewState.LoggedIn())
        }

        observe(logic) {
            view.render(LoginViewState.LoginFailure(it.message))
        }
    }

    override fun login(username: String, password: String) {
        view.render(LoginViewState.LoggingIn())
        logic.login(username, password)
    }
}