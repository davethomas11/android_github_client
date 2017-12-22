package com.daveanthonythomas.githubclient.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by dave on 2017-12-21.
 */
open class BasePresenter {

    val disposables = CompositeDisposable()

    fun <T> observe(observable: Observable<T>, action: (next: T) -> Unit) =
            disposables.add(observable.observeOn(AndroidSchedulers.mainThread()).subscribe(action))

    fun <T> observe(observable: ObservableProvider<T>, action: (next: T) -> Unit) =
            disposables.add(observable.get().observeOn(AndroidSchedulers.mainThread()).subscribe(action))

    fun destroy() {
        disposables.dispose()
    }
}