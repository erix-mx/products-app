package mx.webfamous.erix.randomapp.core.utils

import android.util.Log

fun loge(message: () -> String) {
    Log.e("Log", message())
}