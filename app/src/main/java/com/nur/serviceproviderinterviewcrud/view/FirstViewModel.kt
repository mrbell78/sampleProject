package com.nur.serviceproviderinterviewcrud.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nur.serviceproviderinterviewcrud.model.Users
import com.nur.serviceproviderinterviewcrud.repository.UserRepository

class FirstViewModel (private val repository: UserRepository): ViewModel() {
    private  val _users = MutableLiveData<List<Users>>()

    val users : LiveData<List<Users>>

    get() = _users

    suspend fun getUsers(){
        val users = repository.getUsers()
        _users.value = users

    }
 }