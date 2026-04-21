package com.twkim.samplekmp.core.logging

class DefaultAppLogger (
    private val enabled: Boolean
) : AppLogger {
    override fun d(tag: String, message: String) {
        if (enabled) println("DEBUG [$tag] $message")
    }

    override fun i(tag: String, message: String) {
        if (enabled) println("INFO [$tag] $message")
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        if (enabled) {
            println("ERROR [$tag] $message")
            throwable?.printStackTrace()
        }
    }
}