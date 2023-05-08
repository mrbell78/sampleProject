package com.nur.serviceproviderinterviewcrud.api

import com.nur.serviceproviderinterviewcrud.UserCreate
import com.nur.serviceproviderinterviewcrud.model.Users
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface ApiInterface {
    @Headers("Content-Type:application/json")
    @GET("public/v2/users")
   suspend fun getUsers(): Response<List<Users>>

    @Headers(
        "Content-Type:application/json",
        "Authorization:Bearer 5f54c461fb7d6b345b3a770fa4586795ec1125bb80459ed9daba5f1c26cf26e0"
    )
    @POST("public/v2/users")
    @JvmSuppressWildcards
    suspend fun postRequest(@Body body: Map<String, Any>):Response<UserCreate>

    companion object {
        operator  fun invoke(): ApiInterface{

           /* val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(Interceptor { chain ->
                val request: Request =
                    chain.request().newBuilder().addHeader("Content-Type", "application/json").build()
                chain.proceed(request)
            })*/

            return Retrofit.Builder().baseUrl(ApiUtilites.BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build().create(ApiInterface::class.java)
        }
}
}