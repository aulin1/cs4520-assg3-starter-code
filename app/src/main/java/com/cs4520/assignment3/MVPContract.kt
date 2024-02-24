package com.cs4520.assignment3

interface MVPContract {
    interface View {
        fun ShowToast();
        fun ShowResult(result: Float);
    }

    interface Presenter {

        fun OnAddClick(num1: String, num2: String);
        fun OnSubtractClick(num1: String, num2: String);
        fun OnMultiplyClick(num1: String, num2: String);
        fun OnDivideClick(num1: String, num2: String);
    }
}