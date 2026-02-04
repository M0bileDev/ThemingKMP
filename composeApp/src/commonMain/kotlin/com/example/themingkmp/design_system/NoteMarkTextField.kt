package com.example.themingkmp.design_system

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.themingkmp.theme.NoteAppTheme

const val SECRET_MASK = '*'

@Composable
fun NoteMarkTextField(
    text: String,
    onValueChanged: (String) -> Unit,
    label: String,
    hint: String,
    isSecret: Boolean,
    modifier: Modifier = Modifier
) {
    var isPasswordVisile by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = onValueChanged,
            visualTransformation = if (isPasswordVisile.not()) PasswordVisualTransformation(mask = SECRET_MASK) else VisualTransformation.None,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.bodyLarge
                )
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            shape = RoundedCornerShape(10.dp),
            trailingIcon = {
                if (isSecret.not()) return@OutlinedTextField

                IconButton(
                    onClick = {
                        isPasswordVisile = isPasswordVisile.not()
                    }
                ) {
                    when {
                        isPasswordVisile -> {
                            Icon(
                                imageVector = Icons.Default.VisibilityOff,
                                contentDescription = "Hide password"
                            )
                        }

                        isPasswordVisile.not() -> {
                            Icon(
                                imageVector = Icons.Default.Visibility,
                                contentDescription = "Show password"
                            )
                        }
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun PreviewNoteMarkTextFieldLight() {
    NoteAppTheme(darkTheme = false) {
        NoteMarkTextField(
            text = "sample@mail.com",
            hint = "Type email",
            label = "Email",
            isSecret = false,
            onValueChanged = {})
    }
}

@Preview
@Composable
fun PreviewNoteMarkTextFieldLight2() {
    NoteAppTheme(darkTheme = false) {
        NoteMarkTextField(
            text = "",
            hint = "Type email",
            label = "Email",
            isSecret = false,
            onValueChanged = {})
    }
}

@Preview
@Composable
fun PreviewNoteMarkTextFieldLight3() {
    NoteAppTheme(darkTheme = false) {
        NoteMarkTextField(
            text = "SecretPassword",
            hint = "Type email",
            label = "Email",
            isSecret = true,
            onValueChanged = {})
    }
}

@Preview
@Composable
fun PreviewNoteMarkTextFieldLight4() {
    NoteAppTheme(darkTheme = false) {
        NoteMarkTextField(
            text = "",
            hint = "Type email",
            label = "Email",
            isSecret = true,
            onValueChanged = {})
    }
}

@Preview
@Composable
fun PreviewNoteMarkTextFieldDark() {
    NoteAppTheme(darkTheme = true) {
        NoteMarkTextField(
            text = "sample@mail.com",
            hint = "Type email",
            label = "Email",
            isSecret = false,
            onValueChanged = {})
    }
}

@Preview
@Composable
fun PreviewNoteMarkTextFieldDark2() {
    NoteAppTheme(darkTheme = true) {
        NoteMarkTextField(
            text = "",
            hint = "Type email",
            label = "Email",
            isSecret = false,
            onValueChanged = {})
    }
}

@Preview
@Composable
fun PreviewNoteMarkTextFieldDark3() {
    NoteAppTheme(darkTheme = true) {
        NoteMarkTextField(
            text = "SecretPassword",
            hint = "Type email",
            label = "Email",
            isSecret = true,
            onValueChanged = {})
    }
}

@Preview
@Composable
fun PreviewNoteMarkTextFieldDark4() {
    NoteAppTheme(darkTheme = true) {
        NoteMarkTextField(
            text = "",
            hint = "Type email",
            label = "Email",
            isSecret = true,
            onValueChanged = {})
    }
}