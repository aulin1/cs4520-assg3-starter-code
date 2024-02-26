package com.cs4520.assignment3

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CalculatorViewModelFactory(private val startingNum1: String, private val startingNum2: String, private val result : Float?)  : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalculatorViewModel::class.java)){
            return CalculatorViewModel(startingNum1, startingNum2, result) as T
        }
        throw IllegalArgumentException("Creating ViewModel failed")
    }
}