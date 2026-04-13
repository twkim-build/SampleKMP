package com.twkim.samplekmp

import android.os.Build

class AndroidPlatform : com.twkim.samplekmp.Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): com.twkim.samplekmp.Platform =
    _root_ide_package_.com.twkim.samplekmp.AndroidPlatform()