package com.twkim.samplekmp

interface Platform {
    val name: String
}

expect fun getPlatform(): com.twkim.samplekmp.Platform