package com.example.themingkmp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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

@Composable
fun LoginScreen() {
    var emailText by rememberSaveable { mutableStateOf("") }
    var passwordText by rememberSaveable { mutableStateOf("") }

    //handle window insets
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.statusBars
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
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
                .consumeWindowInsets(WindowInsets.navigationBars),
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
}

@Composable
fun LoginHeaderSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
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