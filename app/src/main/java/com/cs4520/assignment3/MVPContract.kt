package com.cs4520.assignment3

interface MVPContract {

    //According to TA at office hours, I don't need model for MVP
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