package com.nur.serviceproviderinterviewcrud.repository

import com.nur.serviceproviderinterviewcrud.api.ApiInterface
import com.nur.serviceproviderinterviewcrud.api.SafeApiRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val apiInterface: ApiInterface):SafeApiRequest() {
//    private val userLIveData = MutableLiveData<Users>();
//    val users : LiveData<Users>
//    get() = userLIveData
//
//    suspend fun getUsers(){
//        val result  =  apiInterface.getUsers()
//        if(result.body()!=null){
//            userLIveData.postValue(result.body())
//        }
//    }


    suspend fun getUsers() = apiRequest { apiInterface.getUsers() }

    suspend fun createUser(body:Map<String,Any>) = apiRequest { apiInterface.postRequest(body) }

}