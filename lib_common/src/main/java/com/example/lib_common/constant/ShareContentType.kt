package com.example.lib_common.constant

import androidx.annotation.StringDef
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * 分享类型
 */
object ShareContentType {
    /**
     * Share Text
     */
    val TEXT = "text/plain"

    /**
     * Share Image
     */
    val IMAGE = "image/*"

    /**
     * Share Audio
     */
    val AUDIO = "audio/*"

    /**
     * Share Video
     */
    val VIDEO = "video/*"

    /**
     * Share File
     */
    val FILE = "*/*"
}