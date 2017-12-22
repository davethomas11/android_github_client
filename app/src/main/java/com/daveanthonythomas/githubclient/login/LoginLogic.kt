package com.daveanthonythomas.githubclient.login

import com.daveanthonythomas.githubclient.application.model.User
import javax.inject.Inject
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by dave on 2017-12-21.
 */
class LoginLogic @Inject constructor(val loginApi: LoginApi,
                                     val user: User) : LoginContract.Logic {

    val errors = PublishSubject.create<LoginContract.Logic.LoginError>()

    override fun get(): Observable<LoginContract.Logic.LoginError> = errors

    override fun login(username: String, password: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
