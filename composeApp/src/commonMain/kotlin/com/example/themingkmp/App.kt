package com.example.themingkmp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.themingkmp.login.LoginScreen
import com.example.themingkmp.theme.NoteAppTheme

@Composable
@Preview
fun App() {
    NoteAppTheme(darkTheme = isSystemInDarkTheme()) {
        LoginScreen()
    }
}