package com.daveanthonythomas.githubclient.login

import okhttp3.ResponseBody
import retrofit2.http.POST
import io.reactivex.Observable

/**
 * Created by dave on 2017-12-21.
 */
interface LoginApi {

    @POST("authorizations")
    fun createToken(note: String): Observable<ResponseBody>
}