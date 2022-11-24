package com.zatec.got_houses

import android.app.Application
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

class HiltTestRunner : AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader?, name: String?,
        context: android.content.Context?
    ): Application {
        return super.newApplication(
            cl,
            HiltTestApplication::class.java.name, context
        )
    }
}