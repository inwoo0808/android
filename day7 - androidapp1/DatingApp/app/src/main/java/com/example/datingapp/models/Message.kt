package com.example.datingapp.models

data class Message(
    val senderId: String = "",
    val text: String = "",
    val timestamp: Long = 0L
)
