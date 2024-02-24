package com.cs4520.assignment3

import java.lang.NumberFormatException

class Presenter (private var View: MVPContract.View?) : MVPContract.Presenter{
    override fun OnAddClick(num1: String, num2: String) {
        try {
            val n1 = num1.toInt()
            val n2 = num2.toInt()
            View?.ShowResult((n1 + n2).toFloat())
        } catch (e : NumberFormatException){
            View?.ShowToast()
        }
    }

    override fun OnSubtractClick(num1: String, num2: String) {
        try {
            val n1 = num1.toInt()
            val n2 = num2.toInt()
            View?.ShowResult((n1 - n2).toFloat())
        } catch (e : NumberFormatException){
            View?.ShowToast()
        }
    }

    override fun OnMultiplyClick(num1: String, num2: String) {

        try {
            val n1 = num1.toInt()
            val n2 = num2.toInt()
            View?.ShowResult((n1 * n2).toFloat())
        } catch (e : NumberFormatException){
            View?.ShowToast()
        }
    }

    override fun OnDivideClick(num1: String, num2: String) {
        try {
            val n1 = num1.toFloat()
            val n2 = num2.toFloat()
            View?.ShowResult(n1 / n2)
        } catch (e : NumberFormatException){
            View?.ShowToast()
        }
    }
}