package com.example.themingkmp.utils

import androidx.window.core.layout.WindowSizeClass

enum class DeviceConfiguration {
    MOBILE_PORTRAIT,
    MOBILE_LANDSCAPE,
    TABLET_PORTRAIT,
    TABLET_LANDSCAPE,
    DESKTOP;

    companion object {
        fun WindowSizeClass.toDeviceConfiguration(): DeviceConfiguration = when {
            isAtLeastBreakpoint(
                AdaptiveBreakpoints.EXPANDED.width,
                AdaptiveBreakpoints.EXPANDED.height
            ) -> DESKTOP

            isAtLeastBreakpoint(
                AdaptiveBreakpoints.MEDIUM.width,
                AdaptiveBreakpoints.EXPANDED.height
            ) -> TABLET_PORTRAIT

            isAtLeastBreakpoint(
                AdaptiveBreakpoints.EXPANDED.width,
                AdaptiveBreakpoints.MEDIUM.height
            ) -> TABLET_LANDSCAPE

            isWidthAtLeastBreakpoint(AdaptiveBreakpoints.EXPANDED.width) -> MOBILE_LANDSCAPE
            else -> MOBILE_PORTRAIT
        }
    }
}