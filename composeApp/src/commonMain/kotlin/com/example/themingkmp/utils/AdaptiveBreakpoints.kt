package com.example.themingkmp.utils

const val TABLET_DESKTOP_MAX_WIDTH = 540

enum class AdaptiveBreakpoints(val width: Int, val height: Int) {
    MEDIUM(600, 480),
    EXPANDED(840, 900)
}