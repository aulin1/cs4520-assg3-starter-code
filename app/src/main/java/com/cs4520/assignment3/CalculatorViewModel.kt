package com.cs4520.assignment3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
class CalculatorViewModel(startingNum1 : String, startingNum2 : String) : ViewModel() {
    private var num1 = MutableLiveData<String>()
    private var num2 = MutableLiveData<String>()

    val readNum1 : LiveData<String> get() = num1
    val readNum2 : LiveData<String> get() = num2
    init {
        num1.value = startingNum1
        num2.value = startingNum2
    }

}