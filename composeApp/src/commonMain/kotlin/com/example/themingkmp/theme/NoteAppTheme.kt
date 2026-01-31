package com.example.themingkmp.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val LightColorTheme = lightColorScheme(
    primary = Primary,
    surface = Surface,
    surfaceContainerLowest = SurfaceLowest,
    background = Background,
    onSurface = OnSurface,
    onSurfaceVariant = OnSurfaceVariant
)

val DarkColorTheme = darkColorScheme(
    primary = PrimaryDark,
    surface = SurfaceDark,
    surfaceContainerLowest = SurfaceLowestDark,
    background = BackgroundDark,
    onSurface = OnSurfaceDark,
    onSurfaceVariant = OnSurfaceVariantDark
)

@Composable
fun NoteAppTheme(
    content: @Composable () -> Unit
){
    val colorScheme = if(isSystemInDarkTheme()) DarkColorTheme else LightColorTheme
    MaterialTheme(
        colorScheme = colorScheme
    ){
        content()
    }
}