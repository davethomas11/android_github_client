package com.daveanthonythomas.githubclient.application.model

import android.content.SharedPreferences
import com.daveanthonythomas.githubclient.mvp.ObservableProvider
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.internal.operators.observable.ObservablePublish
import io.reactivex.subjects.PublishSubject
import org.reactivestreams.Publisher

/**
 * Created by dave on 2017-12-21.
 */
class User(val sharedPreferences: SharedPreferences) : UserState, UserTokenProvider {

    val subject = PublishSubject.create<UserState>()
    val userToken = "USER_TOKEN"
    override val loggedIn = sharedPreferences.contains(userToken)
    override val token = sharedPreferences.getString(userToken, "")

    override fun get(): Observable<UserState> = subject

    fun setToken(token: String) {
        sharedPreferences.edit().putString(userToken, token).apply()
        subject.onNext(this)
    }

    fun removeToken() {
        sharedPreferences.edit().remove(token)
        subject.onNext(this)
    }
}

interface UserState : ObservableProvider<UserState> {
    val loggedIn: Boolean
}

interface UserTokenProvider {
    val token: String
}