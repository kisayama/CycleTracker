package com.example.cycletracker.model

//Firebaseで使用するUser型
data class FirebaseUser(
    val userId:String,
    val userName: String?,
    val submitCycleLength:Int
)
