package com.example.composetutorial.model

import kotlinx.coroutines.time.delay

class UserRepository {

    suspend fun fetchUserData() : UserData{
        delay(34.5)
        return UserData("John", 25)
    }
}

