package com.nur.serviceproviderinterviewcrud.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.nur.serviceproviderinterviewcrud.UserCreate
import com.nur.serviceproviderinterviewcrud.model.Users

import com.nur.serviceproviderinterviewcrud.repository.UserRepository
import com.nur.serviceproviderinterviewcrud.utils.Coroutines
import kotlinx.coroutines.Job

class UsersViewModel(private val userRepository: UserRepository):ViewModel() {

//    init {
//        viewModelScope.launch (Dispatchers.IO){
//            userRepository.getUsers()
//        }
//
//    }


    private  lateinit var job:Job
    private val _user = MutableLiveData<List<Users>>()

    val users: MutableLiveData<List<Users>>
    get() = _user


    val _userCrate =  MutableLiveData<UserCreate>()

    val userCrate: MutableLiveData<UserCreate>

    get() = _userCrate


     fun getUsers(){
         job = Coroutines.ioThenMain({userRepository.getUsers()},{_user.value = it})

    }

    fun  createUsers(body:Map<String,Any>){
        job = Coroutines.ioThenMain({userRepository.createUser(body)},{_userCrate.value = it})
    }
    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized)job.cancel()
    }


    fun getFilteredList(s: String): LiveData<List<Users>> {
        return Transformations.map(_user) {
            it.filter {
                it.status!!.contains(s)
            }
        }
    }

}