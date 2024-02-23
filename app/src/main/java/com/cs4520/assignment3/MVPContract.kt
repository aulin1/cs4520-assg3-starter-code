package com.cs4520.assignment3

interface MVPContract {
    interface View {

    }

    interface Model {
        interface OnFinishedListener {
            fun onFinished(string: String?)
        }

    }

    interface Presenter {

    }
}