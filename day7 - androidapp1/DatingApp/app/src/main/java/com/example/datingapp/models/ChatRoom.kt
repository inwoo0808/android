package com.example.datingapp.models

data class ChatRoom(
    val lastMessage: String = "",
    val lastMessageTimestamp: Long = 0L,
    val participants: List<String> = emptyList()
)
