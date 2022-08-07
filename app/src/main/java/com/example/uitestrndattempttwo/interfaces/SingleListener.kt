package com.example.uitestrndattempttwo.interfaces

import com.example.uitestrndattempttwo.models.AdminCommand

interface SingleListener {
    suspend fun onMessageReceived(adminCommand: AdminCommand)
    suspend fun onDataChange(adminCommand: AdminCommand)
    suspend fun manualEvent(adminCommand: AdminCommand)
}