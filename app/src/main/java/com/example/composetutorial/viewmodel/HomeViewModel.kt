package com.example.composetutorial.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composetutorial.model.UserData
import com.example.composetutorial.model.UserRepository

class HomeViewModel: ViewModel() {

    val userRepository : UserRepository = UserRepository()
    private val _userData = MutableLiveData<UserData>()
    val userData : LiveData<UserData> = _userData

    fun getUserData() {
        val userResult = userRepository.fetchUserData()
        _userData.postValue()
    }
}