package com.cs4520.assignment3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.NumberFormatException

class CalculatorViewModel(startingNum1 : String, startingNum2 : String, startingResult : Float?) : ViewModel() {
    private var num1 = MutableLiveData<String>()
    private var num2 = MutableLiveData<String>()
    private var result = MutableLiveData<Float?>()
    var status = MutableLiveData<Boolean?>()

    val readResult : LiveData<Float?> get() = result
    init {
        num1.value = startingNum1
        num2.value = startingNum2
        result.value = startingResult
    }

    fun changeNum1(newValue: String){
        num1.value = newValue
    }

    fun changeNum2(newValue: String){
        num2.value = newValue
    }

    fun getResult() : String {
        return result.value.toString()
    }
    fun add(){
        try {
            val n1 = num1.value?.toFloatOrNull()
            val n2 = num2.value?.toFloatOrNull()
            if(n1 == null || n2 == null){
                throw NumberFormatException()
            }
            result.value = n1 + n2
        } catch (e : NumberFormatException){
            status.value = true
        }
    }

    fun subtract(){
        try {
            val n1 = num1.value?.toFloatOrNull()
            val n2 = num2.value?.toFloatOrNull()
            if(n1 == null || n2 == null){
                throw NumberFormatException()
            }
            result.value = n1 - n2
        } catch (e : NumberFormatException){
            status.value = true
        }
    }

    fun multiply(){
        try {
            val n1 = num1.value?.toFloatOrNull()
            val n2 = num2.value?.toFloatOrNull()
            if(n1 == null || n2 == null){
                throw NumberFormatException()
            }
            result.value = n1 * n2
        } catch (e : NumberFormatException){
            status.value = true
        }
    }

    fun divide(){
        try {
            val n1 = num1.value?.toFloatOrNull()
            val n2 = num2.value?.toFloatOrNull()
            if(n1 == null || n2 == null){
                throw NumberFormatException()
            }
            result.value = n1 / n2
        } catch (e : NumberFormatException){
            status.value = true
        }
    }

}