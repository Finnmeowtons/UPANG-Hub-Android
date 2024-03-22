package com.soriano.christianjose.block6.p1.upanghub.auth.api

import com.soriano.christianjose.block6.p1.upanghub.auth.dataclass.ApiAuthResponse
import com.soriano.christianjose.block6.p1.upanghub.auth.dataclass.ForgotPasswordRequest
import com.soriano.christianjose.block6.p1.upanghub.auth.dataclass.RegistrationRequest
import com.soriano.christianjose.block6.p1.upanghub.auth.dataclass.SignInRequest
import com.soriano.christianjose.block6.p1.upanghub.auth.dataclass.SignInResponse
import com.soriano.christianjose.block6.p1.upanghub.dataclass.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiAuth {
    @POST("api/users/login")
    fun signIn(@Body request: SignInRequest): Call<SignInResponse>

    @POST("api/users/reset")
    fun sendPasswordResetLink(@Body request: ForgotPasswordRequest): Call<ApiAuthResponse>

    @POST("api/users")
    fun registerUser(@Body request: RegistrationRequest): Call<User>
}