package com.example.themingkmp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themingkmp.design_system.NoteMarkButton
import com.example.themingkmp.design_system.NoteMarkLink
import com.example.themingkmp.design_system.NoteMarkTextField
import com.example.themingkmp.theme.NoteAppTheme
import com.example.themingkmp.utils.DeviceConfiguration
import com.example.themingkmp.utils.DeviceConfiguration.Companion.toDeviceConfiguration
import com.example.themingkmp.utils.TABLET_DESKTOP_MAX_WIDTH

@Composable
fun LoginScreen() {
    var emailText by rememberSaveable { mutableStateOf("") }
    var passwordText by rememberSaveable { mutableStateOf("") }

    //handle window insets
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.statusBars
    ) { innerPadding ->

        val rootModifier = Modifier.fillMaxSize()
            .padding(innerPadding)
            .clip(
                RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp
                )
            )
            .background(MaterialTheme.colorScheme.surfaceContainerLowest)
            .padding(
                horizontal = 16.dp,
                vertical = 24.dp
            )
            //prevent content from overlapping on the navigation bar
            .consumeWindowInsets(WindowInsets.navigationBars)

        val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
        val deviceConfiguration = windowSizeClass.toDeviceConfiguration()
        when (deviceConfiguration) {
            DeviceConfiguration.MOBILE_PORTRAIT -> {
                Column(
                    modifier = rootModifier,
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    LoginHeaderSection(
                        modifier = Modifier.fillMaxWidth()
                    )
                    LoginFormSection(
                        emailText = emailText,
                        onEmailTextChange = { emailText = it },
                        passwordText = passwordText,
                        onPasswordTextChange = { passwordText = it },
                        onLoginClick = {},
                        onLinkClick = {},
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            DeviceConfiguration.MOBILE_LANDSCAPE -> {
                Row(
                    modifier = rootModifier.windowInsetsPadding(WindowInsets.displayCutout)
                        .padding(horizontal = 32.dp),
                    horizontalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    LoginHeaderSection(
                        modifier = Modifier.weight(1f)
                    )
                    LoginFormSection(
                        emailText = emailText,
                        onEmailTextChange = { emailText = it },
                        passwordText = passwordText,
                        onPasswordTextChange = { passwordText = it },
                        onLoginClick = {},
                        onLinkClick = {},
                        modifier = Modifier.weight(1f).verticalScroll(rememberScrollState())
                    )
                }
            }

            DeviceConfiguration.TABLET_PORTRAIT,
            DeviceConfiguration.TABLET_LANDSCAPE,
            DeviceConfiguration.DESKTOP -> {
                Column(
                    modifier = rootModifier
                        .verticalScroll(rememberScrollState())
                        .padding(top = 48.dp),
                    verticalArrangement = Arrangement.spacedBy(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoginHeaderSection(
                        alignment = Alignment.CenterHorizontally,
                        modifier = Modifier.widthIn(TABLET_DESKTOP_MAX_WIDTH.dp)
                    )
                    LoginFormSection(
                        emailText = emailText,
                        onEmailTextChange = { emailText = it },
                        passwordText = passwordText,
                        onPasswordTextChange = { passwordText = it },
                        onLoginClick = {},
                        onLinkClick = {},
                        modifier = Modifier.widthIn(max = TABLET_DESKTOP_MAX_WIDTH.dp)
                    )
                }
            }
        }

    }
}

@Composable
fun LoginHeaderSection(
    alignment: Alignment.Horizontal = Alignment.Start,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = alignment
    ) {
        Text(
            text = "Log In",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Capture your thoughts and ideas.",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun PreviewLoginHeaderSectionLight() {
    NoteAppTheme(darkTheme = false) {
        Scaffold {
            LoginHeaderSection()
        }
    }
}

@Preview
@Composable
fun PreviewLoginHeaderSectionDark() {
    NoteAppTheme(darkTheme = true) {
        Scaffold {
            LoginHeaderSection()
        }
    }
}

@Composable
fun LoginFormSection(
    emailText: String,
    onEmailTextChange: (String) -> Unit,
    passwordText: String,
    onPasswordTextChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    onLinkClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        NoteMarkTextField(
            text = emailText,
            onValueChanged = onEmailTextChange,
            label = "Email",
            hint = "john.doe@example.com",
            isSecret = false,
            modifier = Modifier.fillMaxWidth()
        )
        NoteMarkTextField(
            text = passwordText,
            onValueChanged = onPasswordTextChange,
            label = "Password",
            hint = "Password",
            isSecret = true,
            modifier = Modifier.fillMaxWidth()
        )
        NoteMarkButton(
            text = "Login",
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth()
        )
        NoteMarkLink(
            text = "Don't have an account?",
            onClick = onLinkClick,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun PreviewLoginFormSectionLight() {
    NoteAppTheme(darkTheme = false) {
        Scaffold {
            LoginFormSection(
                emailText = "Lorem ipsum",
                onEmailTextChange = {},
                passwordText = "Lorem ipsum",
                onPasswordTextChange = {},
                onLoginClick = {},
                onLinkClick = {}
            )
        }
    }
}

@Preview
@Composable
fun PreviewLoginFormSectionLDark() {
    NoteAppTheme(darkTheme = true) {
        Scaffold {
            LoginFormSection(
                emailText = "Lorem ipsum",
                onEmailTextChange = {},
                passwordText = "Lorem ipsum",
                onPasswordTextChange = {},
                onLoginClick = {},
                onLinkClick = {}
            )
        }
    }
}

