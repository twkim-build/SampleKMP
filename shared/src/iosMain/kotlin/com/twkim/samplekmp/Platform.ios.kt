package com.twkim.samplekmp

import platform.UIKit.UIDevice

class IOSPlatform: com.twkim.samplekmp.Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): com.twkim.samplekmp.Platform =
    _root_ide_package_.build.twkim.samplekmp.IOSPlatform()