package com.daveanthonythomas.githubclient.mvp

import io.reactivex.Observable


/**
 * Created by dave on 2017-12-22.
 */
interface ObservableProvider<T> {
    fun get(): Observable<T>
}