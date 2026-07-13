package com.drgabo.galaandroid.core.util

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object SnackBarManager{
    private val _messages= Channel<String>()
    val messages=_messages.receiveAsFlow()
    suspend fun showMessage(message:String){
        _messages.send(message)
    }
}