package com.twkim.samplekmp

class Greeting {
    private val platform = _root_ide_package_.com.twkim.samplekmp.getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}