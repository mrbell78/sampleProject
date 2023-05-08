package com.nur.serviceproviderinterviewcrud.api

import com.nur.serviceproviderinterviewcrud.api.ApiUtilites.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilites {
    val BASE_URL = "https://gorest.co.in/"
    }

//    fun getInstance(): Retrofit{
//        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
//    }
