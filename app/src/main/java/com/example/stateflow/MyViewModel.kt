package com.example.stateflow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    val switch: MutableStateFlow<Boolean> = MutableStateFlow(true)

    val onOff: StateFlow<String> = switch.map {
        if (it){"ON"}else{"OFF"}
    }.stateIn(viewModelScope, SharingStarted.Eagerly,"...")

    val leftText: MutableStateFlow<String> = MutableStateFlow("")
    val rightText: MutableStateFlow<String> = MutableStateFlow("")

    val combineText: StateFlow<String> = channelFlow {
        launch {
            leftText.collect {
                send(it)
            }
        }
        launch {
            rightText.collect {
                send(it)
            }
        }
    }.map {
        "${leftText.value}${rightText.value}"
    }.stateIn(viewModelScope, SharingStarted.Eagerly, "")

    fun reset() {
        leftText.value = ""
        rightText.value = ""
    }
}