package com.example.moveinsync.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountDownViewModel : ViewModel() {
    private var _countValue = MutableLiveData<Int>(0)
    val countValue: LiveData<Int>
        get() = _countValue
    private lateinit var job: Job


    fun starTimer() {
        job = viewModelScope.launch {
            while (true) {
                delay(1000)
                _countValue.value = _countValue.value?.plus(1)
            }
        }

        job.start()
    }

    fun stopTimer() {
        job.cancel()
    }

}