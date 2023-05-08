package com.nur.serviceproviderinterviewcrud.api

import android.widget.Toast
import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest {



    suspend fun <T:Any> apiRequest(call:suspend ()->Response<T>):T{
        val response = call.invoke()
        if(response.isSuccessful){
            return  response.body()!!
        }else {
            //@TODO HANDLE API EXCEPTION
            throw ApiException("possible problem is "+response.code().toString())
        }
    }
}

class ApiException (message:String): IOException(message)