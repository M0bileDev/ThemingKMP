package com.example.themingkmp.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import themingkmp.composeapp.generated.resources.Res
import themingkmp.composeapp.generated.resources.inter_medium
import themingkmp.composeapp.generated.resources.inter_regular
import themingkmp.composeapp.generated.resources.space_grotesk_bold

val SpaceGrotesk
    @Composable get() = FontFamily(
        Font(
            resource = Res.font.space_grotesk_bold,
            weight = FontWeight.Bold
        )
    )

val Inter
    @Composable get() = FontFamily(
        Font(
            resource = Res.font.inter_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resource = Res.font.inter_medium,
            weight = FontWeight.Medium
        ),
    )